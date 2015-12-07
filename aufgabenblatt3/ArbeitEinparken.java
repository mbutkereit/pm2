package aufgabenblatt3;

/**
 * Die Arbeit einen Zug einzuparken.
 */
public class ArbeitEinparken implements ArbeitStrategy {
	
	/**
	 * Aktueller Bahnhof.
	 */
	private Bahnhof arbeitsPlatz;

	/**
	 * Gleis zum Ausparken.
	 */
	private int gleis;

	/**
	 * Der einzuparkende Zug.
	 */
	private Zug zug;

	/**
	 * Konstruktor.
	 */
	public ArbeitEinparken(Bahnhof arbeitsPlatz, Zug zug, int gleis) {
		this.zug = zug;
		this.gleis = gleis;
		this.arbeitsPlatz = arbeitsPlatz;

	}

	@Override
	public void arbeiten() throws IndexOutOfBoundsException {
		arbeitsPlatz.zugBearbeiten(zug, gleis);
	}

	/**
	 *  Konvertiert zum String.
	 */
	public String toString() {
		return "ein Zug in " + gleis + " Eingeparkt.";
	}

	/**
	 * Getter für die Gleisnummer.
	 */
	public int getGleis() {
		return this.gleis;
	}

	/**
	 * Getter für die JobID.
	 */
	public int getJobID() {
		return ArbeitStrategy.EINPARKEN;
	}

}
