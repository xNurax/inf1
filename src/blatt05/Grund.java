package blatt05;

public class Grund {
	private String grund;

	public Grund(String grund) {
		if (grund.length() > 3 && grund != null) {
			this.grund = grund;
		}else {
			System.out.println("Grund muss länger als 3 Zeichen sein  und darf nicht undefined sein!");
			return;
		}
	}

	public String getGrund() {
		return this.grund;
	}
}
