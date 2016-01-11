package aufgabenblatt4;

/**
 * Eine Klasse die einen Punkt representiert.
 */
public class Point {

	/**
	 * Die x coordinate des Punktes.
	 */
	private double x;

	/**
	 * Die y coordinate des Punktes.
	 */
	private double y;

	/**
	 * Konstruktor.
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Getter fuer die X coordinate.
	 */
	public double getX() {
		return x;
	}

	/**
	 * Getter fuer die Y coordinate.
	 */
	public double getY() {
		return y;
	}

}
