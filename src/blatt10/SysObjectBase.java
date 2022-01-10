package blatt10;

public class SysObjectBase {
	private String name;// Name
	private String owner;// Besitzer

	/**
	 * Konstruktor
	 * 
	 * @param name = Name des Verzeichnis
	 */
	public SysObjectBase(String name) {
		this.name = name;
		this.owner = System.getenv("USERNAME");

	}

	public String toString() {
		return ("Class = '" + this.getClass().getSimpleName() + "', Name = '" + this.name + "', User = '" + this.owner+"'");
	}

	// Getter und Setter
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		SysObjectBase firstTestBase = new SysObjectBase("TestBase");
		SysObjectBase secondTestBase = new SysObjectBase("TestBase2");
		System.out.println(firstTestBase);
		SysTextFile testTextFile = new SysTextFile("lorem50Chars",
				"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor\ninvidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.\nAt vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren,\nno sea takimata sanctus est Lorem ipsum dolor sit amet.");
		System.out.println(testTextFile);
		SysDirectory testtt = new SysDirectory("test System Directory", firstTestBase, secondTestBase);
		System.out.println(testtt);

	}
}
