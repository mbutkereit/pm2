package aufgabenblatt2;

public class Rennauto extends Thread implements Comparable<Rennauto> {

	/**
	 * 
	 */
	private int laengeDerStrecke;

	/**
	 * In m/s
	 */
	private int durchschnittsGeschwindigkeit;

	private String name;

	private double endZeit;

	public Rennauto(String name, int laengeDerStrecke,
			int durchSchnittsGeschwindigkeit) {
		this.name = name;
		this.laengeDerStrecke = laengeDerStrecke;
		this.durchschnittsGeschwindigkeit = durchSchnittsGeschwindigkeit;
	}

	public void run() {
		double startTime = System.currentTimeMillis();
		double value = Math.round((Math.random() * 4));
		int gefahreneMeter = 0;
		while (true) {
			try {
				sleep(800 + ((int) value * 100));
				gefahreneMeter += this.durchschnittsGeschwindigkeit;
				System.out.println("Fahrer:"+this.name + " : " + gefahreneMeter+"/"+laengeDerStrecke);
				this.endZeit = (int) (System.currentTimeMillis() - startTime);
				if (gefahreneMeter >= this.laengeDerStrecke) {
					this.endZeit = (int) (System.currentTimeMillis() - startTime);
					return;
				}
			} catch (InterruptedException e) {
				return;
			}
			value = Math.round((Math.random() * 4));
		}
	}
	
	public int compareTo(Rennauto auto){
		return (int)(this.endZeit - auto.endZeit);
	}

	public String toString() {
		return "Fahrer:"+this.name + " : " + this.endZeit / 1000+ " Sekunden";
	}
}
