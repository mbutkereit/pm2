package aufgabenblatt3;

/**
 * Ein Lokfuehrer fuer ein Bahnhof.
 *
 */
public class Lokfuehrer extends Thread {

	/**
	 * Die durchzuf�hrende T�tigkeit.
	 */
	private AufgabeStrategy aufgabe;

	/**
	 * Konstruktor.
	 */
	public Lokfuehrer(AufgabeStrategy aufgabe) {
		this.aufgabe =aufgabe;
	}

	/**
	 * Ausf�hren der Taetigkeit.
	 */
	public void run() {
		this.aufgabe.arbeiten();
		System.err.println(this);
	}

	/**
	 * Ausgabe der Taetigkeit.
	 */
	public String toString() {
		return "Ich habe gerade " + aufgabe;
	}

}
