package aufgabenblatt3;

/**
 * Ein Lokfuehrer fuer ein Bahnhof.
 *
 */
public class Lokfuehrer extends Thread {

	/**
	 * Die durchzuführende Tätigkeit.
	 */
	private AufgabeStrategy aufgabe;

	/**
	 * Konstruktor.
	 */
	public Lokfuehrer(AufgabeStrategy aufgabe) {
		this.aufgabe =aufgabe;
	}

	/**
	 * Ausführen der Taetigkeit.
	 */
	public void run() {
		this.aufgabe.arbeiten();
		System.err.println(this);
	}
	
	/**
	 * Ausführen der Taetigkeit.
	 */
	public int getGleis() {
		return this.aufgabe.getGleis();
	}
	
	/**
	 * Ausführen der Taetigkeit.
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
