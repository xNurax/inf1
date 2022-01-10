package blatt10;

public class SysTextFile {
	String type;
	String text;

	/**
	 * Konstruktor type: String = Dateityp, z.B. ".txt", ".java", ".mp3" text:
	 * String = Inhalt der Datei
	 */
	public SysTextFile(String type, String text) {
		this.type = type;
		this.text = text;
	}

	public String toString() {
		return ("mimeType = " + this.type + ", Length = " + this.text.length() + " Characters, FileContent is :'\n"
				+ this.text + "'");
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public static void main(String[] args) {
		SysTextFile test = new SysTextFile("Test", "Whatever");
		System.out.println(test);
	}
}
