package aufgabenblatt2;

import java.util.List;

public class Rennabbruch extends Thread {
	List<Rennauto> list;

	public Rennabbruch(List<Rennauto> list) {
		this.list = list;
	}

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
