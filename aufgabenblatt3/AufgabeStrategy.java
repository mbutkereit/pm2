package aufgabenblatt3;

/**
 * Interface um die Struktur einer Aufgabe zu definieren.
 */
public interface AufgabeStrategy {
	
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
	 * @throws LeeresGleisException 
	 */
	public void arbeiten() throws LeeresGleisException;
	
	/**
	 *  Gibt die Gleisnummer zurück an der gearbeitet wird.
	 */
	public int getGleis();
	
	/**
	 * Gibt die JobID zurück.
	 */
	public int getJobID();
}
