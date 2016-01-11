package aufgabenblatt4;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Eine Klasse welche zu einem Command die Richtige Klasse findet.
 */
public class CommandRouter {
	/**
	 * Regex zum finden des Commands.
	 */
	private final static String REGEX = "(.+) -> (.+) , (.+)";
	
	/**
	 * Eine Map mit allen Commands.
	 */
	private HashMap<String, CommandInterface> commandList;

	/**
	 * Konstruktor.
	 */
	public CommandRouter() {
		this.commandList = new HashMap<String, CommandInterface>();
	}

	/**
	 * Zum hinzufuegen von neuen Commands.
	 */
	public void addSubscriber(CommandInterface command) {
		this.commandList.put(command.getCommandName(), command);
	}

	/**
	 * Um das Richtige Command zu finden eine suche funktion.
	 */
	private CommandInterface find(String element) {
		try {
			return this.commandList.get(element);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Bearbeite die Fenster Eingabe.
	 */
	public void handleEingabe(String eingabe) {
		Matcher matcher = Pattern.compile(CommandRouter.REGEX).matcher(
				eingabe);
		if (matcher.find()) {
			CommandInterface command = this.find(matcher.group(1));
			if (command != null) {
				if (command.hasValidateParameter(matcher.group(2),
						matcher.group(3))) {
					command.run(matcher.group(2), matcher.group(3));
				}
			}
		}
	}

}
