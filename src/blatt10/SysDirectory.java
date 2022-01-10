package blatt10;

public class SysDirectory {
	String name;
	SysObjectBase[] sysObjects;
	SysDirectory(String name, SysObjectBase ... sysObjects){
		this.name = name;
		this.sysObjects = sysObjects;
	}
	public String toString() {
	return ("Class = SysDirectory, Name of Directory = "+ this.name+", NumberOfObjects = "+ this.sysObjects.length);
	}
	
}
