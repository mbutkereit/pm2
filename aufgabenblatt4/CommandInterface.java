package aufgabenblatt4;

/**
 * Ein Interface um ein Konsolen Command zu bauen.
 */
public interface CommandInterface {

	/**
	 * Der Parameter validator.
	 */
	public boolean hasValidateParameter(String param0, String param1);

	/**
	 * Der Name des Commands.
	 */
	public String getCommandName();

	/**
	 * Führt das Command aus.
	 */
	public void run(String param0, String param1);
}
