package aufgabenblatt3;

/**
 * Die Arbeit einen Zug auszuparken.
 */
public class ArbeitAusparken implements AufgabeStrategy {
	
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
	public void arbeiten() {
		arbeitsPlatz.zugAusfahren(gleis);
	}

	/**
	 * Ausgabe des Zustandes.
	 */
	public String toString() {
		return "ein Zug vom " + gleis + " Ausgeparkt.";
	}

}
