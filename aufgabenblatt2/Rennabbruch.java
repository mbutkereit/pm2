package aufgabenblatt2;

import java.util.List;

/**
 * Rennabbruch , kann ein Rennenabbrechen mit
 * einer Warscheinlichkeit von etwa 10% jede sekunde.
 */
public class Rennabbruch extends Thread {
	
	/**
	 * Liste der Rennautos.
	 */
	List<Rennauto> list;

	/**
	 * Konstruktor.
	 */
	public Rennabbruch(List<Rennauto> list) {
		this.list = list;
	}

	/**
	 * Thread Method
	 * 
	 * Method um das Rennen abzubrechen.
	 */
	public void run() {
		double d = Math.random();
		while (true) {
			d = Math.random();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				return;
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
