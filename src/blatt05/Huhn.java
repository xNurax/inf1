package blatt05;

public class Huhn {
	private  String name;
	private  boolean hungrig;
	private  static int AnzahlHuehner = 0;


	public  Huhn(String name, boolean hungrig) {
		this.hungrig = hungrig;
		this.name = name;
		AnzahlHuehner++;
		
		
	}

	public static  int getAnzahlHuehner() {
		return AnzahlHuehner;
	}

	public String getName() {
		return this.name;
	}
	public boolean getHungrig() {
		return this.hungrig;
	}

	public void setHungrig() {
		this.hungrig = !hungrig;
	}
	
	
	

}
