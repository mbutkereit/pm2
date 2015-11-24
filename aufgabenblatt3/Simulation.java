package aufgabenblatt3;

import aufgabenblatt2.Rennabbruch;
import aufgabenblatt2.Rennen;

public class Simulation implements Runnable {

	private static final int anzahlDerGleise = 5;

	private Bahnhof bahnhof;

	public Simulation() {
		this.bahnhof = new Rangierbahnhof(Simulation.anzahlDerGleise);
	}

	@Override
	public void run() {

		while (true) {

			try {
				Thread.sleep(500);
				Lokfuehrer lokfuehrer1 = new Lokfuehrer(new ArbeitAusparken(this.bahnhof,(int)Math.round(Math.random()*bahnhof.getGleis())));
				lokfuehrer1.start();
				Lokfuehrer lokfuehrer2 = new Lokfuehrer(new ArbeitEinparken(this.bahnhof,new Zug(),(int)Math.round(Math.random()*bahnhof.getGleis())));
				lokfuehrer2.start();
			} catch (InterruptedException e) {

			}
		}
	}
	
	/**
	 * Main Methode
	 */
	public static void main(String[] args) {

		Simulation simulation = new Simulation();
		new Thread(simulation).start();

	}

}
