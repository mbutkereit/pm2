package aufgabenblatt2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Rechner {

	private Map<Operation, BinaryOperator<Double>> mapMitRechnenArten;

	public enum Operation {
		ADDITION, SUBTRAKTION, MULTIPLIKATION, DIVISION
	}

	public Rechner() {
		mapMitRechnenArten = new HashMap<Operation, BinaryOperator<Double>>();

		mapMitRechnenArten.put(Operation.ADDITION, (x, y) -> x + y);
		mapMitRechnenArten.put(Operation.MULTIPLIKATION, (x, y) -> x * y);
		mapMitRechnenArten.put(Operation.DIVISION, (x, y) -> x / y);
		mapMitRechnenArten.put(Operation.SUBTRAKTION, (x, y) -> x - y);
	}

	double berechne(Operation berechnung, double ersterWert, double zweiterWert) {
		return mapMitRechnenArten.get(berechnung)
				.apply(ersterWert, zweiterWert);
	}
}
