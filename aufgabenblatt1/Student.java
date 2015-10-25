package aufgabenblatt1;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Eine Klasse welche einen Studenten Representieren soll.
 *
 */
public class Student implements Comparable<Student>, Comparator<Student> {

	/**
	 * Der Vorname des Studenten.
	 */
	private String vorname;

	/**
	 * Der Nachname des Studenten.
	 */
	private String nachname;

	/**
	 * Die Matrikelnummer des Studenten
	 */
	private int matrikelnummer;

	/**
	 * Eine Liste der erbrachten Prufungsleistungen des Studenten.
	 */
	private List<Pruefungsleistung> listeVonPruefungsleistung;

	/**
	 * Konstruktor.
	 */
	public Student() {
		this.listeVonPruefungsleistung = new LinkedList<Pruefungsleistung>();
	}

	@Override
	public int compareTo(Student student) throws NullPointerException {
		int response = 0;

		if (student == null) {
			throw new NullPointerException();
		}

		if (student.getMatrikelnummer() < this.getMatrikelnummer()) {
			response = 1;
		}

		if (student.getMatrikelnummer() > this.getMatrikelnummer()) {
			response = -1;
		}

		return response;
	}

	/**
	 * Getter fuer Vorname.
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * Setter fuer Vorname.
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * Getter fuer Nachname.
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * Setter fuer Nachname.
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * Getter fuer Matrikelnummer.
	 */
	public int getMatrikelnummer() {
		return matrikelnummer;
	}

	/**
	 * Setter fuer Matrikelnummer.
	 */
	public void setMatrikelnummer(int matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}

	/**
	 * Gibt die Liste an Pruefungsleistung zurueck.
	 */
	public List<Pruefungsleistung> getListeVonPruefungsleistung() {
		return listeVonPruefungsleistung;
	}

	/**
	 * Fuegt eine Pruefungsleistung hinzu.
	 */
	public void addPruefungsleistung(Pruefungsleistung leistung) {
		if (leistung != null) {
			this.listeVonPruefungsleistung.add(leistung);
		}
	}

	@Override
	public int compare(Student student1, Student student2)
			throws NullPointerException {
		// wenn ein studen null ist.
		if (student1 == null || student2 == null) {
			throw new NullPointerException();
		}

		int response = student1.vorname.compareTo(student2.vorname);
		if (response == 0) {
			response = student1.nachname.compareTo(student2.nachname);
		}

		return response;
	}

}
