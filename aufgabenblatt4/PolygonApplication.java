package aufgabenblatt4;

import javafx.application.Application;
import javafx.stage.Stage;

public class PolygonApplication extends Application {
	
	/**
	 * Start der Anwendung.
	 */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    @Override
    public void start(Stage primaryStage) {;
    	PolygonListController controller = new PolygonListController();
        controller.erstelleEinPolygonTabelle(primaryStage);     
    }
}