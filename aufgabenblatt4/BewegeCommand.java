package aufgabenblatt4;

/**
 * Ein Command um ein Punkt hinzuzufuegen.
 */
public class BewegeCommand implements CommandInterface {

	/**
	 * Die PolygonVerwalter Klasse.
	 */
	private PolygonVerwalter verwalter;

	/**
	 * Konstruktor.
	 */
	public BewegeCommand(PolygonVerwalter verwalter) {
		this.verwalter = verwalter;
	}

	@Override
	public String getCommandName() {
		return "bewege";
	}

	@Override
	public boolean hasValidateParameter(String param0, String param1) {
		try {
			Double.parseDouble(param0);
			Double.parseDouble(param1);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	@Override
	public void run(String param0, String param1) {
		this.verwalter.getAktivesElement().addPoint(Double.parseDouble(param0),
				Double.parseDouble(param1));
	}

}
