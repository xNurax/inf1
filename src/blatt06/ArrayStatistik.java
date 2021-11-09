package blatt06;

import java.util.Arrays;

public class ArrayStatistik {

	static int[] werte = { 35, 7, 90, 26, 92, 54, 24, 65, 2, 67, 43, 26, 80, 92, 7, 40, 67, 66, 31, 45, 7, 100, 96, 93,
			12, 20, 57, 22, 62, 51 };
	static int[] tests = { -3, -2, -1 };
	static int summe;
	static int anzahl;
	static int max = -2000000000;
	static int min = 2000000000;
	static double median;

	public static void main(String[] args) {
		mittelwert(werte);
		minmax(werte);
		median(werte);
		System.out.println("*********************************************************************************");
		mittelwert(tests);
		minmax(tests);
		median(tests);
	}

	public static void mittelwert(int[] werte) {

		for (int i = 0; i < werte[i]; i++) {
			summe += werte[i];
			anzahl = i;
		}
		System.out.println("Arithmetic middle is " + summe / (anzahl - 1));

	}

	public static void minmax(int[] werte) {
		for (int i = 0; i < werte.length; i++) {
			if (werte[i] > max) {
				max = werte[i];

			}

		}

		for (int r = 0; r < werte.length; r++) {
			if (werte[r] < min) {
				min = werte[r];

			}

		}
		System.out.println(("Minimum is : " + min + ",	Maximum is: " + max));
	}

	public static void median(int[] werte) {

		Arrays.sort(werte);
		int half = (werte.length / 2);
		if ((werte.length) % 2 == 0) {
			median = (double) (werte[half] + werte[(half - 1)]) / 2;
		} else {
			median = werte[(int) (half + 0.5)];
		}
		System.out.println("Median is : " + median);
	}
}
