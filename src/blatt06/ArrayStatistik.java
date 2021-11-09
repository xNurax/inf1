package blatt06;

import java.util.Arrays;

public class ArrayStatistik {

	static int[] werte = { 35, 7, 90, 26, 92, 54, 24, 65, 2, 67, 43, 26, 80, 92, 7, 40, 67, 66, 31, 45, 7, 100, 96, 93,
			12, 20, 57, 22, 62, 51 };
	static int[] tests = { 1 };
	static double[][] Schaden = { { 0, 74.4 }, { 350, 18.2 }, { 1500, 6.1 }, { 5000, 1.3 } };

	static int summe;
	static int anzahl;
	static int max = -2000000000;
	static int min = 2000000000;
	static double median;

	public static void print(double[][] array) {
		for (int i = 0; i < array.length; i++) {

			System.out.println("Schaden in Euro : " + array[i][0] + "Wahrscheinlichkeit : " + array[i][1] + "%");
		}

	}

	public static void main(String[] args) {
		mittelwert(werte);
		minmax(werte);
		median(werte);
		System.out.println("*********************************************************************************");
		mittelwert(tests);
		minmax(tests);
		median(tests);
		print(Schaden);
	}

	public static void mittelwert(int[] werte) {
		if (werte.length == 1) {
			System.out.println("Arithmetic middle is " + werte[0]);
		} else {

			for (int i = 0; i < werte[i]; i++) {
				summe += werte[i];
				anzahl = i;
			}
			System.out.println("Arithmetic middle is " + summe / (anzahl - 1));

		}
	}

	public static void minmax(int[] werte) {
		if (werte.length == 1) {
			System.out.println("Only one Item in Array...");
		} else {
			for (int i = 0; i < werte.length; i++) {
				if (werte[i] > max) {
					max = werte[i];

				}
				if (werte[i] < min) {
					min = werte[i];

				}
			}

			System.out.println(("Minimum is : " + min + ",	Maximum is: " + max));
		}
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
