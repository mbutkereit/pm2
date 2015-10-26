package aufgabenblatt2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

/**
 * Eine Klasse welche die Grundrechnen Arten behandelt.
 *
 */
public class Rechner {

	/**
	 * Map mit den Rechen Operationen.
	 */
	private Map<Operation, BinaryOperator<Double>> mapMitRechnenArten;

	/**
	 *  Liste der Operationen.
	 */
	public enum Operation {
		ADDITION, SUBTRAKTION, MULTIPLIKATION, DIVISION
	}

	/**
	 * Konstruktor.
	 */
	public Rechner() {
		mapMitRechnenArten = new HashMap<Operation, BinaryOperator<Double>>();

		mapMitRechnenArten.put(Operation.ADDITION, (x, y) -> x + y);
		mapMitRechnenArten.put(Operation.MULTIPLIKATION, (x, y) -> x * y);
		mapMitRechnenArten.put(Operation.DIVISION, (x, y) -> x / y);
		mapMitRechnenArten.put(Operation.SUBTRAKTION, (x, y) -> x - y);
	}

	/**
	 * Benutzt die Lampda der Operation und verwendet die Werte.
	 * 
	 * @param berechnung
	 * @param ersterWert
	 * @param zweiterWert
	 * @return
	 */
	double berechne(Operation berechnung, double ersterWert, double zweiterWert) {
		return mapMitRechnenArten.get(berechnung)
				.apply(ersterWert, zweiterWert);
	}
}
