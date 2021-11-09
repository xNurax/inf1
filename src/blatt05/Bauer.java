package blatt05;

public class Bauer {
	public static void main(String[] args) {
		Bauer Walter = new Bauer("Walter");
		Huhn Heidrun = new Huhn("Heidrun", true);
		Huhn Heike = new Huhn("Heike", true);
		Huhn Hannelore = new Huhn("Hannelore", true);
		rufeHuhn(Heidrun);
		fuettern(Heidrun);
		rufeHuhn(Heike);
		fuettern(Heike);
		rufeHuhn(Hannelore);
		fuettern(Hannelore);
		System.out.println(Hannelore.getHungrig());
		System.out.println(berechneAnzahlHungrigerHuehner());

	}

	private String name;
	private static int anzahlGefuetterterHuehner;

	public Bauer(String name) {
		this.name = name;
	}

	public static void fuettern(Huhn currentHuhn) {
		if(currentHuhn.getHungrig() == true) {
			currentHuhn.setHungrig();
			anzahlGefuetterterHuehner++;
		}else {
			return;
		}
	}

	public static void rufeHuhn(Huhn currentHuhn) {
		System.out.println(currentHuhn.getName());
	}

	public static int berechneAnzahlHungrigerHuehner() {
	return (Huhn.getAnzahlHuehner()-anzahlGefuetterterHuehner);
	}

}
