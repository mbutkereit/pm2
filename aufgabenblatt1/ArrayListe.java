package aufgabenblatt1;

/**
 * 
 * @author marvin
 *
 * @param <T>
 */
public class ArrayListe<T extends Comparable<T>> {

	/**
	 * Anzahl der vorhandenen elemente.
	 */
	private int anzahlElemente;

	/**
	 * Inhalts Container.
	 */
	private Object[] elemente;

	/**
	 * Konstruktor.
	 */
	public ArrayListe() {
		elemente = new Object[0];
	}

	/**
	 * 
	 * @param element
	 */
	public void hinzufuegen(T element) {
		Object[] newElementeArray = new Object[elemente.length + 1];
		for (int i = 0; i < elemente.length; i++) {
			newElementeArray[i] = elemente[i];
		}

		anzahlElemente = newElementeArray.length;
		newElementeArray[anzahlElemente - 1] = element;
		elemente = newElementeArray;
	}

	public Object get(int index) throws IndexOutOfBoundsException {
		if (elemente.length < index) {
			throw new IndexOutOfBoundsException();
		}
		return elemente[index];

	};

	/**
	 * 
	 * @param element
	 */
	public void entfernen(T element) {
		for (int i = 0; i < elemente.length; i++) {
			if (elemente[i] == element) {
				elemente[i] = null;
				anzahlElemente--;
				break;
			}
			;
		}
	}

	/**
	 * 
	 * @param index
	 */
	public void entfernenElementeAnIndex(int index) {
		elemente[index] = null;
		anzahlElemente--;
	}

	/**
	 * 
	 * @return
	 */
	public int getAnzahlElemente() {
		return elemente.length;
	}

	/**
  * 
  */
	public String toString() {
		return "Es sind " + getAnzahlElemente() + " Elemente.";

	}

	/**
	 * 
	 * @return
	 */
	public Object getKleinstesElement() {
		/*
		boolean istSet = false;
		int zahl;
		// nur möglich wenn das element number ist;
		for (int i = 0; i < elemente.length; i++) {
			if (elemente[i] instanceof Number) {
				if (istSet == false) {
					zahl = (int) elemente[i];
					istSet = true;
				}
			}
		}*/
		if(elemente[0] instanceof Number){
		Object activeCurrent = elemente[0];
		for (int i = 0; i < elemente.length; i++) {
			Object test = elemente[i];
			if(	(int)test<(int)activeCurrent){
				activeCurrent =test;
			}

		}
		return (Object)activeCurrent;
		}
		return null;
		
	}
	
	/**
	 * Nur möglich mit Upperbound
	 */
	private Object upperBoundKleinstesElement(){
		T activeCurrent = (T)elemente[0];
		for (int i = 0; i < elemente.length; i++) {
			T test = (T) elemente[i];
			if(	test.compareTo(activeCurrent) == -1){
				activeCurrent =test;
			}

		}
		return (Object)activeCurrent;
		
	}
}
