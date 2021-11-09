package blatt04;

import java.awt.*;
import javax.swing.JFrame;

/**
 * Klasse für das Zeichnen eines Sterns
 */
public class LoesungStern extends JFrame {

	/** Konstruktor. Nichts zu ändern hier */
	public LoesungStern() {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setTitle("Lösung in der Klasse " + this.getClass().getName());
		this.setVisible(true);
	}

	/** Main-Methode. Nichts zu ändern hier. */
	public static void main(String[] args) {
		new LoesungStern();
	}

	/**
	 * Paint-Methode. Nichts zu ändern hier. Diese Methode wird beim Öffnen des
	 * Fensters automatisch aufgerufen. Die Methode wird auch aufgerufen, wenn die
	 * Größe des Fensters verändert wird.
	 * 
	 * @param g Grafik, auf die gezeichnet wird.
	 */
	public void paint(Graphics g) {
		/* Löschen des Fensterinhalts (wichtig bei erneutem Zeichnen): */
		g.clearRect(0, 0, this.getWidth(), this.getHeight());

		this.meinStern(g); // Aufruf der selbst programmierten Methode
	}

	/**
	 * Hier bitte die Lösung, um den Stern zu zeichnen
	 * 
	 */
	
		
	
	public void meinStern(Graphics g) {
		int xM = this.getWidth() / 2;
		int yM = this.getHeight() / 2;
		int x;
		int y;
		int r = 150;
		int r2 = r / 2;
		int n = 24 * 2;
		for (int i = 0; i < n; i++) {

			double angle = i * (2 * (Math.PI)) / n;
			double cosPhi = Math.cos(angle);
			double sinPhi = Math.sin(angle);
			if (i % 2 != 0) {
				x = (int) (r2 * cosPhi);
				y = (int) (r2 * sinPhi);
			} else {
				x = (int) (r * cosPhi);
				y = (int) (r * sinPhi);
			}
			g.setColor(Color.MAGENTA);
			g.drawLine(xM, yM, x + xM, y + yM);

		}
	}
}
