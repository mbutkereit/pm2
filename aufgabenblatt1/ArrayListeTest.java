package aufgabenblatt1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author marvin
 *
 */
public class ArrayListeTest {

	@Test
	public void testErstesElementZahl() {
		ArrayListe<Integer> list =new ArrayListe<Integer>();
		list.hinzufuegen(43);
		Boolean erstesElement = Main.erstesElementZahl(list);
		assertEquals(true,erstesElement);
		
		ArrayListe<String> list2 =new ArrayListe<String>();
		list2.hinzufuegen("test");
		erstesElement = Main.erstesElementZahl(list2);
		assertEquals(false,erstesElement);
	}
	
	@Test
	public void testKleinstesElement() {
		ArrayListe<Integer> list =new ArrayListe<Integer>();
	}
	
	@Test
	public void testAnzahlDerElemente() {
		ArrayListe<Integer> list =new ArrayListe<Integer>();
		list.hinzufuegen(21);
		list.hinzufuegen(42);
		assertEquals(2,list.getAnzahlElemente());
	}
	@Test
	public void testEntfernenEinesObjekts() {
		ArrayListe<Integer> list =new ArrayListe<Integer>();
	}
	@Test
	public void testEntfernenElementAnIndex() {
		ArrayListe<Integer> list =new ArrayListe<Integer>();
	}
	@Test
	public void testHinzufügenEinesObjektes() {
		ArrayListe<Integer> list =new ArrayListe<Integer>();
		list.hinzufuegen(21);
        assertEquals(21,list.get(0));
	}

	@Test
	public void testToString() {
		ArrayListe<Integer> list =new ArrayListe<Integer>();
		list.hinzufuegen(21);
		list.hinzufuegen(42);
		assertEquals("Es sind 2 Elemente.",list.toString());
		list.hinzufuegen(21);
		assertEquals("Es sind 3 Elemente.",list.toString());
	}
	
	@Test
	public void testMitUpperbound() {
		ArrayListe<Integer> list =new ArrayListe<Integer>();
		list.hinzufuegen(23);
		list.hinzufuegen(43);
		list.hinzufuegen(120);
		list.hinzufuegen(1);
		Object element = list.getKleinstesElement();
		assertEquals(1,(int) element);
		
	}

}
