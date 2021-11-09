package blatt04;

import java.awt.*;
import javax.swing.JFrame;

/**
 * Klasse f�r das zuf�llige Zeichnen von Sternen
 */
public class LoesungZufallsSterne extends JFrame {

	/** Konstruktor. Nichts zu �ndern hier */
	public LoesungZufallsSterne() {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1024, 768);
		this.setTitle("L�sung in der Klasse " + this.getClass().getName());
		this.setVisible(true);
	}

	/**
	 * Paint-Methode. Nichts zu �ndern hier. Diese Methode wird beim �ffnen des
	 * Fensters automatisch aufgerufen. Die Methode wird auch aufgerufen, wenn die
	 * Gr��e des Fensters ver�ndert wird.
	 * 
	 * @param g Grafik, auf die gezeichnet wird.
	 */
	public void paint(Graphics g) {
		/* L�schen des Fensterinhalts (wichtig bei erneutem Zeichnen): */
		g.clearRect(0, 0, this.getWidth(), this.getHeight());

		this.meineZufallsSterne(g); // Aufruf der selbst programmierten Methode
	}

	/** Main-Methode. Nichts zu �ndern hier. */
	public static void main(String[] args) {
		new LoesungZufallsSterne();
	}

	/**
	 * Bitte ab hier L�sung zum Zeichnen der zuf�lligen Sterne entwickeln.
	 */
	/**
	 * 1. Teilaufgabe: Methode, um einen Stern zu zeichnen.
	 * 
	 * @param g    Grafikbereich, auf dem gezeichnet wird
	 * @param midX x-Koordinate des Mittelpunkts des Sterns
	 * @param midY y-Koordinate des Mittelpunkts des Sterns
	 * @param r    Radius des Sterns
	 */
	public void zeichneEinenStern(Graphics g, int midX, int midY, int r) {
		int xM = midX;
		int yM = midY;
		int x;
		int y;
		int radius = r;
		int r2 = radius / 2;
		int n = 24 * 2;
		for (int i = 0; i < n; i++) {

			double angle = i * (2 * (Math.PI)) / n;
			double cosPhi = Math.cos(angle);
			double sinPhi = Math.sin(angle);
			if (i % 2 != 0) {
				x = (int) (r2 * cosPhi);
				y = (int) (r2 * sinPhi);
			} else {
				x = (int) (radius * cosPhi);
				y = (int) (radius * sinPhi);
			}
			g.setColor(Color.MAGENTA);
			g.drawLine(xM, yM, x + xM, y + yM);

		}
	}

	/**
	 * 2. Teilaufgabe: Sterne zuf�llig platzieren mit zuf�lligem Radius
	 */

	public void meineZufallsSterne(Graphics g) {
		for (int i = 1; i <= 500; i++) {
			double x = Math.random() * this.getWidth();
			int ix = (int) (x);
			double y = Math.random() * this.getHeight();
			int iy = (int) (y);
			int nr = 20;
			zeichneEinenStern(g, ix, iy, nr);
		}

	}
}
