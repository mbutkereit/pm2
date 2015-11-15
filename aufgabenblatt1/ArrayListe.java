package aufgabenblatt1;

/**
 * Eigen Implementiertung einer ArrayList.
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
	 * Hinzufuegen von Elementen.
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

	/**
	 * Get ein Element an der Position index.
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public T get(int index) throws IndexOutOfBoundsException {
		if (elemente.length < index) {
			throw new IndexOutOfBoundsException();
		}
		return (T) elemente[index];

	};

	/**
	 * Entfernen von einem T objekt aus der Liste.
	 * 
	 * @param element
	 */
	public void entfernen(T element) {
		Boolean istEntfernt = false;
		for (int i = 0; i < elemente.length; i++) {
			if (elemente[i] == element) {
				elemente[i] = null;
				istEntfernt = true;
				break;
			}
		}
		if (istEntfernt == true) {
			aufrauemenArray();
		}
	}

	/**
	 * Verkleinert das Array um ein Element.
	 */
	private void aufrauemenArray() {
		int neueLaenge = elemente.length - 1;
		Object[] newElementeArray = new Object[neueLaenge];
		int c = 0;
		for (int i = 0; i < elemente.length; i++) {
			if (elemente[i] != null) {
				newElementeArray[c] = elemente[i];
				c++;
			}
		}
		elemente = newElementeArray;
		anzahlElemente = elemente.length;
	}

	/**
	 * Entfernt ein Element aus der Liste an einen Ã¼bergebenen index.
	 * 
	 * @param index
	 */
	public void entfernenElementeAnIndex(int index) {
		elemente[index] = null;
		aufrauemenArray();
	}

	/**
	 * Getter fuer die Anzahl der Elemente.
	 */
	public int getAnzahlElemente() {
		return elemente.length;
	}

	@Override
	public String toString() {
		return "Es sind " + getAnzahlElemente() + " Elemente.";

	}

	/**
	 * Gibt das kleinste element zurück.
	 */
	public T getKleinstesElement() {

		boolean istSet = false;
		Integer zahl = 0;
		// nur möglich wenn das element number ist;
		for (int i = 0; i < elemente.length; i++) {
			if (elemente[i] instanceof Number) {
				if (istSet == false) {
					zahl = (int) elemente[i];
					istSet = true;
				} else if (zahl > (int) elemente[i]) {
					zahl = (int) elemente[i];
				}
			}
		}
		if (istSet == true) {
			return (T) zahl;
		}
		return null;

	}

	/**
	 * Addiere alle Zahlen.
	 */
	public int summeBerechenen() {
		int zahl = 0;
		for (int i = 0; i < elemente.length; i++) {
			if (elemente[i] instanceof Integer) {
				zahl += (int) elemente[i];
			}
		}
		return zahl;
	}

	/**
	 * Nur möglich mit Upperbound
	 */
	public T upperBoundKleinstesElement() {
		T activeCurrent = (T) elemente[0];
		for (int i = 0; i < elemente.length; i++) {
			T test = (T) elemente[i];
			if (test.compareTo(activeCurrent) == -1) {
				activeCurrent = test;
			}

		}
		return activeCurrent;

	}
}
