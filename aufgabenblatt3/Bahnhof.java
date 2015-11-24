package aufgabenblatt3;

/**
 * Ein Interface um ein Bahnhof zu definieren.
 */
public interface Bahnhof {
	/**
	 * Die Einfahrt eines Zuges.
	 */
	public void zugEinfahren(Zug zug, int gleis);

	/**
	 * Die Ausfahrt eines Zuges.
	 */
	public Zug zugAusfahren(int gleis);
	
	/**
	 * Die Ausfahrt eines Zuges.
	 */
	public int getGleis();
}
