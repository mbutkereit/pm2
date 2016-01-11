package aufgabenblatt4;

import java.util.List;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 * Eine Klasse um ein Polygon zu Zeichnen.
 */
public class PolygonDarstellung extends BorderPane implements
		ListChangeListener<Polygon> {

	/**
	 * Die PolygonVerwalter Klasse.
	 */
	private PolygonVerwalter verwalter;

	/**
	 * Konstruktor.
	 */
	public PolygonDarstellung(PolygonVerwalter verwalter) {
		this.setStyle("-fx-background-color: #FFFFFF;");
		this.verwalter = verwalter;
		verwalter.addListener(this);
		this.setOnMouseClicked(event -> {
			Polygon aktivePolygon = this.verwalter.getAktivesElement();
			aktivePolygon.addPoint(event.getX(), event.getY());
		});
	}

	/**
	 * Methode um ein Polygon zu Zeichnen.
	 */
	private Path zeichnePolygon(Polygon poly, Color color) {
		Path path = new Path();
		if (poly != null && poly.size() > 0) {
			List<Point> points = poly.getPoints();
			path.setStrokeWidth(1);
			path.setStroke(color);
			for (int i = 0; points.size() > i; i++) {
				Point current = points.get(i);
				if (i == 0) {
					MoveTo moveTo = new MoveTo();
					moveTo.setX(current.getX());
					moveTo.setY(current.getY());
					this.addEllipse(current.getX(), current.getY(),color);
					path.getElements().add(moveTo);
				} else {
					LineTo lineTo1 = new LineTo();
					lineTo1.setX(current.getX());
					lineTo1.setY(current.getY());
					this.addEllipse(current.getX(), current.getY(),color);
					path.getElements().add(lineTo1);
				}
			}
			return path;
		}
		return path;
	}

	/**
	 * Zeichnet einen Punkt an eine Position.
	 */
	private void addEllipse(double x , double y, Color color){
		Ellipse ellipse = new Ellipse();
		ellipse.setCenterX(x);
		ellipse.setCenterY(y);
		ellipse.setRadiusX(5);
		ellipse.setRadiusY(5);
		ellipse.fillProperty().set(color);
		this.getChildren().add(ellipse);
	}
	
	/**
	 * Zeichnet alle Polygone.
	 */
	public void zeichnePolgyone() {
		this.getChildren().removeAll();
		this.getChildren().add(
				this.zeichnePolygon(
						this.verwalter.getAktivesElement(),
						Color.RED)
		);
		for (Polygon poly : this.verwalter) {
			this.getChildren().add(this.zeichnePolygon(poly,Color.BLACK));
		}
	}

	@Override
	public void onChanged(
			javafx.collections.ListChangeListener.Change<? extends Polygon> arg0) {
		this.zeichnePolgyone();

	}

}
