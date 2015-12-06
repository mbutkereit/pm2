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
		try {
			this.aufgabe.arbeiten();
			System.err.println(this);
		} catch (LeeresGleisException e) {
			System.err.println("Nichts gemacht.");
		}

	}

	/**
	 * Getter für die Gleisnummer.
	 */
	public int getGleis() {
		return this.aufgabe.getGleis();
	}
	
	/**
	 * Getter für die JobID.
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
