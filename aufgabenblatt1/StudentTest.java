package aufgabenblatt1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * Test fuer den Student
 */
public class StudentTest {

	@Test
	public void testHinzufuegenVonPruefungsleistungen() {
		Student student = new Student();

		Pruefungsleistung mathe = new Pruefungsleistung("Mathe", 14);
		Pruefungsleistung pm = new Pruefungsleistung("Programmieren", 14);

		student.addPruefungsleistung(mathe);
		student.addPruefungsleistung(pm);

		List<Pruefungsleistung> pruefungsleistungen = student
				.getListeVonPruefungsleistung();

		assertEquals(pruefungsleistungen.size(), 2);

		assertEquals(pruefungsleistungen.get(0), mathe);
		assertEquals(pruefungsleistungen.get(1), pm);
	}

	@Test
	public void testVergleichMitMatrikelnummer() {
		List<Student> students = new ArrayList<Student>();

		Student student1 = new Student();
		student1.setMatrikelnummer(1);
		Student student2 = new Student();
		student2.setMatrikelnummer(2);

		students.add(student2);
		students.add(student1);

		Collections.sort(students);

		assertEquals(true, students.get(0).equals(student1));
		assertEquals(true, students.get(1).equals(student2));

		assertEquals(-1, student1.compareTo(student2));
		assertEquals(0, student1.compareTo(student1));
		assertEquals(1, student2.compareTo(student1));
	}

	@Test
	public void testVergleichMitVornameNachname() {
		List<Student> students = new ArrayList<Student>();
		Student student1 = new Student();
		student1.setVorname("Marvin");
		student1.setNachname("the Paranoid Android");
		Student student2 = new Student();
		student2.setVorname("Tricia");
		student2.setNachname("McMillan");

		Student student3 = new Student();
		student3.setVorname("Marvin");
		student3.setNachname("the Android");

		students.add(student1);
		students.add(student2);
		students.add(student3);

		Collections.sort(students, student1);

		assertEquals(true, students.get(0).equals(student3));
		assertEquals(true, students.get(1).equals(student1));
		assertEquals(true, students.get(2).equals(student2));

		assertEquals(-7, student1.compare(student1, student2));
		assertEquals(7, student1.compare(student2, student1));
		assertEquals(0, student1.compare(student1, student1));
		assertEquals(15, student1.compare(student1, student3));
	}
}
