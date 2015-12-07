package aufgabenblatt3;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

/**
 * Eine übersicht über alle hinaus und hineinfahrenden zügen.
 */
public class ZugUebersicht extends Application implements Observer {

	/**
	 * Haptpanel um die Züge anzuzeigen.
	 */
	private GridPane hauptpane;

	/**
	 * Zeichnet die für den Bahnhof notwendigen sachen.
	 */
	private ZeichneBahnhof zeichner;

	/**
	 * Main Methode
	 */
	public static void main(String[] args) {
		ZugUebersicht.launch(args);
	}

	/**
	 * Konstruktor.
	 */
	public ZugUebersicht() {
		hauptpane = new GridPane();
		zeichner = new ZeichneBahnhof();
	}

	@Override
	public void start(Stage hauptBuehne) throws Exception {
		hauptBuehne.setTitle("Zug abstell Gleis");
		;
		hauptBuehne.setScene(new Scene(hauptpane, 300, 250));

		Simulation simulation = new Simulation();
		simulation.addObserver(this);

		int anzahlDerGleise = 6;

		for (int i = 0; i < anzahlDerGleise; i++) {
			hauptpane.add(this.zeichner.createAbstellGleis(), 0, i);
		}

		hauptBuehne.show();
		new Thread(simulation).start();

	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Simulation && arg instanceof Lokfuehrer) {

			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					Lokfuehrer lokfuehrer = (Lokfuehrer) arg;

					switch (lokfuehrer.getJobID()) {
					case AufgabeStrategy.AUSPARKEN:
						this.removeNodeByRowColumnIndex(lokfuehrer.getGleis(), 0);
						hauptpane.add(zeichner.createAbstellGleis(), 0, lokfuehrer.getGleis());
						break;
					case AufgabeStrategy.EINPARKEN:
						this.removeNodeByRowColumnIndex(lokfuehrer.getGleis(), 0);
						hauptpane.add(zeichner.createBesetzterAbstellGleis(), 0, lokfuehrer.getGleis());
						break;
					}

				}

				/**
				 * Entferne ein Element an einen Spezialen Index.
				 */
				public void removeNodeByRowColumnIndex(int row, int column) {
					Node result = null;
					ObservableList<Node> childrens = hauptpane.getChildren();
					for (Node node : childrens) {
						if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
							result = node;
							break;
						}
					}
					if (result != null) {
						childrens.remove(result);
					}
				}
			});

		}
	}

}
