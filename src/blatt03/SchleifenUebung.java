package blatt03;
//Aufgaben

//3.2: 		z.B public und private, auch final usw.
//3.3: 		Da der Bytecode in den java kompiliert wird von den jeweiligen Plattformen in 
//			einer VM wieder gelesen und in Maschinencode umgewandelt werden kann
//3.4: 		Android Apps mit Java haben keine main Methode, auﬂerdem wird in Davilk op code.

public class SchleifenUebung {
	public static void main(String[] args) {
		final double ANFANGSWERT = -4;
		final double ENDWERT = 4;
		final double STEP = 0.5;
		

		System.out.println("---------------------------------------------------------------------");
		System.out.println("Aufgabe 3.6\n");
		for (double i= ANFANGSWERT; i <= ENDWERT; i += STEP) {
			System.out.println("x, x^2: " + i + ",	 " + Math.pow(i, 2));
		}
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Aufgabe 3.7\n");
		
		for (double i = ANFANGSWERT; i <= ENDWERT; i += STEP) {
			System.out.println("x, sin(x), cos(x): " + i + ", sin: " + Math.sin(i) + ", cos: " + Math.cos(i));
		}
	}

}
