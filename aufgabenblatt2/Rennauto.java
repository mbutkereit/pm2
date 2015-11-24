package aufgabenblatt2;

/**
 * Ein Rennauto.
 * 
 * Diese ist eine Thread implementierung eines Rennautos.
 */
public class Rennauto extends Thread implements Comparable<Rennauto> {

	/**
	 * Laenge der Strecke.
	 */
	private int laengeDerStrecke;

	/**
	 * Durchschnittsgeschwindigkeit in m/s.
	 */
	private int durchschnittsGeschwindigkeit;

	/**
	 * Name des Rennfahrers.
	 */
	private String name;

	/**
	 * Zeit wenn das Auto zum stehen kommt.
	 */
	private double endZeit;

	/**
	 * Die gefahrenen Meter.
	 */
	private int gefahreneMeter;

	/**
	 * Konstruktor.
	 */
	public Rennauto(String name, int laengeDerStrecke,
			int durchSchnittsGeschwindigkeit) {
		this.name = name != null ? name : "Player";
		this.laengeDerStrecke = laengeDerStrecke;
		this.durchschnittsGeschwindigkeit = durchSchnittsGeschwindigkeit;
		this.gefahreneMeter = 0;
	}

	/**
	 * Thread Method.
	 * 
	 * Rennauto fahrt die Strecke ab.
	 */
	public void run() {
		double startTime = System.currentTimeMillis();
		double value = Math.round((Math.random() * 4));
		while (!this.isInterrupted()) {
			try {
				sleep(800 + ((int) value * 100));
				this.endZeit = (int) (System.currentTimeMillis() - startTime);
				gefahreneMeter += this.durchschnittsGeschwindigkeit;
				if (gefahreneMeter >= this.laengeDerStrecke) {
					gefahreneMeter = laengeDerStrecke;
					ausgebenDerGefahrenenMeter();
					break;
				} else {
					ausgebenDerGefahrenenMeter();
				}
			} catch (InterruptedException e) {
				break;
			} finally {
				this.endZeit = (int) (System.currentTimeMillis() - startTime);
			}
			value = Math.round((Math.random() * 4));
		}
	}

	/**
	 * Gibt die gefahrenen Runden aus.
	 */
	private void ausgebenDerGefahrenenMeter(){
		System.err.println("Fahrer:" + this.name + " : "
				+ gefahreneMeter + "/" + laengeDerStrecke);
	}

	/**
	 * CompareTo um die Rennautos nach Stop Zeiten zu Sortieren.
	 */
	public int compareTo(Rennauto auto) {

		if (this.gefahreneMeter > auto.gefahreneMeter) {
			return -1;
		}
		if (this.gefahreneMeter < auto.gefahreneMeter) {
			return 1;
		}
		return validateByTime(auto);

	}

	/**
	 * Zeitbasierte sortierung.
	 */
	private int validateByTime(Rennauto auto) {
		if (this.endZeit < auto.endZeit) {
			return -1;
		} else if (this.endZeit > auto.endZeit) {
			return 1;
		}
		return 0;
	}

	/**
	 * Ausgabe der gefahrenen Zeit.
	 */
	public String toString() {
		if (this.endZeit > 0) {
			return "Fahrer:" + this.name + " : " + this.endZeit / 1000
					+ " Sekunden";
		}
		return "Fahrer:" + this.name;

	}
}
