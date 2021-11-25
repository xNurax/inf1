package blatt08;

public class RecursiveSimplerTask {

	public static void main(String[] args) {
		long n= Long.parseLong(args[0]);
		prt1234(n);
	}

	static int a = 1;

	static void prt1234(long n) {
		if (a <= n) {
			System.out.print(a + ",");
			a++;
			prt1234(n);
		}
	}
}
 