package aufgabenblatt3;

import java.util.Observable;

/**
 * Die Simulation des Bahnhofes
 */
public class Simulation extends Observable implements Runnable {

	/**
	 * Die Arbeitsstaette Bahnhof.
	 */
	private Bahnhof bahnhof;

	/**
	 * Konstruktor.
	 */
	public Simulation(Bahnhof bahnhof) {
		this.bahnhof = bahnhof;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
				this.erstelleLokfuehrer();
			} catch (InterruptedException e) {
				System.err.println("Die Simulation wuerde beendet.");
			}
		}
	}

	/**
	 * Erstellt einen Lokfuehrer der einen Zufaelligen job ausuebt.
	 */
	public void erstelleLokfuehrer() {
		Lokfuehrer lokfuehrer;
		ArbeitStrategy arbeit;

		int randomGleis = (int) (Math.random() * bahnhof.getGleis());
		
		if (Math.random() > 0.5) {
			arbeit = new ArbeitAusparken(this.bahnhof,randomGleis);
		} else {
			arbeit =new ArbeitEinparken(this.bahnhof,new Zug(), randomGleis);
		}
		
		lokfuehrer = new Lokfuehrer(arbeit);
		lokfuehrer.start();
		
		this.setChanged();
		this.notifyObservers(lokfuehrer);
	}

}
