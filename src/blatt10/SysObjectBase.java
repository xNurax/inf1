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
		return String.format("Class = '%s', Name = '%s', User = '%s'", this.getClass().getSimpleName(), this.name, this.owner);
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
		String seperator = ("----------------------------------------------------------------------");
		SysObjectBase firstTestBase = new SysObjectBase("TestBase");
		SysObjectBase secondTestBase = new SysObjectBase("TestBase2");
		System.out.println(firstTestBase);
		
		System.out.println(seperator);
		
		SysTextFile testTextFile = new SysTextFile("lorem50Chars", "java");
		testTextFile.setText(
				"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor\ninvidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.\nAt vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren,\nno sea takimata sanctus est Lorem ipsum dolor sit amet.");
		System.out.println(testTextFile);
		SysDirectory testtt = new SysDirectory("test System Directory", firstTestBase, secondTestBase);
		
		System.out.println(seperator);
		
		System.out.println(testtt);
		
		System.out.println(seperator);
		
		System.out.println(testtt.dirStructure(""));
		
		System.out.println(seperator);
		
		SysTextFile hello = new SysTextFile("Hello", "java");
		hello.setText("public class HelloWorld{/*...*/}");
		SysTextFile test = new SysTextFile("Test", "java");
		SysTextFile prt = new SysTextFile("PrintClass", "java");
		SysDirectory srcDir = new SysDirectory("SRC", hello, test, prt);
		SysTextFile todo = new SysTextFile("Todos", "txt");
		SysTextFile toget = new SysTextFile("Eggs", "rtm");
		SysDirectory txtDir = new SysDirectory("txt", todo, toget);
		SysDirectory home = new SysDirectory("home", srcDir, txtDir);
		srcDir.setName("SRC");
		toget.setName("Einkaufsliste");
		home.setName("HOME");
		home.setOwner("brul0001");
		System.out.printf("%s\n", home );
		System.out.printf("%s\n", home.dirStructure(""));
		System.out.println(seperator);


	}
}
