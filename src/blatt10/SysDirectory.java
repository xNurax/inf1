package blatt10;

public class SysDirectory extends SysObjectBase {
	String name;
	SysObjectBase[] sysObjects;

	SysDirectory(String name, SysObjectBase... sysObjects) {
		super(name);
		this.sysObjects = sysObjects;
	}

	public String toString() {
		String ret = super.toString();
		ret += ", NumberOfObjects = '" + this.sysObjects.length+"'";
		return ret;
	}

	public String dirStructure(String indent) {
		String toReturn = "";
		indent += "  |-📁 ";
		for (SysObjectBase sysObject : this.sysObjects) {

			// Objekt einrücken und neue Zeile Beginnen
			toReturn += indent + sysObject + "\n";

			// Wenn das übergebene sysObject eine Instanz der Klasse SysDirectory,
			// also relevant als Verzeichnis ist ruft man rekursiv Methode auf um
			// gegebenenfalls subverzeichnisse zu drucken
			if (sysObject instanceof SysDirectory) {
				
				//Whitespaces für schöne folder Struktur
				indent = "   ";
				
				//Methode neu Aufrufen, vorher gegebenes Object als SysDirectory casten um erneut 
				//zugang zur dirStructure Methode zu kriegen
				toReturn += ((SysDirectory) sysObject).dirStructure(indent);
				
				//nach Beendigung eines tiefergehendenden Verzeichnis Struktur wiederherstellen
				indent = "  |-📁 ";

			}
		}
		return toReturn;
	}

}
