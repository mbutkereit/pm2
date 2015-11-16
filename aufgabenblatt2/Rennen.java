package aufgabenblatt2;

import java.util.ArrayList;
import java.util.List;

/**
 * Ein Rennen.
 */
public class Rennen {

	/**
	 * Eine Liste aller Rennautos die hier Fahren.
	 */
	private List<Rennauto> rennWagen;

	/**
	 * Die Laenge der Strecke.
	 */
	private int streckenLaenge;

	/**
	 * Eine Thread Klasse die ein Rennabbruch durchfuehren kann.
	 */
	private Rennabbruch rennabbruch;

	/**
	 * Konstruktor.
	 */
	public Rennen(int streckenLaenge, Rennabbruch rennabbruch) {
		this.rennWagen = new ArrayList<Rennauto>();
		this.streckenLaenge = streckenLaenge > 0 ? streckenLaenge : 10;
		this.rennabbruch = rennabbruch;
				if(rennabbruch != null){
					rennabbruch.addRennAutoListe(rennWagen);
				}
	}

	/**
	 * Fügt einen Rennfahrer hinzu.
	 */
	public void addRennFahrer(String name, int durchSchnittsGeschwindigkeit) {
		if (durchSchnittsGeschwindigkeit > 0 && name != null) {
			rennWagen.add(new Rennauto(name, this.streckenLaenge,
					durchSchnittsGeschwindigkeit));
		}
	}

	/**
	 * Beginnt ein Rennen.
	 */
	public void startRennen() {
		if (rennWagen.size() > 0) {
			for (Rennauto car : rennWagen) {
				car.start();
			}
			if (rennabbruch != null) {
				rennabbruch.start();
			}
			this.stopRacing();
		}
	}

	/**
	 * 
	 */
	private void stopRacing() {
		
		for (Rennauto car : rennWagen) {
			try {
				car.join();
			} catch (Exception e) {

			}
		}

		if (rennabbruch != null && rennabbruch.isAlive()) {
			rennabbruch.interrupt();
		}

		this.ausgabeErgebnis();

	}

	/**
	 * Ausgabe des Rennergebnis.
	 */
	public void ausgabeErgebnis() {
		if (rennWagen.size() > 0) {
			rennWagen.sort(null);
			System.out.println("Ergebnis:");
			for (Rennauto auto : rennWagen) {
				System.out.println(auto);
			}
		}
	}

	/**
	 * Main Methode
	 */
	public static void main(String[] args) {
		
		Rennen nuerburgring = new Rennen(10, new Rennabbruch());

		nuerburgring.addRennFahrer("Vettel", 1);
		nuerburgring.addRennFahrer("Alonso", 1);
		nuerburgring.addRennFahrer("Schumi", 2);
		nuerburgring.addRennFahrer("Ricardo", 3);

		nuerburgring.startRennen();

	}

}
