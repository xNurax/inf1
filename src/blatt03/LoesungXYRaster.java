package blatt03;

import java.awt.*;
import javax.swing.JFrame;

/**
 * Klasse, um ein Raster zu malen
 */
public class LoesungXYRaster extends JFrame {

	/** Konstruktor. Nichts zu ändern hier */
	public LoesungXYRaster() {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(604, 417);
		this.setTitle("Lösung in der Klasse " + this.getClass().getName());
		this.setVisible(true);
	}

	/** Main-Methode. Nichts zu ändern hier. */
	public static void main(String[] args) {
		new LoesungXYRaster();
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

		this.meinRaster(g); // Aufruf der selbst programmierten Methode
	}

	/**
	 * Hier bitte die Lösung, um das Raster zu zeichnen
	 * 
	 */
	public void meinRaster(Graphics g) {
		int x1 = this.getWidth() / 4;
		int x2 = this.getWidth() * 3 / 4;
		int y1 = this.getHeight() / 4;
		int y2 = this.getHeight() * 3 / 4;
		int xLänge = this.getWidth() / 2;
		int yLänge = this.getHeight() / 2;

		for (int i = 0; i < 11; i++) {
			int currentX = x1 + i * xLänge / 10;
			int currentY = y1 + i * yLänge / 10;
			
			if (i % 2 != 0) {
				g.setColor(Color.GRAY);

			} else {
				g.setColor(Color.BLACK);

			}
			g.drawLine(currentX, y1, currentX, y2);  	//Vertikal
			g.drawLine(x1, currentY, x2, currentY);		//Horizontal

		}

	}
}
