package aufgabenblatt3;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Eine Übersicht über alle hinaus und hineinfahrenden zügen.
 */
public class ZugUebersicht extends Application implements Observer {
	
	/**
	 * Haptpanel um die Zuege anzuzeigen.
	 */
	private GridPane hauptpane;

	/**
	 * Zeichnet die fuer den Bahnhof notwendigen sachen.
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

		Simulation simulation = new Simulation(new Rangierbahnhof(Bahnhof.ANZAHL_DER_GLEISE));
		simulation.addObserver(this);

		for (int i = 0; i <  Bahnhof.ANZAHL_DER_GLEISE; i++) {
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
					case ArbeitStrategy.AUSPARKEN:
						this.removeNodeByRowColumnIndex(lokfuehrer.getGleis(),
								0);
						hauptpane.add(zeichner.createAbstellGleis(), 0,
								lokfuehrer.getGleis());
						break;
					case ArbeitStrategy.EINPARKEN:
						this.removeNodeByRowColumnIndex(lokfuehrer.getGleis(),
								0);
						hauptpane.add(zeichner.createBesetzterAbstellGleis(),
								0, lokfuehrer.getGleis());
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
						if (GridPane.getRowIndex(node) == row
								&& GridPane.getColumnIndex(node) == column) {
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
