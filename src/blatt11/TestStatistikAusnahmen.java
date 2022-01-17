package blatt11;

import java.io.IOException;

/**
 * Klasse, um Ausnahmen für Statistiken mit Mittelwert zu
 * testen
 * 
 * @author Ulrich.Broeckl@hs-karlsruhe.de
 *
 */
class TestStatistikAusnahmen {

	private static final int MAX_LEVEL = 3;
	int[] headlineNumbers = new int[TestStatistikAusnahmen.MAX_LEVEL];

	/**
	 * Eine Überschrift ausgeben
	 * 
	 * @param level der Überschrift in 1 ... maxLevel
	 * @param text  der Überschrift
	 */
	void printHeadline(int level, String text) {
		// Untergeordnete Nummern löschen
		for (int i = level; i < TestStatistikAusnahmen.MAX_LEVEL; i++) {
			headlineNumbers[i] = 0;
		}

		System.out.print('\n');

		// Überschriftennummern ausgeben
		for (int i = 0; i < level - 1; i++) {
			System.out.print(headlineNumbers[i] + ".");
		}
		System.out.print(++headlineNumbers[level - 1] + ".");

		// Überschrift ausgeben
		System.out.print(" " + (level == 1 ? text.toUpperCase() : text) + "\n");
	}

	/**
	 * Testen, ob Dateiausgabe der Statistik funktioniert
	 * @throws Exception 
	 */
	void testDateiAusgabe() throws Exception {
		this.printHeadline(1, "Test der Exception bei Dateiausgabe:");

		this.printHeadline(2, "Test, ob Exception bei nicht gültigem Dateinamen (== Name der Statistik) kommt");
		Statistik statistik = new Statistik("Blöder\\Name//so");
		statistik.addWert(2.0);
		statistik.addWert(3.0);
		try {
			statistik.writeToFile();
		} catch (Exception e) {
			if(e instanceof IOException) {
				System.out.println("Erwartete Exception kam.");
				return;
			}
		}
		System.out.println("Erwartet Exception kam nicht.");

	}

	/**
	 * Testen, ob bei Verwendung einer leeren Statistik eine Ausnahme geworfen wird
	 */
	void testLeereStatistiken() {
		this.printHeadline(1, "Einige Tests für Ausnahmen bei \"leeren\" Statistiken");

		String tests[] = { "Leere Statistik soll nicht in String gewandelt werden",
				"Mittelwert einer leeren Statistik soll nicht ausgegeben werden",
				"Keine Ausnahme erwartet ...", };
		int numTest = 0;
		for (String test : tests) {
			this.printHeadline(2, "Test: " + test);
			try {
				Statistik statistik = new Statistik("Teststatistik_2");
				switch (++numTest) {
				case 1:
					System.out.println(statistik);
					break;
				case 2:
					System.out.println(statistik.getDurchschnitt());
					break;
				case 3:
					statistik.addWert(2.);
					System.out.println(statistik);
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * Testen, ob bei "falschen" Namen Ausnahme geworfen wird
	 */
	void testNames() {
		this.printHeadline(1, "Testfälle für die Namen der Statistik:");
		
		String tests[][] = { { null, "Null Zeiger nicht erlaubt" }, 
				{ "", "Leerer Name nicht erlaubt"  },
				{ "-", "Name der Statistik soll mit Buchstaben beginnen" },
				{ "OK-Statistik", "Name, der keine Ausnahme werfen soll ..." },
				{ "Ελληνικές στατιστικές", "Griechischer Name, der keine Ausnahme werfen soll ..." } };
		
		for (String[] test : tests) {
			this.printHeadline(2, "Test, ob Ausnahme bei: " + test[1]);
			try {
				// Statistik mit (zum Teil) falschen) Testnamen erzeugen:
				Statistik statistik = new Statistik(test[0]);

				// Ein paar Werte in die Statistik eintragen ...
				for (long l = 0L; l < 10L; l++) {
					statistik.addWert(Math.random());
				}
				System.out.println(statistik);

			} catch (Exception e) { // Hier sollte eine Ausnahme für die ersten drei Namen gefangen werden
				System.out.println(e.getMessage());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		TestStatistikAusnahmen tests = new TestStatistikAusnahmen();
		tests.testDateiAusgabe();
		tests.testLeereStatistiken();
		tests.testNames();
	}

}
