package aufgabenblatt3;

public interface AufgabeStrategy {
	
	public final int AUSPARKEN = 0;
	public final int EINPARKEN = 1;
	public void arbeiten();
	public int getGleis();
	public int getJobID();
}
