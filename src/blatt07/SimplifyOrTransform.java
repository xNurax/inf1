package blatt07;

public class SimplifyOrTransform {

	/**
	 * Formen Sie bitte die folgenden Ausdrücke etc. in vereinfachte Varianten um:
	 */
	static void toBeSimplified() {
		int a, b, c;

		// Beispiel: Mehrfache Initialisierung mit dem selben Wert:
		a = 0;
		b = 0;
		c = 0;
		// Vereinfacht:
		a = b = c = 0;

		a = (b = 1 + (c = 0));
		// Vereinfacht:
		a=b=c+=1;
		a = b++ - (b += 2) - (b = 0);
		// Vereinfacht:
		// TODO (Bitte durch Sie zu entwickeln)

		// Ändern Sie bitte ab auf, wo passend, Dekrement/Inkement-Opratoren
		// oder kombinierte Zuweisungsoperatoren (jeweils ohne die Ausgabe zu ändern
		// ...)
		final int N0 = 0, N1 = 17;
		for (int i = N0; i < N1; i++) {
			System.out.print(i + ", ");
		}

		System.out.println();
		for (int i = N1 - 1; i >= N0; i--) {
			System.out.print(i + ", ");
		}

		System.out.println();
		for (int i = N0; i < N1; i += 2) {
			System.out.print(i + ", ");
		}

		System.out.println();
		for (int i = N1 - 1; i >= N0; i -= 2) {
			System.out.print(i + ", ");
		}

		System.out.println();
		for (int i = N0 + 1; i < N1 * N1; i += i) {
			System.out.print(i + ", ");
		}
		System.out.println();

		// Formen Sie bitte die folgende while-Schleifen in for-Schleifen um
		// und verwenden Sie wieder Inkrementoperatoren/kombinierte Zuweisungsoperatoren
		a = 1;
		final int NMAX = 10;
		while (a < NMAX) {
			b = 1;
			while (b < NMAX) {
				System.out.printf("%3d", a * b);
				b = b + 1;
			}
			System.out.println();
			a = a + 1;
		}
		System.out.println();
		a = 1;
		for (int i = a; i < NMAX; i++) {
			b = 1;
			for (int r = b; r < NMAX; r++) {
				System.out.printf("%3d", a * b);
				b = b + 1;
			}
		}
		System.out.println();
		a = 3;
		while (a < 100) {
			b = 2;
			while (b * b < a && a % b != 0) {
				b = b + 1;
			}
			if (b * b > a) {
				System.out.print(a + ", ");
			}
			a = a + 2;
		}
		System.out.println();
		a = 3;
		for (int i = a; i < 100; i += 2) {
			
			for (int b1 = 2; b1 * b1 < a && a % b1 != 0; b1++) {
				if (b1 * b1 > a) {
					System.out.println(a + ", ");
				}
			}

		}

		// Transformieren Sie bitte folgende If-/Else-Kette in eine Switch-Anweisung
		int zufallsZahl = 1 + (int) (Math.random() * 6.);

		String seite;
		switch (zufallsZahl) {
		case 1:
			seite = "eins";
			break;
		case 2:
			seite = "zwei";
		case 3:
			seite = "drei";
			break;
		case 4:
			seite = "vier";
			break;
		case 5:
			seite = "fünf";
			break;
		case 6:
			seite = "sechs";
		default:
			seite = "Ungültig";
			break;
		}
		System.out.println("\nGewürfelt: " + seite);
		if (zufallsZahl == 1) {
			seite = "Eins";
		} else if (zufallsZahl == 2) {
			seite = "Zwei";
		} else if (zufallsZahl == 3) {
			seite = "Drei";
		} else if (zufallsZahl == 4) {
			seite = "Vier";
		} else if (zufallsZahl == 5) {
			seite = "Fünf";
		} else if (zufallsZahl == 6) {
			seite = "Sechs";
		} else {
			seite = "Ungültig";
		}
		System.out.println("\nGewürfelt: " + seite);
	}

	public static void main(String[] args) {
		toBeSimplified();
	}

}
