package aufgabenblatt2;

/**
 * 
 * @author marvin
 *
 */
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
<<<<<<< HEAD
	 * 
=======
	 * Name des Rennfahrers.
>>>>>>> 61566b5572e37aafd2e81f95b9b42af2de136b9b
	 */
	private String name;

	/**
<<<<<<< HEAD
	 * 
=======
	 * Zeit wenn das Auto zum stehen kommt.
>>>>>>> 61566b5572e37aafd2e81f95b9b42af2de136b9b
	 */
	private double endZeit;

	/**
<<<<<<< HEAD
=======
	 * Konstruktor.
>>>>>>> 61566b5572e37aafd2e81f95b9b42af2de136b9b
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
<<<<<<< HEAD
 * 
 */
=======
	 * Thread Method.
	 * 
	 * Rennauto fahrt die Strecke ab.
	 */
>>>>>>> 61566b5572e37aafd2e81f95b9b42af2de136b9b
	public void run() {
		double startTime = System.currentTimeMillis();
		double value = Math.round((Math.random() * 4));
		int gefahreneMeter = 0;
		while (true) {
			try {
				sleep(800 + ((int) value * 100));
				gefahreneMeter += this.durchschnittsGeschwindigkeit;
				System.out.println("Fahrer:" + this.name + " : "
						+ gefahreneMeter + "/" + laengeDerStrecke);
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
<<<<<<< HEAD

	/**
 * 
 */
	public int compareTo(Rennauto auto) {
		if (this.endZeit < auto.endZeit) {
			return -1;
		} else if (this.endZeit > auto.endZeit) {
			return 1;
		}
		return 0;
	}

	/**
 * 
 */
=======
	
	/**
	 * CompareTo um die Rennautos nach Stop Zeiten zu Sortieren.
	 */
	public int compareTo(Rennauto auto){
		return (int)(this.endZeit - auto.endZeit);
	}

	/**
	 * Ausgabe der gefahrenen Zeit.
	 */
>>>>>>> 61566b5572e37aafd2e81f95b9b42af2de136b9b
	public String toString() {
		return "Fahrer:" + this.name + " : " + this.endZeit / 1000
				+ " Sekunden";
	}
}
