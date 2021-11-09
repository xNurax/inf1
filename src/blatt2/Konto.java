package blatt2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Konto {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Benutzereingaben Lesen
		double guthaben = 0.0;
		double zins = 0.0;
		final int EINZAHLUNG = 1000;
		int jahre = 0;
		System.out.println("Geben sie ihr Startguthaben ein!");
		
		String userInput = reader.readLine();
		
		guthaben = Integer.parseInt(userInput);
		System.out.println("Ihr Startguthaben beträgt nun " + guthaben + "€!");
		System.out.println("----------------------------------------------------------------");
		System.out.println("Geben sie ihren Zinssatz in % an!");
		
		userInput = reader.readLine();
		
		zins = Integer.parseInt(userInput);
		System.out.println("Ihr Jahreszinssatz beträgt nun " + zins + "%");
		System.out.println("----------------------------------------------------------------");
		System.out.println("Geben sie ihre Laufzeit in Jahren an!");
		
		userInput = reader.readLine();

		jahre = Integer.parseInt(userInput);
		System.out.println("Ihre Laufzeit beträgt nun " + jahre + "Jahre");
		System.out.println("----------------------------------------------------------------");
		System.out.println("Wollen sie ihr Guthaben in " + jahre + " Jahren mit einem \nZinssatz von " + zins
				+ "% und einem Startguthaben von " + guthaben + "€ \nund einer jährlichen Extra-Einzahlung\nvon "
				+ EINZAHLUNG + "€ errechnen? Geben sie (y/n) ein!");

		userInput = reader.readLine();
		System.out.println("----------------------------------------------------------------");

		if (userInput.equals("n")) {
			System.out.println("Operation abgebrochen!");
			return;
		} else if(userInput.equals("y")) {
			for (int i = 1; i <= jahre; i++) {
				if (i == 1) {
					System.out.println("Ihr Guthaben in Jahr " + i + " beträgt " + Math.round(guthaben) + "€"
							+ " Sie zahlen nun noch " + EINZAHLUNG + "€ ein.\n");
				} else {
					guthaben *= (1 + (0.01 * zins));
					guthaben += EINZAHLUNG;
					System.out.println("Ihr Guthaben in Jahr " + i + " beträgt " + Math.round(guthaben * 100.0) / 100.0
							+ "€" + " Sie haben noch " + EINZAHLUNG + "€ zusätzlich eingezahlt!\n");
				}
			}
		}
	}
}
