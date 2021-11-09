package blatt2;

public class Fahrenheit4 {
	/**
	 * Geg.: Temperaturbereich in °F <br/>
	 * Ges.: Temperaturliste in °C
	 * 
	 * @param args unused
	 */
	public static void main(String[] args) {

		final int UPPER = 250; // obere Grenze
		final int LOWER = 0; // untere Grenze
		final int STEP = 25; // Schrittweite
		final int NUM_PER_ROW = 5;// Ausgaben pro Zeile

		for (int fahrenheit = LOWER; fahrenheit <= UPPER; fahrenheit = fahrenheit + STEP)
		// Initialisierung ; Bedingung ; Fortsetzung: Schleifenvariable erhoehen
		{
			int celsius = 5 * (fahrenheit - 32) / 9;
			if (fahrenheit % (STEP * NUM_PER_ROW) == 0) {
				System.out.println();
			}

			System.out.print(fahrenheit + "°F = " + celsius + "°C	");
		}

	}
}
