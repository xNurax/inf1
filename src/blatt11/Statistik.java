package blatt11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Klasse, um Mittelwert zu berechnen
 * 
 * @author Ulrich.Broeckl@hs-karlsruhe.de
 *
 */
public class Statistik {
	private double summe;

	protected double n;

	String name;

	/**
	 * Konstruktor
	 * 
	 * @param name Identifikator/Name für die Statistik
	 * @throws Exception 
	 */
	public Statistik(String name) throws Exception {
		if(name == null) {
			throw new NullPointerException("Name cannot be null");
		}
		if(name =="") {
			throw new RuntimeException("Name cannot be empty");
		}
		if(!Character.isLetter(name.charAt(0))){
			throw new RuntimeException("Name must start with a letter");
		}
	
		this.name = name;

		
		this.summe = this.n = 0.;
	}

	/**
	 * Einen neuen Wert der Statistik hinzufügen
	 * 
	 * @param wert
	 */
	public void addWert(double wert) {
		this.n++;
		this.summe += wert;
	}

	/**
	 * Durchschnitt berechnen
	 * 
	 * @return Durchschnitt aller Werte
	 */
	double getDurchschnitt() throws RuntimeException {
		if (this.n == 0.0) {
			throw new RuntimeException("No average for an empty statistic availlable!!");
		}

		return this.summe / this.n;

	}

	/**
	 * Statistik in Zeichenkette ausgeben
	 * 
	 */
	@Override
	public String toString() throws RuntimeException {

		if (this.n == 0.0) {
			throw new RuntimeException("Empty statistic cannot be serialized");
		}
		return String.format("%12s: n==%10.0f, µ==%8f", this.name, this.n, this.getDurchschnitt());

	}

	/**
	 * Statistik in Datei mit dem Namen der Statistik und der Endung ".statistik"
	 * ausgeben
	 * 
	 * @see https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
	 */
	public void writeToFile() throws IOException {
		try {
			Files.write(Paths.get(this.name + ".statistik"), this.toString().getBytes());
		} catch (IOException e) {
			throw (e);
		}
	}

	public static void main(String[] args) throws Exception {

		TestStatistikAusnahmen d = new TestStatistikAusnahmen();
		d.testDateiAusgabe();
		d.testLeereStatistiken();
		d.testNames();
	}
}