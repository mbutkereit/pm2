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
		
		list.hinzufuegen(21);
		list.hinzufuegen(60);
		list.hinzufuegen(-5);
		list.hinzufuegen(25);
		assertEquals(-5,(int)list.getKleinstesElement());
		
		
		list =new ArrayListe<Integer>();
		list.hinzufuegen(21);
		list.hinzufuegen(60);
		list.hinzufuegen(0);
		list.hinzufuegen(25);
		assertEquals(0,(int)list.getKleinstesElement());

		
		list =new ArrayListe<Integer>();
		list.hinzufuegen(21);
		list.hinzufuegen(60);
		list.hinzufuegen(25);
		assertEquals(21,(int)list.getKleinstesElement());
	}
	
	@Test
	public void testKleinstesElementUpperbound() {
		
		ArrayListe<Integer> list =new ArrayListe<Integer>();
		
		list.hinzufuegen(21);
		list.hinzufuegen(60);
		list.hinzufuegen(-5);
		list.hinzufuegen(25);
		assertEquals(-5,(int)list.upperBoundKleinstesElement());
		
		
		list =new ArrayListe<Integer>();
		list.hinzufuegen(21);
		list.hinzufuegen(60);
		list.hinzufuegen(0);
		list.hinzufuegen(25);
		assertEquals(0,(int)list.upperBoundKleinstesElement());

		
		list =new ArrayListe<Integer>();
		list.hinzufuegen(21);
		list.hinzufuegen(60);
		list.hinzufuegen(25);
		assertEquals(21,(int)list.upperBoundKleinstesElement());
	}
	
	@Test
	public void testAnzahlDerElemente() {
		ArrayListe<Integer> list =new ArrayListe<Integer>();
		list.hinzufuegen(21);
		list.hinzufuegen(42);
		assertEquals(2,list.getAnzahlElemente());
	}
	
	@Test
	public void testEntfernenEinesObjekts() {;
		ArrayListe<Integer> list =new ArrayListe<Integer>();
		Integer first = 42;
		list.hinzufuegen(first);
		list.hinzufuegen(21);
		
		list.entfernen(first);
		assertEquals(21,(int)list.get(0));
		assertEquals(1,list.getAnzahlElemente());
	}
	@Test
	public void testEntfernenElementAnIndex() {
		ArrayListe<Integer> list =new ArrayListe<Integer>();
		list.hinzufuegen(42);
		list.hinzufuegen(21);
		
		list.entfernenElementeAnIndex(0);;
		assertEquals(21,(int)list.get(0));
		assertEquals(1,list.getAnzahlElemente());
		
		
		list =new ArrayListe<Integer>();
		list.hinzufuegen(42);
		list.hinzufuegen(21);
		list.hinzufuegen(45);
		
		list.entfernenElementeAnIndex(2);;
		assertEquals(42,(int)list.get(0));
		assertEquals(2,list.getAnzahlElemente());
	}
	@Test
	public void testHinzufügenEinesObjektes() {
		ArrayListe<Integer> list =new ArrayListe<Integer>();
		list.hinzufuegen(21);
        assertEquals(21,(int)list.get(0));
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

}
