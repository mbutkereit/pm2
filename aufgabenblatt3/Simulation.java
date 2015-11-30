package aufgabenblatt3;

import java.util.Observable;


public class Simulation extends Observable implements Runnable {

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
				this.setChanged();
				this.notifyObservers(lokfuehrer1);
				Lokfuehrer lokfuehrer2 = new Lokfuehrer(new ArbeitEinparken(this.bahnhof,new Zug(),(int)Math.round(Math.random()*bahnhof.getGleis())));
				lokfuehrer2.start();
				this.setChanged();
				this.notifyObservers(lokfuehrer2);
			} catch (InterruptedException e) {

			}
		}
	}

}
