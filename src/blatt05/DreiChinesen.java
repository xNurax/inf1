package blatt05;

public class DreiChinesen {
	static final String text = "Drei Chinesen mit dem Kontrabass\n" + "saßen auf der Straße und erzählten sich was.\n"
			+ "Da kam ein Mann: Ja was ist denn das?\n" + "Drei Chinesen mit dem Kontrabass.\n\n";

	// Methode um mit StringBuilder links an strings whitespace hinzuzufügen.
	public static String padLeftWhitespace(String inputString, int length) {
		if (inputString.length() >= length) {// Exception covern
			return inputString;
		}
		StringBuilder sb = new StringBuilder(); // eingebauten String builder benutzen
		while (sb.length() < (length - inputString.length()) / 2) {
			sb.append(' ');// so lange Maximallänge nicht errreicht ist leerzeichen einfügen
		}
		sb.append(inputString); // vor eingegebenen String leerzeichen anfügen

		return sb.toString();// eingegebeen String zurückgeben
	}

	static void printCentered(String text) {
		// Create new String array filled
		// with each line seperated by \n
		// zeilen={"line1","line2",...,"lineN"}
		// longest line variable
		String[] zeilen = text.split("\n");

		// Find out longest line and save the length as integer
		int laengsteZeile = 0;
		for (int i = 0; i < zeilen.length; i++) {
			int currentLength = zeilen[i].length();
			if (currentLength > laengsteZeile) {
				laengsteZeile = currentLength;
			}

		}
		// For every line, append Whitespace on the left with external method and print
		// le finished line
		for (int i = 0; i < zeilen.length; i++) {
			zeilen[i] = padLeftWhitespace(zeilen[i], laengsteZeile);
			System.out.println(zeilen[i]);
		}
	}

	/**
	 * Vokale in Text ersetzen.
	 * 
	 * @param text        Text mit Vokalen
	 * @param replacement Ersatz fÃ¼r Vokale
	 * @return Text mit geÃ¤nderten Vokalen
	 */
	static String changeVowels(String text, String replacement) {
		// replace Vowels with replacement
		String replacedLetters = text.replaceAll("[AaEeIiOoUu]", replacement);
		return replacedLetters;
	}

	public static void main(String[] args) {
		DreiChinesen.printCentered(text);
		String[] outputArgs = { "i", "Ä", "o", "3" };
		for (int i = 0; i < outputArgs.length; i++) {
			System.out.println(
					"*****************************************************************************************");
			DreiChinesen.printCentered(DreiChinesen.changeVowels(text, outputArgs[i]));
		}

	}

}
