package aufgabenblatt3;

/**
 *	Eine Exception die bei einem LeerenGleis gewuerfen wird.
 */
public class LeeresGleisException extends Exception {

	/**
	 * Konstruktor.
	 */
	public LeeresGleisException(String string) {
		super(string);
	}

	/**
	 * Serialversion
	 */
	private static final long serialVersionUID = 1L;

}
