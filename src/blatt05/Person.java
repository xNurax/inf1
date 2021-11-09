package blatt05;

public class Person {
	protected String vorname;
	protected String nachname;

	/**
	 * Konstruktor
	 * @param vorname
	 * @param nachname
	 */
	public Person(String vorname, String nachname) {
		this.vorname = vorname;
		this.nachname = nachname;
	}

	
	public void print() {
		System.out.printf("%10s, %-10s", this.nachname, this.vorname);
	}
	/**
	 * Tests
	 * @param args unused
	 */
	public static void main(String[] args) {
		Person lin = new Person("Lin", "May");
		lin.print();
		Person k = new Person("Kai", "Hai");
		System.out.println(k.nachname);
		k.print();
	}
}
