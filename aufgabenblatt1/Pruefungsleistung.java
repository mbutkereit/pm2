package aufgabenblatt1;

/**
 * Eine Klasse welche eine Pruefungsleistung representiert.
 * 
 */
public class Pruefungsleistung {

	/**
	 * Name des Modules.
	 */
	private String nameDesModules;

	/**
	 * Wert der Note.
	 */
	private int note;

	/**
	 * Konstruktor.
	 * 
	 * @param nameDesModules
	 * @param note
	 */
	public Pruefungsleistung(String nameDesModules, int note) {
		this.note = note;
		this.nameDesModules = nameDesModules;
	}

	/**
	 * Getter fuer nameDesModules.
	 */
	public String getNameDesModules() {
		return nameDesModules;
	}

	/**
	 * Setter fuer nameDesModules.
	 */
	public void setNameDesModules(String nameDesModules) {
		this.nameDesModules = nameDesModules;
	}

	/**
	 * Getter fuer Note.
	 */
	public int getNote() {
		return note;
	}

	/**
	 * Setter fuer note.
	 */
	public void setNote(int note) {
		this.note = note;
	}
}
