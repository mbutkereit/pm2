package aufgabenblatt3;


import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

public class ZugUebersicht extends Application implements Observer{

	private GridPane hauptpane;
	/**
	 * Main Methode
	 */
	public static void main(String[] args) {
		
		ZugUebersicht.launch(args);
		
	}
	
	public ZugUebersicht(){
		hauptpane = new GridPane();
	}
	
	@Override
	public void start(Stage hauptBuehne) throws Exception {
	 hauptBuehne.setTitle("Zug abstell Gleis");;
	 hauptBuehne.setScene(new Scene(hauptpane,300,250));
	
	 hauptBuehne.show();
	 
		Simulation simulation = new Simulation();
		simulation.addObserver(this);
		
		int anzahlDerGleise = 6;
		for(int i = 0 ; i<anzahlDerGleise;i++){
			hauptpane.add(this.createAbstellGleis(), 0,i);
		}
		new Thread(simulation).start();
		
	}
	private Path createAbstellGleis(){
		Path path = new Path();
		MoveTo moveTo = new MoveTo();
		
		moveTo.setX(0);
		moveTo.setY(100);
		
		LineTo lineTo1 = new LineTo();
		lineTo1.setX(0);
		lineTo1.setY(100);
		
		LineTo lineTo2 = new LineTo();
		lineTo2.setX(0);
		lineTo2.setY(150);
		
		LineTo lineTo3 = new LineTo();
		lineTo3.setX(150);
		lineTo3.setY(150);
		
		MoveTo moveTo1 = new MoveTo();
		moveTo1.setX(0);
		moveTo1.setY(100);
		
		LineTo lineTo4 = new LineTo();
		lineTo4.setX(150);
		lineTo4.setY(100);
		
		path.getElements().add(moveTo);
		path.getElements().add(lineTo1);
		path.getElements().add(lineTo2);
		path.getElements().add(lineTo3);
		path.getElements().add(moveTo1);
		path.getElements().add(lineTo4);
		
		path.setStrokeWidth(1);
		path.setStroke(Color.RED);
		
		return path;
	}


	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Simulation && arg instanceof Lokfuehrer) {

			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					Lokfuehrer lokfuehrer = (Lokfuehrer) arg;
					Simulation simulation = (Simulation) o;
				
					switch (lokfuehrer.getJobID()) {
					case AufgabeStrategy.AUSPARKEN:
						hauptpane.getChildren().remove( 0,
								lokfuehrer.getGleis());
						hauptpane.add(this.createAbstellGleis(), 0,
								lokfuehrer.getGleis());
						break;
					case AufgabeStrategy.EINPARKEN:
						hauptpane.getChildren().remove( 0,
								lokfuehrer.getGleis());
						hauptpane.add(this.createBesetzterAbstellGleis(), 0,
								lokfuehrer.getGleis());
						break;
					}
				}
				private Path createBesetzterAbstellGleis(){
					Path path = this.createAbstellGleis();
					MoveTo moveTo = new MoveTo();
					
					moveTo.setX(10);
					moveTo.setY(105);
					
					LineTo lineTo1 = new LineTo();
					lineTo1.setX(20);
					lineTo1.setY(105);
					
					LineTo lineTo2 = new LineTo();
					lineTo2.setX(20);
					lineTo2.setY(110);
					
					LineTo lineTo3 = new LineTo();
					lineTo3.setX(30);
					lineTo3.setY(110);
					
					LineTo lineTo4 = new LineTo();
					lineTo4.setX(30);
					lineTo4.setY(105);
					
					LineTo lineTo5 = new LineTo();
					lineTo5.setX(35);
					lineTo5.setY(105);
					
					LineTo lineTo6 = new LineTo();
					lineTo6.setX(35);
					lineTo6.setY(110);
					
					LineTo lineTo7 = new LineTo();
					lineTo7.setX(40);
					lineTo7.setY(110);
					
					LineTo lineTo8 = new LineTo();
					lineTo8.setX(40);
					lineTo8.setY(120);
					
					LineTo lineTo9 = new LineTo();
					lineTo9.setX(10);
					lineTo9.setY(120);
					
					LineTo lineTo10 = new LineTo();
					lineTo10.setX(10);
					lineTo10.setY(105);
					
					path.getElements().add(moveTo);
					path.getElements().add(lineTo1);
					path.getElements().add(lineTo2);
					path.getElements().add(lineTo3);
					path.getElements().add(lineTo4);
					path.getElements().add(lineTo5);
					path.getElements().add(lineTo6);
					path.getElements().add(lineTo7);
					path.getElements().add(lineTo8);
					path.getElements().add(lineTo9);
					path.getElements().add(lineTo10);
					
					return path;
					
				}
				
				private Path createAbstellGleis(){
					Path path = new Path();
					MoveTo moveTo = new MoveTo();
					
					moveTo.setX(0);
					moveTo.setY(100);
					
					LineTo lineTo1 = new LineTo();
					lineTo1.setX(0);
					lineTo1.setY(100);
					
					LineTo lineTo2 = new LineTo();
					lineTo2.setX(0);
					lineTo2.setY(150);
					
					LineTo lineTo3 = new LineTo();
					lineTo3.setX(150);
					lineTo3.setY(150);
					
					MoveTo moveTo1 = new MoveTo();
					moveTo1.setX(0);
					moveTo1.setY(100);
					
					LineTo lineTo4 = new LineTo();
					lineTo4.setX(150);
					lineTo4.setY(100);
					
					path.getElements().add(moveTo);
					path.getElements().add(lineTo1);
					path.getElements().add(lineTo2);
					path.getElements().add(lineTo3);
					path.getElements().add(moveTo1);
					path.getElements().add(lineTo4);
					
					path.setStrokeWidth(1);
					path.setStroke(Color.RED);
					
					return path;
				}
			});

		}
	}

}
