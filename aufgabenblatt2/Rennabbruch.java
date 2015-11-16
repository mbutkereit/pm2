package aufgabenblatt2;

import java.util.List;

/**
 * Rennabbruch , kann ein Rennenabbrechen mit einer Warscheinlichkeit von etwa
 * 10% jede sekunde.
 */
public class Rennabbruch extends Thread {

	/**
	 * Liste der Rennautos.
	 */
	private List<Rennauto> list;

	/**
	 * Fuegt Rennautoliste hinzu.
	 */
	public void addRennAutoListe(List<Rennauto> liste) {
		if (liste != null) {
			this.list = liste;
		}
	}

	/**
	 * Thread Method
	 * 
	 * Method um das Rennen abzubrechen.
	 */
	public void run() {
		double d;
		if (list.size() > 0) {
			while (!this.isInterrupted()) {
				d = Math.random();
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					break;
				}
				if (d < 0.1) {
					System.out.println("Rennen muss Abgebrochen werden.");
					for (Rennauto auto : list) {
						auto.interrupt();
					}
				}
			}
		}
	}
}
