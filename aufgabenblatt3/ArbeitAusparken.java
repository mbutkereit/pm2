package aufgabenblatt3;

/**
 * Die Arbeit einen Zug auszuparken.
 */
public class ArbeitAusparken implements ArbeitStrategy {

	/**
	 * Aktueller Bahnhof.
	 */
	private Bahnhof arbeitsPlatz;

	/**
	 * Gleis zum Ausparken.
	 */
	private int gleis;

	/**
	 * Konstruktor.
	 */
	public ArbeitAusparken(Bahnhof arbeitsPlatz, int gleis) {
		this.gleis = gleis;
		this.arbeitsPlatz = arbeitsPlatz;
	}

	@Override
	public void arbeiten() throws IndexOutOfBoundsException {
		arbeitsPlatz.zugBearbeiten(null, gleis);
	}

	/**
	 * Ausgabe des Zustandes.
	 */
	public String toString() {
		return "ein Zug vom " + gleis + " Ausgeparkt.";
	}

	/**
	 * Gibt das Gleis aus an dem Gearbeitet wird.
	 */
	public int getGleis() {
		return this.gleis;
	}

	/**
	 * Gibt die JobID zurück.
	 */
	public int getJobID() {
		return ArbeitStrategy.AUSPARKEN;
	}

}
