package aufgabenblatt2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class StreamsTest {

	@Test
	public void testAdditionRechner() {
		List<String> liste = Arrays.asList(new String[] { "Eingabe ",
				"Äußeres ", null, "Strassen-Feger", " ein Haus" });

		liste = liste
				.stream()
				.filter(x -> {
					return x != null;
				})
				.map(x -> {
					return x.trim();
				})
				.map(x -> {
					return x.toUpperCase();
				})
				.map(x -> {
					String so = x.replaceAll("Ä", "AE").replaceAll("Ä", "AE")
							.replaceAll("Ü", "UE").replaceAll("ß", "SS");
					return so;
				}).map(x -> {
					return x.trim();
				}).map(str -> {
					return str.length() > 8 ? str.substring(0, 8) : str;
				}).collect(Collectors.toList());
		
		assertEquals(liste.get(0),"EINGABE");
		assertEquals(liste.get(1),"AEUSSERE");
		assertEquals(liste.get(2),"STRASSEN");
		assertEquals(liste.get(3),"EIN HAUS");
	}
}