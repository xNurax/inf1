package blatt11;

public class ExceptionHandling {
	/**
	 * Zwei Werte dividieren
	 * 
	 * @param z, Zahl die dividiert wird (Zähler)
	 * @param n, Zahl durch die dividiert wird (Nenner)
	 * @return z / n
	 */
	public static int div(int z, int n) {
		try {
			System.out.println(z / n);
			return z / n;
		} catch (ArithmeticException e) {
			System.err.println("Fehlergrund: '" + e.getMessage() + "'");
			e.printStackTrace();
			// Ersatzwert für Division durch 0
			System.out.println("Ersatzwert: " + Integer.MAX_VALUE + "\n");
			return Integer.MAX_VALUE;
		}
	}

	public static void main(String[] args) {
		div(8, 0);
		div(8, 2);

	}
}
