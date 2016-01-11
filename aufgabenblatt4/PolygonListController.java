package aufgabenblatt4;

import javafx.stage.Stage;

/**
 * Die Controller class.
 */
public class PolygonListController {

	/**
	 * Controller fuer das Main Window.
	 */
	public void erstelleEinPolygonTabelle(Stage primaryStage) {
		// Erstellen der Klassen.
		PolygonVerwalter polygonVerwalter = new PolygonVerwalter();
		PolygonDarstellung polyView = new PolygonDarstellung(polygonVerwalter);
		WindowView view = new WindowView(polyView);
		CommandRouter commandRouter = new CommandRouter();
		// Commands Registrieren.
		commandRouter.addSubscriber(new BewegeCommand(polygonVerwalter));

		view.setTableObservable(polygonVerwalter);
		
		// Events Registrieren.
		view.setOnSetzenButton(polygonVerwalter::uebernehmenAktivesElement);
		view.setOnEingabeButton(event -> commandRouter.handleEingabe(view.getInputFieldValue()));
		
		view.getViewValue(primaryStage);

		primaryStage.show();
	}
}
