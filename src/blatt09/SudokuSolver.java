package blatt09;

/**
 * Loesung eines 9x9 Sudokus mit Hilfe von Backtracking.
 * 
 * Afgs: a Solver mit Backtracking b Anzahl Backtracks zählen mit
 * Klassenvariable
 * 
 * @author Ulrich.Broeckl@hs-karlsruhe.de,<br>
 *         sclu1042@hs-karlsruhe.de
 */
public class SudokuSolver {
	/**
	 * Wie gross ist ein Block (i.d.R. 3) im Sudoku.<br>
	 * <br>
	 * <b>WARNUNG:</b> Es reicht nicht aus, einfach diese Zahl zum Beispiel fuer
	 * 16x16 Sudokus hochzusetzen. Da ist einiges mehr zu tun...
	 */
	private final int BLOCK_SIZE = 3;

	/**
	 * Anzahl der Spalten/Zeilen
	 */
	private final int ROW_SIZE = BLOCK_SIZE * BLOCK_SIZE;

	private int nrOfSolutions, nrOfTests;

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
			//{ { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				//	/* |---------|---------|---------| */
					//{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 }, { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
					/* |---------|---------|---------| */
					//{ 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, { 0, 0, 0, 0, 8, 0, 0, 7, 9 } },
			/* |---------|---------|---------| */

			/* |---------|---------|---------| */
			//{ { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
					/* |---------|---------|---------| */
			//		{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
					/* |---------|---------|---------| */
			//		{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 0 } },
			/* |---------|---------|---------| */

			/* |---------|---------|---------| */
			{ { 0, 0, 0, 5, 4, 2, 0, 0, 0 }, { 9, 6, 7, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 3, 1, 8 },
					/* |---------|---------|---------| */
					{ 0, 0, 0, 0, 7, 0, 8, 6, 4 }, { 0, 2, 0, 6, 0, 4, 0, 9, 0 }, { 6, 4, 5, 0, 1, 0, 0, 0, 0 },
					/* |---------|---------|---------| */
					{ 8, 9, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 5, 4, 7 }, { 0, 0, 0, 3, 2, 6, 0, 0, 0 } },
			/* |---------|---------|---------| */

	};

	public void testSudokuSolver() {
		for (int[][] s : this.testSpielFelder) {
			this.spielFeld = s;
			
			this.print();

			nrOfSolutions = 0;
			nrOfTests = 0;
			this.loesen(0, 0);
			System.out.println(nrOfTests);
			this.print();
		}
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
		int iZeile, iSpalte;
		int iZeileStart = (zeile / BLOCK_SIZE) * BLOCK_SIZE;
		int iSpalteStart = (spalte / BLOCK_SIZE) * BLOCK_SIZE;

		for (iZeile = iZeileStart; iZeile < iZeileStart + BLOCK_SIZE; iZeile++) {
			for (iSpalte = iSpalteStart; iSpalte < iSpalteStart + BLOCK_SIZE; iSpalte++) {

				if (wert == spielFeld[iZeile][iSpalte]) {
					return false;
				}
			}
		}
		return true;
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
			if (wert == spielFeld[zeile][iSpalte]) {
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
			if (wert == spielFeld[iZeile][spalte]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Ein Sudoku ausgeben.
	 */
	public void print() {
		final String horizBorder = " ┼────────┼────────┼────────┼";

		System.out.println();

		for (int iZeile = 0; iZeile < ROW_SIZE; iZeile++) {
			if (0 == iZeile % 3) {
				System.out.println(horizBorder);
			}

			for (int iSpalte = 0; iSpalte < ROW_SIZE; iSpalte++) {
				if (0 == iSpalte % 3) {
					System.out.print(" │ ");
				}

				int wert = spielFeld[iZeile][iSpalte];
				if (wert == 0) {
					System.out.print("_ ");
				} else {
					System.out.print(wert + " ");
				}

			}
			System.out.println(" │");
		}
		System.out.println(horizBorder);
	}

	/**
	 * Suche Loesungen des Sudokus.
	 * 
	 * Es wird oben links beginnend versucht, alle Zahlen fuer ein freies Feld zu
	 * finden, die weder in der Zeile, noch in der Spalte, noch im Block doppelt
	 * auftauchen. Falls es eine solche Zahl gibt, wird mit der naechsten Zelle
	 * weitergemacht, ansonsten wird die Suche abgebrochen (Backtracking) und in der
	 * aufrufenden 'suche' die naechste moegliche Zahl ausprobiert.
	 * 
	 * @param zeile  Startzeile der Suche
	 * @param spalte Startspalte der Suche
	 */
	int i = 1;

	public void loesen(int zeile, int spalte) {
		nrOfTests += 1;
		boolean test1 = false;
		boolean test2 = false;
		boolean test3 = false;
		if (this.spielFeld[zeile][spalte] == 0 && i <= 9) {

			this.spielFeld[zeile][spalte] = i;

			if (isBlockOk(zeile, spalte, i)==true) {
				test1 = true;

			}
			if (isZeileOk(zeile, i)==true) {
				test2 = true;

			}
			if (isSpalteOk(spalte, i)==true) {
				test3 = true;

			}
			if (test1 && test2 && test3 == true) {
				this.spielFeld[zeile][spalte]=i;
				i=1;
				return;
			} else {
				++i;
				this.spielFeld[zeile][spalte]=0;
				loesen(zeile, spalte);
			}

		} else {
			if (spalte < 8) {
				spalte += 1;
				loesen(zeile, spalte);
			} else {
				if (zeile < 8) {

					spalte = 0;
					++zeile;
					loesen(zeile, spalte);
				}
				return;
			}

		}

	}

	public static void main(String[] args) {
		new SudokuSolver().testSudokuSolver();
	}

}