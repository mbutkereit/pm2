package aufgabenblatt3;

/**
 * Eine Klasse die ein Rangierbahnhof representiert.
 */
public class Rangierbahnhof implements Bahnhof {

	/**
	 * Ein Array von allen Gleisen.
	 */
	private Zug[] gleise;
	
	private int anzahlDerGleise;

	/**
	 * Konstruktor.
	 */
	public Rangierbahnhof() {
		this(42);
	}

	/**
	 * Konstruktor.
	 */
	public Rangierbahnhof(int anzahlDerGleise) {
		this.anzahlDerGleise = anzahlDerGleise;
		this.gleise = new Zug[anzahlDerGleise];
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized void zugEinfahren(Zug zug, int gleis) {
		if (anzahlDerGleise > gleis) {
			while (this.gleise[gleis] != zug) {
				try {
					if (this.gleise[gleis] == null) {
						this.gleise[gleis] = zug;
						notify();
						break;
					}
					wait();
				} catch (InterruptedException e) {
					//nothing todo
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized Zug zugAusfahren(int gleis) {
		Zug ausfahrenderZug = null;
		if (anzahlDerGleise > gleis) {
			while (this.gleise[gleis] != null) {
				try {
					if (this.gleise[gleis] != null) {
						ausfahrenderZug = this.gleise[gleis];
						this.gleise[gleis] = null;
						notify();
						break;
					}
					wait();
				} catch (InterruptedException e) {
					//nothing todo
				}
			}
		}
		return ausfahrenderZug;
	}

	@Override
	public int getGleis() {
		return this.anzahlDerGleise;
	}

}
