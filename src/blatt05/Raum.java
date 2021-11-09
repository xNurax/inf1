package blatt05;

public class Raum {
	private String kuerzel;			// z.B. "E 201"
	private int anzahlPlaetze;		// wie viele Personen passen rein?
	private boolean hatAudio;		// gibt es eine Audioanlage?
	
	/** Konstruktor */
	public Raum(String kuerzel, int anzahlPlaetze){
		this.setKuerzel(kuerzel);
		this.setAnzahlPlaetze(anzahlPlaetze);
	}
	/** Alternativer Konstruktor mit Audioangabe */
	Raum(String kuerzel, int anzahlPlaetze, boolean hatAudio){
		this(kuerzel, anzahlPlaetze);	// Aufruf des Konstruktors mit 2 Parametern
		this.hatAudio = hatAudio;
	}
	
	/** Alternativer Konstruktor: K√ºrzel aus  K√ºrzel f√ºr Geb√§udenamen und Raumnummer bauen
	 *  @param gebaeudeKuerzel K√ºrzel des Geb√§udes, z.B. "E", "F", "SH", "LI"
	 *  @param anzahlPlaetze Anzahl der Pl√§tze in diesem Raum
	 *  */
	Raum(String gebaeudeKuerzel, int raumnummer, int anzahlPlaetze){
		this.setKuerzel(gebaeudeKuerzel + " " + raumnummer);
		this.setAnzahlPlaetze(anzahlPlaetze);
	}
	
	/** Einen Raum am Bildschirm ausgeben */
	public void print() {
		System.out.print("K¸rzel: " + this.getKuerzel() );
		System.out.print(", Pl‰tze: " + this.getAnzahlPlaetze() );
		System.out.print(", Pl‰tze bei Klausur: " + this.getAnzahlPlaetzeBeiKlausur() );
		if (this.hatAudio) {
			System.out.print(", mit Audio");	
		}
		else {
			System.out.print(", ohne Audio");	
		}
	}
	
	/** Anzahl der Pl√§tze setzen */
	public void setAnzahlPlaetze(int plaetze) {
		final int MINIMUM = 1;
		final int MAXIMUM = 500;
		if(plaetze < MINIMUM) {
			System.err.println("Die Anzahl der Pl‰tze muss grˆﬂer als " + 
					(MINIMUM - 1) + " sein." );
		}else if(plaetze > MAXIMUM) {
			System.err.println("Die Anzahl der Pl‰tze dar nicht grˆﬂer als "+MAXIMUM+"sein!" );
			
		}
		else {
			this.anzahlPlaetze = plaetze;
		}
	}
	
	/** Anzahl der Pl√§tze zur√ºckgeben */
	public int getAnzahlPlaetze() {
		return this.anzahlPlaetze;
	}
	/** Anzahl der Pl√§tze bei Klausuren zur√ºckgeben */
	public int getAnzahlPlaetzeBeiKlausur() {
		int freiePlaetzeJePruefling = 2;
		return this.getAnzahlPlaetze() / (1 + freiePlaetzeJePruefling);
	}
	
	/** K√ºrzel setzen */
	public void setKuerzel(String kuerzel) {
		final int MINIMALE_ANZAHL_ZEICHEN = 2;
		if(null == kuerzel) {
			System.err.println("Das K¸rzel darf nicht null sein!" );
		}
		else if (kuerzel.length() < MINIMALE_ANZAHL_ZEICHEN) {
			System.err.println("Das K¸rzel muss mindestens " + MINIMALE_ANZAHL_ZEICHEN + " Zeichen haben!" );
		}
		else {
			this.kuerzel = kuerzel;
		}
			
	}
	/** K√ºrzel zur√ºckgeben. Konvention: nur in Gro√übuchstaben, egal, was in der Instanzvariable steht */
	public String getKuerzel() {
		return this.kuerzel.toUpperCase();
	}
	
	/** Audio setzen */
	public void setHatAudio(boolean hatAudio) {
		this.hatAudio = hatAudio;
	}

	/** Audio holen */
	public boolean getHatAudio() {
		return this.hatAudio;
	}

	public static void main(String[] a) {
		// Ein Objekt der Klasse Raum mit Geb√§ude-K√ºrzel, Nummer und Sitzzahl instanziieren
		Raum f = new Raum("LI", 136, 21);
		f.setHatAudio( true );
		f.print();	
	}
	
}
