package aufgabenblatt3;

public class Lokfuehrer extends Thread {

	private String letzteTaetigkeit;
	
	private Bahnhof arbeitsPlatz;
	
	public Lokfuehrer(Bahnhof arbeitsPlatz){
		this.letzteTaetigkeit = "nichts gemacht!";
		this.arbeitsPlatz = arbeitsPlatz;
	}
	
	public void zugAufEinGleisEinfahren(Zug zug,int gleis){
		this.arbeitsPlatz.zugEinfahren(zug,gleis);
		this.letzteTaetigkeit = "den Zug gerade aufs " +gleis +" abgestellt";
	}
	public void zugAufEinGleisAusfahrenn(int gleis){
		this.arbeitsPlatz.zugAusfahren(gleis);
		this.letzteTaetigkeit = "den Zug von " +gleis +"Weg gefahren";
	}
	
	public String toString(){
		return "ich habe gerade " + this.letzteTaetigkeit;
	}
	
}
