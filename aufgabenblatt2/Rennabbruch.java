package aufgabenblatt2;

import java.util.List;
<<<<<<< HEAD
/**
 * 
 * @author marvin
 *
=======

/**
 * Rennabbruch , kann ein Rennenabbrechen mit
 * einer Warscheinlichkeit von etwa 10% jede sekunde.
>>>>>>> 61566b5572e37aafd2e81f95b9b42af2de136b9b
 */
public class Rennabbruch extends Thread {
	
	/**
<<<<<<< HEAD
	 * 
	 */
	private List<Rennauto> list;

	/**
	 * 
	 * @param list
=======
	 * Liste der Rennautos.
	 */
	List<Rennauto> list;

	/**
	 * Konstruktor.
>>>>>>> 61566b5572e37aafd2e81f95b9b42af2de136b9b
	 */
	public Rennabbruch(List<Rennauto> list) {
		this.list = list;
	}

	/**
<<<<<<< HEAD
	 * 
=======
	 * Thread Method
	 * 
	 * Method um das Rennen abzubrechen.
>>>>>>> 61566b5572e37aafd2e81f95b9b42af2de136b9b
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
