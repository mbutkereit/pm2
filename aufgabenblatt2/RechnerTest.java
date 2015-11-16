package aufgabenblatt2;

import static org.junit.Assert.*;

import org.junit.Test;

import aufgabenblatt2.Rechner.Operation;

/**
 * Test Klasse fuer Rechner.
 */
public class RechnerTest {

	private static final double DELTA = 1e-15;

	@Test
	public void testAdditionRechner() {
		Rechner rechner = new Rechner();
		double addition = rechner.berechne(Operation.ADDITION, 42, 42);
		assertEquals(addition, 84, DELTA);

		addition = rechner.berechne(Operation.ADDITION, 0, 0);
		assertEquals(addition, 0, DELTA);

		addition = rechner.berechne(Operation.ADDITION, 0, 42);
		assertEquals(addition, 42, DELTA);

		addition = rechner.berechne(Operation.ADDITION, 42, 0);
		assertEquals(addition, 42, DELTA);

		addition = rechner.berechne(Operation.ADDITION, 42, -32);
		assertEquals(addition, 10, DELTA);

		addition = rechner.berechne(Operation.ADDITION, -42, -32);
		assertEquals(addition, -74, DELTA);

		addition = rechner.berechne(null, 42, -32);
		assertEquals(addition, 0, DELTA);
	}

	@Test
	public void testMultiplikationRechner() {
		Rechner rechner = new Rechner();
		double addition = rechner.berechne(Operation.MULTIPLIKATION, 42, 42);
		assertEquals(addition, 1764, DELTA);
	}

	@Test
	public void testSubtraktionRechner() {
		Rechner rechner = new Rechner();
		double addition = rechner.berechne(Operation.SUBTRAKTION, 42, 42);
		assertEquals(addition, 0, DELTA);
	}

	@Test
	public void testDivisionRechner() {
		Rechner rechner = new Rechner();
		double addition = rechner.berechne(Operation.DIVISION, 42, 42);
		assertEquals(addition, 1, DELTA);
	}
}
