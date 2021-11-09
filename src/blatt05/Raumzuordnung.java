package blatt05;

/** Beispiel für Referenzen: Klasse für Mitarbeiter-Raumzuordnung */
public class Raumzuordnung {
	private Raum raum; // Referenz auf Raum
	private Person nutzer; // Referenz auf Nutzer/in
	private String grund;

	// TODO Grund für Zuordnung (z.B. "Büroraum", "Labor") als Zeichenkette
	// ergänzen.
	// Darf nicht NULL sein und muss mindestens aus 3 Zeichen bestehen.
	// Bitte auch passende Zugriffsmethode und zusätzlichen Konstruktor
	// mit Zuordnungsgrund hinzufügen.

	/** Konstruktor */
	public Raumzuordnung(Raum raum, Person nutzer, String grund) {
		if (raum == null || nutzer == null || grund == null) {
			System.out.println("Error, Person or raum cant be undefined!");
			return;
		} else {
			this.raum = raum;
			this.nutzer = nutzer;
			this.grund = grund;
		}
	}

	public void print() {
		this.getNutzer().print();
		System.out.print(" nutzt den Raum: ");
		this.getRaum().print();
		if (grund.length() > 3) {
			System.out.print(" als " + this.grund);
		}
	}

	Raum getRaum() {
		return this.raum;
	}

	Person getNutzer() {
		return this.nutzer;
	}

	String getGrund() {
		return this.grund;
	}

	public static void main(String[] a) {
		// Bröckl nutzt den Raum E 212a
		Person ub = new Person("Ulrich", "Br�ckl");
		Raum e212a = new Raum("e 212a", 2);
		Raumzuordnung ub2e212a = new Raumzuordnung(e212a, ub, "B�ro");
		ub2e212a.print();

		// Bröckl nutzt außerdem den Raum E 201
		Raumzuordnung ub2e201 = new Raumzuordnung(new Raum("e 201", 77, true), ub, "B�ro");
		// Den Raum dieser Zuordnung ausgeben:
		System.out.print("\n     Au�erdem: ");
		ub2e201.getRaum().print();
		System.out.println("\n");

		// Vogelsang nutzt den Raum E 209
		Raumzuordnung hv2e209 = new Raumzuordnung(new Raum("e 209", 3), new Person("Holger", "Vogelsang"), "Labor");
		hv2e209.print();

	}

}
