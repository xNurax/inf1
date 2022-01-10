package blatt10;

public class IntegerValueObject {
	private int i;
	
	/**
	* Konstruktor
	* @param i Wert des Objektes gegeben als Integer
	*/
	public IntegerValueObject(int i) {
		this.i = i;
	}
	/**
	 * Wert addieren
	 * @param j
	 * @return Neues IntegerValueObject resultierend aus unveränderlichem i + j
	 */
	public IntegerValueObject add(int j) {
		IntegerValueObject ret = new IntegerValueObject((this.i + j));
		return ret;
	}
	/**
	 * Wert multiplizieren
	 * @param j
	 * @return Neues IntegerValueObject resultierend aus unveränderlichem i * j
	 */
	public IntegerValueObject mul(int j) {
		IntegerValueObject ret = new IntegerValueObject((this.i * j));
		return ret;
	}
	/**Überschreiben der toString() Methode
	 * @return Zeichenkette aus Wert eines "IntegerValueObjects"
	 */
	public String toString() {
		// Spart einem beim Printen .i hintendran zu schreiben!!!
		return Integer.toString(this.i);

	}

	
	public static void main(String[] args) {
		IntegerValueObject testObject = new IntegerValueObject(5);
		System.out.println("Ursprüngliches i des Testobjektes ist : " + testObject);
		System.out.println("i des neuen Objekts nach der add Methode ist : " + (testObject.add(5)));
		System.out.println("i des Testobjekts ist unverändert immernoch : " + testObject);
		System.out.println("i des neuen Objekts nach der mul Methode ist : " + (testObject.mul(5)));
		System.out.println("i des Testobjekts ist unverändert immernoch : " + testObject);
		System.out.println("Beispielaufruf ergibt : " + new IntegerValueObject(2).mul(3).add(4).mul(5));
	}

}
