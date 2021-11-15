import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Busfahrer {
	static int[] pyramide;
	static int mitspieler = 4;
	static int Schlucke = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Busfahrer lets gooooooo\n***********************************");
		for (int i = 1; i <= mitspieler; i++) {
			
			System.out.println();
			System.out.println("Rot oder Schwarz?");
			String userInput = reader.readLine();
			int eingabe = 0;
			String eingabe1 = "";
			userInput = eingabe1.toLowerCase();
			if (eingabe1 == "rot"|| eingabe1=="r") {
				eingabe = 0;
			} else if (eingabe1 == "schwarz"|| eingabe1=="s") {
				eingabe = 1;
			}
			double test = Math.round(Math.random());
			if (test == eingabe) {
				System.out.println("Easy win, nix trinken\n************************************");
			} else {
				Schlucke++;
				System.out.println("Ein Schluck\n************************************");
			}
			System.out.println();
			int Karte = (int)Math.round(Math.random()*10); 
			int Karte2 = (int)Math.round(Math.random()*10); 
			String eingabe2 = "";
			System.out.println("Höher oder tiefer als "+Karte+"?");
			
			userInput = eingabe2.toLowerCase();
			
			if(eingabe2 == "höher") {
				if(Karte2 > Karte) {
					System.out.println("Nice, gewonnen");
				}else {
					Schlucke++;
					System.out.println("Ein schluck mehr");
				}
			}else if(eingabe2 == "tiefer") {
				if(Karte2 < Karte) {
					System.out.println("Nice, gewonnen");
				}else {
					Schlucke++;
					System.out.println("Ein schluck mehr");
				}
			}
			
			
			String eingabe3 = ""; 
			System.out.println();
			
			System.out.println("Außerhalb oder zwischendrin?");
			int Karte3 =(int)Math.round(Math.random()*10); 
			userInput = eingabe3;
		
			
			
		}
	}

}