package aufgabenblatt3;

/**
 * Ein Interface um ein Bahnhof zu definieren.
 */
public interface Bahnhof {
	/**
	 * Anzahl der Gleise.
	 */
	public static final int ANZAHL_DER_GLEISE = 5;
	
	/**
	 * Die Ausfahrt eines Zuges.
	 * 
	 * @throws LeeresGleisException,IndexOutOfBoundsException
	 */
	public void zugBearbeiten(Zug zug, int gleis) throws LeeresGleisException,IndexOutOfBoundsException;

	/**
	 * Die Anzahl der Gleise.
	 */
	public int getGleis();
}
