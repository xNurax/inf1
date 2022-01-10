package blatt10;

public class IntegerValueObject {
	private static int i;

	public IntegerValueObject(int i) {
		this.i = i;
	}

	public int getI() {
		return this.i;
	}

	/**
	 * Werte zusammenzählen
	 * 
	 * @param j zweiter Summand
	 * @return this.i + j als neues Value-Object
	 */
	public IntegerValueObject add(int zweiterSummand) {
		return new IntegerValueObject((this.i + zweiterSummand));
	}

	public static void main(String[] args) {
		IntegerValueObject testObject = new IntegerValueObject(1);
		System.out.println(testObject.add(5));
	}

}
