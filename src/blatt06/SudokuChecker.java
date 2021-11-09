
package blatt06;

/**
 * Pruefen eines 9x9 Sudokus
 * 
 * @author Ulrich.Broeckl@hs-karlsruhe.de,<br>
 *         sclu1042@hs-karlsruhe.de
 */
public class SudokuChecker {
	/**
	 * Wie gross ist ein Block (i.d.R. 3) im Sudoku.<br>
	 * <br>
	 * <b>WARNUNG:</b> Es reicht nicht aus, einfach diese Zahl zum Beispiel fuer
	 * 16x16 Sudokus hochzusetzen. Da ist einiges mehr zu tun ...
	 */
	private final int BLOCK_SIZE = 3;

	/**
	 * Anzahl der Spalten/Zeilen
	 */
	private final int ROW_SIZE = BLOCK_SIZE * BLOCK_SIZE;

	/**
	 * Zweidimensionales Array, welches das initiale (und das geloeste) Sudoku
	 * speichert.<br>
	 * <br>
	 * Moegliche Eintraege:
	 * <ul>
	 * <li>Zahlen 1..9</li>
	 * <li>0 fuer unbekannter Wert</li>
	 * </ul>
	 */
	private int[][] spielFeld;

	// Achtung: Arrays enthalten spaeter Loesung!
	private int[][][] testSpielFelder = {
			/* |---------|---------|---------| */
			{ { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
					/* |---------|---------|---------| */
					{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 }, { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
					/* |---------|---------|---------| */
					{ 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, { 0, 0, 0, 0, 8, 0, 0, 7, 9 } },
			/* |---------|---------|---------| */

			/* |---------|---------|---------| */
			{ { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
					/* |---------|---------|---------| */
					{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
					/* |---------|---------|---------| */
					{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 0 } },
			/* |---------|---------|---------| */

			/* |---------|---------|---------| */
			{ { 0, 0, 0, 5, 4, 2, 0, 0, 0 }, { 9, 6, 7, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 3, 1, 8 },
					/* |---------|---------|---------| */
					{ 0, 0, 0, 0, 7, 0, 8, 6, 4 }, { 0, 2, 0, 6, 0, 4, 0, 9, 0 }, { 6, 4, 5, 0, 1, 0, 0, 0, 0 },
					/* |---------|---------|---------| */
					{ 8, 9, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 5, 4, 7 }, { 0, 0, 0, 3, 2, 6, 0, 0, 0 } },
			/* |---------|---------|---------| */

	};

	/** Testmethode */
	public void testSudokuChecker() {
		for (int[][] testFeld : this.testSpielFelder) {
			this.spielFeld = testFeld;

			// Korrekte Spielfelder pruefen
			this.print();
			// System.out.println("Falscher Alarm?");
			this.validiereSpielfeld();

			// Fehler einbauen
			this.spielFeld[8][8] = -1;
			this.print();
			// System.out.println("Falscher Wert auf [8][8] ...");
			this.validiereSpielfeld();

			this.spielFeld[8][8] = 8;
			this.print();
			// System.out.println("Womoeglich doppelter Wert auf [8][8] ...");
			this.validiereSpielfeld();
		}
	}

	/**
	 * Pruefen, ob ein gegebener Wert im erlaubten Bereich 1 ... ROW_SIZE ist.
	 * 
	 * @param wert Wert, in 1 ... ROW_SIZE sein soll
	 * @return true, falls Wert in Ordnung
	 */
	private boolean isValueOk(int wert) {
		// todo gemacht
		return (wert >= 1 && wert <= ROW_SIZE);

	}

	/**
	 * Pruefen, ob ein gegebener Wert an gegebener Position in einer Zeile erlaubt
	 * ist.
	 * 
	 * @param zeile Zeile, in der der Wert geprueft wird
	 * @param wert  Wert, der noch nicht in der Zeile vorhanden sein darf
	 * @return true, falls Wert noch nicht vorhanden.
	 */
	private boolean isZeileOk(int zeile, int wert) {
		for (int iSpalte = 0; iSpalte < ROW_SIZE; iSpalte++) {
			if (spielFeld[zeile][iSpalte] == wert) {
				System.out.println("testtest");
				return false;
			}
		}
		return true;
	}

	/**
	 * Pruefen, ob ein gegebener Wert in einer Spalte erlaubt ist.
	 * 
	 * @param spalte Spalte, in der der Wert geprueft wird
	 * @param wert   Wert, der noch nicht in der Spalte vorhanden sein darf
	 * @return true, falls Wert noch nicht vorhanden.
	 */
	private boolean isSpalteOk(int spalte, int wert) {
		for (int iZeile = 0; iZeile < ROW_SIZE; iZeile++) {
			if (spielFeld[iZeile][spalte] == wert) {

				return false;
			}
		}
		return true;

	}

	/**
	 * Pruefen, ob ein gegebener Wert in einem Block erlaubt ist.
	 * 
	 * @param zeile  Zeile, in der der Wert geprueft wird
	 * @param spalte Spalte, in der der Wert geprueft wird
	 * @param wert   Wert, der noch nicht in dem Block vorhanden sein darf
	 * @return true, falls Wert noch nicht vorhanden.
	 */
	private boolean isBlockOk(int zeile, int spalte, int wert) {
		int[] toTest = new int[9];
		int StartIndexX = 0;
		int EndIndexX = 0;
		int EndIndexY = 0;
		int StartIndexY = 0;
		if(zeile>=0 && zeile<=2) {
			StartIndexY = 0;
			EndIndexY = 2;
			}
		if(zeile>=3 && zeile<=5) {
			StartIndexY = 3;
			EndIndexY = 5;
			}
		if(zeile>=6 && zeile<=8) {
			StartIndexY = 6;
			EndIndexY = 9;
			}
		if(spalte>=0 && spalte<=2) {
			StartIndexX = 0;
			EndIndexX = 2;
			}
		if(spalte>=3 && spalte<=5) {
			StartIndexX = 3;
			EndIndexX = 5;
			}
		if(spalte>=6 && spalte<=8) {
			StartIndexX = 6;
			EndIndexX = 9;
			}
		for(int i = StartIndexX;i < EndIndexX;i++) {
			for(int r = StartIndexY;r < EndIndexY;r++) {
				System.out.println( (spielFeld[r][i]));
				
			}
		}
		return true;
	}

	/**
	 * Ein Sudoku pruefen, ob keine Werte doppelt in Zeilen, Spalten oder Bloecken
	 * auftauchen. Falls doch, einfach ausgeben, wo das der Fall ist.
	 */
	public void validiereSpielfeld() {
		for (int iZeile = 0; iZeile < ROW_SIZE; iZeile++) {
			for (int iSpalte = 0; iSpalte < ROW_SIZE; iSpalte++) {

				int wert = spielFeld[iZeile][iSpalte];

				if (wert != 0) { // Feld besetzt

					spielFeld[iZeile][iSpalte] = 0; // Damit eigentlicher Wert nicht wie Doppelung aussieht

					if (!isValueOk(wert)) {
						System.out.format("Ungueltiger Wert %d in Zeile %d, Spalte %d! \n", wert, iZeile + 1,
								iSpalte + 1);
					}
					if (!isZeileOk(iZeile, wert)) {
						System.out.format("Doppelter Zeilenwert %d in Zeile %d, Spalte %d! \n", wert, iZeile + 1,
								iSpalte + 1);
					}
					if (!isSpalteOk(iSpalte, wert)) {
						System.out.format("Doppelter Spaltenwert %d in Zeile %d, Spalte %d! \n", wert, iZeile + 1,
								iSpalte + 1);
					}
					if (!isBlockOk(iZeile, iSpalte, wert)) {
						System.out.format("Doppelter Blockwert %d in Zeile %d, Spalte %d! \n", wert, iZeile + 1,
								iSpalte + 1);
					}

					spielFeld[iZeile][iSpalte] = wert; // Wert wieder herstellen
				} // Feld besetzt
			}
		}
	}

	/**
	 * Ein Sudoku ausgeben.
	 */
	public void print() {
		final String horizBorder = "-------------------------";

		System.out.println();

		for (int iZeile = 0; iZeile < ROW_SIZE; iZeile++) {
			if (0 == iZeile % 3) {
				System.out.println(horizBorder);
			}

			for (int iSpalte = 0; iSpalte < ROW_SIZE; iSpalte++) {
				if (0 == iSpalte % 3) {
					System.out.print("| ");
				}

				int wert = spielFeld[iZeile][iSpalte];
				if (wert == 0) {
					System.out.print("_ ");
				} else {
					System.out.print(wert + " ");
				}

			}
			System.out.println("|");
		}
		System.out.println(horizBorder);
	}

	public static void main(String[] args) {
		new SudokuChecker().testSudokuChecker();
	}

}