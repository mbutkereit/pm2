package aufgabenblatt3;

public class ArbeitEinparken implements AufgabeStrategy{
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
	public ArbeitEinparken(Bahnhof arbeitsPlatz,Zug zug, int gleis){
		this.zug = zug;
		this.gleis = gleis;
		this.arbeitsPlatz = arbeitsPlatz;
		
		
	}
	@Override
	public void arbeiten() {
		arbeitsPlatz.zugEinfahren(zug, gleis);
	}
	
	public String toString(){
		return "ein Zug in " + gleis + " Eingeparkt.";
	}

}
