package blatt08;

import java.util.Arrays;

public class MethodenUebung {

	public static void main(String[] args) {
		System.out.println(Betrag(-22));
		System.out.println(Aufrunden(1.3));
		System.out.println(Abrunden(1.7));
		System.out.println(Teilbarkeit(7, 3.5));
		System.out.println(EuklidischeDistanz(0, 0, 3, 3));
		System.out.println(KleinsteZahl(7, 9, 3));
		System.out.println(farbenWert(Kartenfarbe.KARO));
		prt1234(9);
		System.out.println();
		prtSqr1234(9);
		System.out.println();
		prt2468(101);
		System.out.println();
		xxx(100);
		System.out.println();
		xxxx(100);

	}

	static double Betrag(double zahl) {
		return Math.abs(zahl);
	}

	static int Aufrunden(double zahl) {
		return (int) Math.ceil(zahl);
	}

	static int Abrunden(double zahl) {
		return (int) Math.floor(zahl);
	}

	static String Teilbarkeit(double zahl, double teiler) {
		if (zahl % teiler == 0) {
			return zahl + " ist restlos teilbar duch " + teiler;
		}
		return (zahl + " ist nicht restlos teilbar durch " + teiler);

	}

	/**
	 * Distanz zwischen 2 Punkten p1(x1,y1) p2(x2,y2)
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return Distanz zwischen p1 und p2
	 */
	static String EuklidischeDistanz(double x1, double y1, double x2, double y2) {
		return "Der Abstand zwischen P1 und P2 ist " + Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
	}

	static String KleinsteZahl(double a, double b, double c) {
		double[] toSort = { a, b, c };
		Arrays.sort(toSort);
		return "Von " + a + ", " + b + " und " + c + " ist " + toSort[0] + " die kleinste Zahl";
	}

	public enum Kartenfarbe {
		KARO, HERZ, PIK, KREUZ
	}

	public static String farbenWert(Kartenfarbe farbe) {

		switch (farbe) {
		case KARO:
			return "9";

		case HERZ:
			return "10";

		case PIK:
			return "11";

		default:
			return "12";

		}

	}

	static int a = 1;

	static void prt1234(long n) {
		if (a <= n) {
			System.out.print(a + ",");
			a++;
			prt1234(n);
		}
	}

	static int b = 1;

	static void prtSqr1234(long n) {
		if (Math.pow(b, 2) <= Math.pow(n, 2)) {
			System.out.print(b * b + ", ");
			b++;
			prtSqr1234(n);
		}
	}

	static int c = 2;

	static void prt2468(long n) {
		if (c <= n) {
			System.out.print(c + ", ");
			c += 2;
			prt2468(n);
		}

	}
	static void xxx(long n) {
		if(n > 0L) {
		System.out.print(n+", ");
		xxx(n-1);
		}
		else {}
		}
	static void xxxx(long n) {
		while(n>0){
			System.out.print(n+", ");
			n--;
		}
	}
}
