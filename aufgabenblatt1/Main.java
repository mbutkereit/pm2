package aufgabenblatt1;

/**
 * Main Methode.
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Test");

	}

	/**
	 * 
	 * Ueberpruefen ob das erste Element eine Zahl ist.
	 * 
	 * @return boolean
	 * 		 Ist das erste Element eine Zahl TRUE oder FALSE wenn
	 *         nicht.
	 */
	public static <T extends Comparable<T>> boolean erstesElementZahl(
			ArrayListe<T> list) {
		if (list.get(0) instanceof Number) {
			return true;
		}
		return false;
	}

}