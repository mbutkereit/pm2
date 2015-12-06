package aufgabenblatt3;

import java.util.Observable;

/**
 * 
 */
public class Simulation extends Observable implements Runnable {

	/**
	 * 
	 */
	private static final int anzahlDerGleise = 5;

	/**
	 * 
	 */
	private Bahnhof bahnhof;

	/**
	 * 
	 */
	public Simulation() {
		this.bahnhof = new Rangierbahnhof(Simulation.anzahlDerGleise);
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
	 * Erstellt einen Lokfuehrer der einen Zufälligen job ausübt.
	 */
	public void erstelleLokfuehrer() {
		Lokfuehrer lokfuehrer;
		if (Math.random() > 0.5) {
			lokfuehrer = new Lokfuehrer(
					new ArbeitAusparken(this.bahnhof, (int) Math.round(Math.random() * bahnhof.getGleis())));
		} else {
			lokfuehrer = new Lokfuehrer(
					new ArbeitEinparken(this.bahnhof, new Zug(), (int) Math.round(Math.random() * bahnhof.getGleis())));

		}
		lokfuehrer.start();
		this.setChanged();
		this.notifyObservers(lokfuehrer);
	}

}
