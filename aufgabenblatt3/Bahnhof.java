package aufgabenblatt3;

public interface Bahnhof {
	public void zugEinfahren(Zug zug, int gleis);
	public Zug zugAusfahren(int gleis);
}
