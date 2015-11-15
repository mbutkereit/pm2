package aufgabenblatt2;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Rennen {

	/**
	 * 
	 */
	private List<Rennauto> rennWagen;

	/**
	 * 
	 */
	private int streckenLaenge;

	/**
	 * 
	 */
	private Rennabbruch rennabbruch;


	/**
	 * 
	 * @param streckenLaenge
	 * @param rennabbruch
	 */
	public Rennen(int streckenLaenge, Rennabbruch rennabbruch) {
		this.rennWagen = new ArrayList<Rennauto>();
		this.streckenLaenge = streckenLaenge;
		this.rennabbruch = rennabbruch;
	}

	/**
	 * 
	 * @param name
	 * @param durchSchnittsGeschwindigkeit
	 */
	public void addRennFahrer(String name, int durchSchnittsGeschwindigkeit) {
		if (durchSchnittsGeschwindigkeit > 0 && name != null) {
			rennWagen.add(new Rennauto(name, this.streckenLaenge,
					durchSchnittsGeschwindigkeit));
		}
	}

	/**
	 * 
	 */
	public void startRennen() {
		if (rennWagen.size() > 0) {
			for (Rennauto car : rennWagen) {
				car.start();
			}
			if (rennabbruch != null) {
				rennabbruch.start();
			}
		}
	}

	/**
	 * 
	 */
	public void stopRacing() {

		int imZiel = 0;
		do {
			imZiel = 0;
			for (Rennauto car : rennWagen) {
				if (!car.isAlive()) {
					imZiel++;
				}
			}

		} while (rennWagen.size() > imZiel);
		if (rennabbruch.isAlive()) {
			rennabbruch.interrupt();
		}
		rennWagen.sort(null);
		System.out.println("Ergebnis:");
		for (Rennauto auto : rennWagen) {
			System.out.println(auto);
		}
	}

	public static void main(String[] args) {

		Rennen nuerburgring = new Rennen(100, null);
		// Rennabbruch rennabbruch = new Rennabbruch(rennWagen);

		nuerburgring.addRennFahrer("Vettel", 1);
		nuerburgring.addRennFahrer("Schumi", 2);
		nuerburgring.addRennFahrer("Ricardo", 3);

		nuerburgring.startRennen();
		// rennabbruch.start();

		while (true){
			
		}
	}

}
