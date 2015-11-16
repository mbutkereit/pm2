package aufgabenblatt3;

public class Rangierbahnhof implements Bahnhof {
	
	private Zug[] gleise;
	
	
	public Rangierbahnhof(){
		this(42);
	}
	
	public Rangierbahnhof(int anzahlDerGleise){
		this.gleise = new Zug[anzahlDerGleise];
	}

	public synchronized void zugEinfahren(Zug zug, int gleis) {
		if (this.gleise.length > gleis) {
			while (this.gleise[gleis] != zug) {
				try {
					if (this.gleise[gleis] == null) {
						this.gleise[gleis] = zug;
						notifyAll();
						break;
					}
					wait();
				} catch (InterruptedException e) {
				}
			}
		}
	}

	public synchronized Zug zugAusfahren(int gleis) {
		Zug ausfahrenderZug = null;
		if (this.gleise.length > gleis) {
			while (this.gleise[gleis] != null) {
				try {
					if (this.gleise[gleis] == null) {
						ausfahrenderZug = this.gleise[gleis];
						this.gleise[gleis] = null;
						notifyAll();
						break;
					}
					wait();
				} catch (InterruptedException e) {
				}
			}
		}

		return ausfahrenderZug;
	}
}
