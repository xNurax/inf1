package blatt06;

public class ArrayStatistik {

	static int[] werte = { 35, 7, 90, 26, 92, 54, 24, 65, 2, 67, 43, 26, 80, 92, 7, 40, 67, 66, 31, 45, 7, 100, 96, 93, 12, 20,
			57, 22, 62, 51 };
	static int summe;
	static int anzahl;
	public static void main(String[] args) {
		System.out.println(mittelwert(werte));
		
	}
	
	public static int mittelwert(int[] werte) {
		
		for(int i = 0;i<werte[i];i++) {
			summe += werte[i];
			anzahl = i;
		}
		return summe/(anzahl-1);
		
	}
}
