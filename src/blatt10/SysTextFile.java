package blatt10;

public class SysTextFile extends SysObjectBase{
	String type;
	String text;

	/**
	 * Konstruktor type: String = Dateityp, z.B. ".txt", ".java", ".mp3" text:
	 * String = Inhalt der Datei
	 */
	public SysTextFile(String name, String type) {
		super(name);
		this.type = type;
		
	}

	public String toString() {
		return String.format("%s, mimeType = '%s', Length= '%d' ",
				super.toString(), this.type, this.length() );
	}
	/**
	 * Überschreiben von .length() um exceptions bei undefinierden Strings zu verhindern
	 * @return
	 */
	public int length(){
		return this.text == null ? 0 : this.text.length();
}
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}

