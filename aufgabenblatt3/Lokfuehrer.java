package aufgabenblatt3;

/**
 * Ein Lokfuehrer fuer ein Bahnhof.
 *
 */
public class Lokfuehrer extends Thread {

	/**
	 * Die durchzufuehrende Tätigkeit.
	 */
	private ArbeitStrategy aufgabe;

	/**
	 * Konstruktor.
	 */
	public Lokfuehrer(ArbeitStrategy aufgabe) {
		this.aufgabe = aufgabe;
	}

	/**
	 * Auszufuehrende der Taetigkeit.
	 */
	public void run() {
		this.aufgabe.arbeiten();
		System.err.println(this);
	}

	/**
	 * Getter fuer die Gleisnummer.
	 */
	public int getGleis() {
		return this.aufgabe.getGleis();
	}

	/**
	 * Getter fuer die JobID.
	 */
	public int getJobID() {
		return this.aufgabe.getJobID();
	}

	/**
	 * Ausgabe der Taetigkeit.
	 */
	public String toString() {
		return "Ich habe gerade " + aufgabe;
	}

}
