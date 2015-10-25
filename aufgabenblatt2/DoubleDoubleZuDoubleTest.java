package aufgabenblatt2;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoubleDoubleZuDoubleTest {

	private static final double DELTA = 1e-15;

	@Test
	public void testMultiplikationFunctionalInterface() {
		DoubleDoubleZuDouble functionalInterface;
		functionalInterface = (x, y) -> x * y;
		assertEquals(functionalInterface.werteAus(42, 42), 1764, DELTA);
	}

	@Test
	public void testNullstenBerechnenFunctionalInterface() {
		DoubleDoubleZuDouble functionalInterface;
		functionalInterface = (a, b) -> (-a) / b;
		assertEquals(functionalInterface.werteAus(-2, 5), 0.4, DELTA);
	}
}
