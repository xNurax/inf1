package blatt05;

public class Bauer {
	public static void main(String[] args) {
		Bauer Walter = new Bauer("Walter");
		Huhn Heidrun = new Huhn("Heidrun", true);
		Huhn Heike = new Huhn("Heike", true);
		Huhn Hannelore = new Huhn("Hannelore", true);
		Walter.rufeHuhn(Heidrun);
		Walter.fuettern(Heidrun);
		Walter.rufeHuhn(Heike);
		Walter.fuettern(Heike);
		Walter.rufeHuhn(Hannelore);
		Walter.fuettern(Hannelore);
		System.out.println(berechneAnzahlHungrigerHuehner());

	}

	private String name;
	private static int anzahlGefuetterterHuehner;

	public Bauer(String name) {
		this.name = name;
	}

	public void fuettern(Huhn currentHuhn) {
		if(currentHuhn.getHungrig() == true) {
			currentHuhn.setHungrig();
			anzahlGefuetterterHuehner++;
		}else {
			return;
		}
	}

	public void rufeHuhn(Huhn currentHuhn) {
		System.out.println(currentHuhn.getName());
	}

	public static int berechneAnzahlHungrigerHuehner() {
	return (Huhn.getAnzahlHuehner()-anzahlGefuetterterHuehner);
	}

}
