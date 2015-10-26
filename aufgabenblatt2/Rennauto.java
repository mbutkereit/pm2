package aufgabenblatt2;

public class Rennauto extends Thread implements Comparable<Rennauto> {

	/**
	 *  Laenge der Strecke.
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
	 * Konstruktor.
	 * 
	 * @param name
	 * @param laengeDerStrecke
	 * @param durchSchnittsGeschwindigkeit
	 */
	public Rennauto(String name, int laengeDerStrecke,
			int durchSchnittsGeschwindigkeit) {
		this.name = name;
		this.laengeDerStrecke = laengeDerStrecke;
		this.durchschnittsGeschwindigkeit = durchSchnittsGeschwindigkeit;
	}

	/**
	 * Thread Method.
	 * 
	 * Rennauto fahrt die Strecke ab.
	 */
	public void run() {
		double startTime = System.currentTimeMillis();
		double value = Math.round((Math.random() * 4));
		int gefahreneMeter = 0;
		while (true) {
			try {
				sleep(800 + ((int) value * 100));
				gefahreneMeter += this.durchschnittsGeschwindigkeit;
				System.out.println("Fahrer:"+this.name + " : " + gefahreneMeter+"/"+laengeDerStrecke);
				this.endZeit = (int) (System.currentTimeMillis() - startTime);
				if (gefahreneMeter >= this.laengeDerStrecke) {
					this.endZeit = (int) (System.currentTimeMillis() - startTime);
					return;
				}
			} catch (InterruptedException e) {
				return;
			}
			value = Math.round((Math.random() * 4));
		}
	}
	
	/**
	 * CompareTo um die Rennautos nach Stop Zeiten zu Sortieren.
	 */
	public int compareTo(Rennauto auto){
		return (int)(this.endZeit - auto.endZeit);
	}

	/**
	 * Ausgabe der gefahrenen Zeit.
	 */
	public String toString() {
		return "Fahrer:"+this.name + " : " + this.endZeit / 1000+ " Sekunden";
	}
}
