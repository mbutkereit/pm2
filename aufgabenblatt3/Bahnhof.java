package aufgabenblatt3;

/**
 * Ein Interface um ein Bahnhof zu definieren.
 */
public interface Bahnhof {
	
	/**
	 * Die Ausfahrt eines Zuges.
	 * @throws LeeresGleisException 
	 */
	public void zugBearbeiten(Zug zug, int gleis) throws LeeresGleisException;
	
	/**
	 * Die Anzahl der Gleise.
	 */
	public int getGleis();
}
