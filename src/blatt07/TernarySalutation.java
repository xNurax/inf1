package blatt07;

public class TernarySalutation {
	/**
	 * Alle möglichen Grußformeln ausgeben 
	 */
	private static void testSalutation() {
		boolean bools[] = {true, false};
		for(boolean firstNameBase : bools) {
			for(boolean signature : bools) {
				System.out.println("\n..........<Mail-Text>..........\n"); // Platzhalter  
				System.out.println(salutation(firstNameBase, signature, "Kim", "May", "Raum E502\nTel.: 01234/567890"));
				System.out.println("\n"); // Abstand zur uebersichtlichen Ausgabe 
			}
		}
	}
	
	/**
	 * Grußformeln abhängig vom Bekanntheitsgrad und wahlweise mit oder ohne Signatur ausgeben
	 * @return Gru�formeln
	 * @param onFirstNameBase Per-Du?
	 * @param signature Signatur anfügen?
	 * @param given	Vorname
	 * @param name Nachname
	 * @param signatureText Signatur
	 */
	static String salutation(boolean onFirstNameBase, boolean signature, String given, String name, String signatureText)
	{
		String firstLine = onFirstNameBase ? given : (given +" "+ name);
		String secondLine = signature ? ("______________________\n"+signatureText) : "";
		return ("Viele Grüße,\n"+firstLine +"\n"+ secondLine);
		

	}
	
	public static void main(String[] args) {
		testSalutation();							
	}
}
