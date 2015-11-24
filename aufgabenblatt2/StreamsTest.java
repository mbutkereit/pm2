package aufgabenblatt2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class StreamsTest {

	public List<String> anwendenStreamFunktion(List<String> liste) {
		return liste
				.stream()
				.filter(x -> x != null)
				.map(x -> x.toUpperCase())
				.map(x -> {
					String so = x.replaceAll("Ä", "AE").replaceAll("Ä", "AE")
							.replaceAll("Ü", "UE").replaceAll("ß", "SS");
					return so;
				}).map(x -> x.trim())
				.map(str -> str.length() > 8 ? str.substring(0, 8) : str)
				.collect(Collectors.toList());
	}

	@Test
	public void testStreamsZettel() {
		List<String> liste = Arrays.asList(new String[] { "Eingabe ",
				"Äußeres ", null, "Strassen-Feger", " ein Haus" });

		liste = this.anwendenStreamFunktion(liste);

		assertEquals(liste.size(), 4);
		assertEquals(liste.get(0), "EINGABE");
		assertEquals(liste.get(1), "AEUSSERE");
		assertEquals(liste.get(2), "STRASSEN");
		assertEquals(liste.get(3), "EIN HAUS");
	}

	@Test
	public void testStreamsBeispiel() {
		List<String> liste = Arrays.asList(new String[] { "Überlauf " });

		liste = this.anwendenStreamFunktion(liste);

		assertEquals(liste.size(), 1);
		assertEquals(liste.get(0), "UEBERLAU");

	}
}