package aufgabenblatt3;

/**
 * Interface um die Struktur einer Aufgabe zu definieren.
 */
public interface ArbeitStrategy {
	
	/**
	 * Konstante für eine Aufgabe Ausparken.
	 */
	public final int AUSPARKEN = 0;
	
	/**
	 * Konstante für eine Aufgabe Einparken.
	 */
	public final int EINPARKEN = 1;
	
	/**
	 * Funktion um die Arbeit zu erledigen.
	 * @throws LeeresGleisException,IndexOutOfBoundsException
	 */
	public void arbeiten() throws LeeresGleisException,IndexOutOfBoundsException;
	
	/**
	 *  Gibt die Gleisnummer zurueck an der gearbeitet wird.
	 */
	public int getGleis();
	
	/**
	 * Gibt die JobID zurueck.
	 */
	public int getJobID();
}
