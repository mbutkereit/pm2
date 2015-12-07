package aufgabenblatt3;

/**
 * Eine Klasse die ein Rangierbahnhof representiert.
 */
public class Rangierbahnhof implements Bahnhof {

	/**
	 * Ein Array von allen Gleisen.
	 */
	private Zug[] gleise;

	/**
	 * Anzahl der Gleise.
	 */
	private int anzahlDerGleise;

	/**
	 * Konstruktor.
	 */
	public Rangierbahnhof(int anzahlDerGleise) {
		this.anzahlDerGleise = anzahlDerGleise;
		this.gleise = new Zug[anzahlDerGleise];
	}

	@Override
	public synchronized void zugBearbeiten(Zug zug, int gleis)
			throws LeeresGleisException, IndexOutOfBoundsException{
		if (anzahlDerGleise > gleis) {
			if (zug != null) {
				this.zugEinfahren(gleis, zug);
			} else {
				this.zugAusfahren(gleis);
			}
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Einen Zug ausfahren.
	 */
	private void zugAusfahren(int gleis) throws LeeresGleisException {
		if (this.gleise[gleis] == null) {
			throw new LeeresGleisException("Das Gleis ist leer.");
		}

		while (this.gleise[gleis] != null) {
			try {
				if (this.gleise[gleis] != null) {
					this.gleise[gleis] = null;
					notify();
					break;
				}
				wait();
			} catch (InterruptedException e) {
				// nichts zu tun
			}
		}
	}

	/**
	 * Einen Zug einfahren.
	 */
	private void zugEinfahren(int gleis, Zug zug) {

		while (this.gleise[gleis] != zug) {
			try {
				if (this.gleise[gleis] == null) {
					this.gleise[gleis] = zug;
					notify();
					break;
				}
				wait();
			} catch (InterruptedException e) {
				// nichts zu machen.
			}
		}
	}

	@Override
	public int getGleis() {
		return this.anzahlDerGleise;
	}

}
