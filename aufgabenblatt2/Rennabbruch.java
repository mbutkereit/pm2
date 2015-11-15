package aufgabenblatt2;

import java.util.List;
/**
 * 
 * @author marvin
 *
 */
public class Rennabbruch extends Thread {
	
	/**
	 * 
	 */
	private List<Rennauto> list;

	/**
	 * 
	 * @param list
	 */
	public Rennabbruch(List<Rennauto> list) {
		this.list = list;
	}

	/**
	 * 
	 */
	public void run() {
		double d;
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
