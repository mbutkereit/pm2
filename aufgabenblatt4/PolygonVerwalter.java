package aufgabenblatt4;

import java.util.LinkedList;
import java.util.List;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;

/**
 * Eine Klasse welche eine liste von Polygonen Verwaltet.
 */
public class PolygonVerwalter extends ObservableListBase<Polygon> implements
		ListChangeListener<Point> {

	/**
	 * Das Aktive Polygon.
	 */
	private Polygon aktivePolygon;

	/**
	 * Liste aller gespeicherten Polygone.
	 */
	List<Polygon> listeDerPolygone;

	/**
	 * Konstruktor.
	 */
	public PolygonVerwalter() {
		this.listeDerPolygone = new LinkedList<Polygon>();
		this.aktivePolygon = new Polygon();
		this.aktivePolygon.addListener(this);
	}

	@Override
	public Polygon get(int index) {
		return listeDerPolygone.get(index);
	}

	/***
	 * Methode um das Aktive element zu Wechseln.
	 */
	public void uebernehmenAktivesElement(ActionEvent event) {
		if (this.aktivePolygon != null) {
			this.beginChange();
			this.nextAdd(this.listeDerPolygone.size(),
					this.listeDerPolygone.size() + 1);
			this.listeDerPolygone.add(this.aktivePolygon);
			this.aktivePolygon = new Polygon();
			this.aktivePolygon.addListener(this);
			this.endChange();
		}
	}

	/***
	 * Methode um das Aktive element zu Wechseln.
	 */
	public void uebernehmenAktivesElement() {
		this.uebernehmenAktivesElement(null);
	}

	/**
	 * Getter für das AktiveElement.
	 */
	public Polygon getAktivesElement() {
		return this.aktivePolygon;
	}

	@Override
	public int size() {
		return this.listeDerPolygone.size();
	}

	@Override
	public void onChanged(ListChangeListener.Change<? extends Point> arg0) {
		this.beginChange();
		// fake position.
		this.nextUpdate(0);
		this.endChange();

	}

}
