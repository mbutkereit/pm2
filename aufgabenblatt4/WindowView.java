package aufgabenblatt4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Eine Klasse die den Inhalt der Scene fuellt.
 */
public class WindowView {

	/**
	 * Table zum darstellen der Polygon Liste.
	 */
	private TableView<Polygon> table;

	/**
	 * Eingabe Feld fuer die Scriptsprache.
	 */
	private TextField textField;

	/**
	 * Ein Button um das erstellte Polygon zu setzen.
	 */
	private Button setzeButton;

	/**
	 * Ein Button um die Scriptsprache ein zu lesen.
	 */
	private Button eingabe;

	/**
	 * Eine Polygon darstellungs View.
	 */
	private PolygonDarstellung polyView;

	/**
	 * Konstruktor
	 */
	public WindowView(PolygonDarstellung polyView) {
		table = new TableView<Polygon>();
		textField = new TextField();
		eingabe = new Button();
		setzeButton = new Button();
		this.polyView = polyView;
	}

	/**
	 * Erstellt den Scene Inhalt.
	 */
	public Stage getViewValue(Stage primaryStage) {
		primaryStage.setTitle("ZeichenEditor");
		this.setzeButton.setText("Setze/Button");
		this.eingabe.setText("Eingabe");
		
		primaryStage.setResizable(false);

		GridPane root = new GridPane();

		root.setPadding(new Insets(10, 10, 10, 10));
		root.setVgap(5);
		root.setHgap(5);

		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(70);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(30);

		root.getColumnConstraints().addAll(column1, column2);

		root.add(this.polyView, 0, 0, 1, 4);

		root.add(this.setzeButton, 1, 0);
		root.add(this.PolygonTabelle(), 1, 1);
		root.add(this.textField, 1, 2);
		root.add(this.eingabe, 1, 3);
		
		primaryStage.setScene(new Scene(root));
		return primaryStage;
	}

	/**
	 * 
	 * @return
	 */
	private TableView<Polygon> PolygonTabelle() {
		TableColumn<Polygon, String> firstNameCol = new TableColumn<Polygon, String>("Polygon");
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Polygon, String>("name"));
		firstNameCol.resizableProperty().set(false);
		firstNameCol.prefWidthProperty().bind(this.table.widthProperty());
		this.table.getColumns().add(firstNameCol);
		
		return table;
	}

	/**
	 * Event setter fuer Eingabe button.
	 */
	public void setOnEingabeButton(EventHandler<ActionEvent> event) {
		this.eingabe.setOnAction(event);
	}

	/**
	 * Event Setter fuer SetzteButton.
	 */
	public void setOnSetzenButton(EventHandler<ActionEvent> event) {
		this.setzeButton.setOnAction(event);
	}

	/**
	 * Setter fuer das Table Observable.
	 */
	public void setTableObservable(PolygonVerwalter polygonVerwalter) {
		this.table.setItems(polygonVerwalter);
	}

	/**
	 * Gibt den Inhalt des Textfeldes aus.
	 */
	public String getInputFieldValue() {
		return this.textField.getText();
	}
	
}
