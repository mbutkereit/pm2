package aufgabenblatt4;

import java.util.LinkedList;
import java.util.List;

import javafx.collections.ObservableListBase;

/**
 * Eine Klasse für ein Polygon.
 */
public class Polygon extends ObservableListBase<Point> implements
		Comparable<Polygon> {

	/**
	 * Der Polygon name.
	 */
	public String name;

	/**
	 * Eine Liste von Punkten.
	 */
	private List<Point> points;

	/**
	 * Konstruktor.
	 */
	public Polygon() {
		this.name = "Polygon mit ";
		this.points = new LinkedList<Point>();
	}

	/**
	 * Fügt ein Punkt hinzu.
	 */
	public void addPoint(double x, double y) {
		this.beginChange();
		this.add(new Point(x, y));
		this.endChange();
	}
	@Override
	public boolean add(Point point){
		this.nextAdd(this.points.size(), this.points.size() + 1);
		this.points.add(point);
		return true;
	}

	@Override
	public int compareTo(Polygon o) {
		return points.size() - o.getPoints().size();
	}

	/**
	 * Gibt die liste der Punkte an.
	 */
	public List<Point> getPoints() {
		return this.points;
	}

	/**
	 * Getter for name.
	 */
	public String getName() {
		return this.name + this.points.size() + " Punkten";
	}

	@Override
	public Point get(int index) {
		return this.points.get(index);
	}

	@Override
	public int size() {
		return this.points.size();
	}

}
