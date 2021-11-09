package blatt03;

import java.awt.*;
import javax.swing.JFrame;

/**
 * Klasse, um ein Raster zu malen
 */
public class LoesungKegel extends JFrame {

	/** Konstruktor. Nichts zu �ndern hier */
	public LoesungKegel() {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(610, 417);
		this.setTitle("L�sung in der Klasse " + this.getClass().getName());
		this.setVisible(true);
	}

	/** Main-Methode. Nichts zu �ndern hier. */
	public static void main(String[] args) {
		new LoesungKegel();
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

		this.meinKegel(g); // Aufruf der selbst programmierten Methode
	}

	/**
	 * Hier bitte die L�sung, um den Kegel zu zeichnen
	 * 
	 */
	public void meinKegel(Graphics g) {
		int x1 = this.getWidth() / 4;				//x bei 25% Breite
		int x2 = this.getWidth() * 3 / 4;			//x bei 75% Breite
		int y1 = this.getHeight() / 4;				//x bei 25% Breite
		int y2 = this.getHeight() * 3 / 4;			//y bei 75% Breite
		int xM = this.getWidth() / 2;				//x Mitte	
		int yM = this.getHeight() / 2;				//y Mitte
		int xLaenge = this.getWidth() / 2;

		g.drawLine(x1, y1, xM, yM);
		g.drawLine(x2, y1, xM, yM);
		g.drawLine(x1, y1, x2, y1);
		g.drawLine(x1, y2, xM, yM);
		g.drawLine(x2, y2, xM, yM);
		g.drawLine(x1, y2, x2, y2);

		for (int i = 1; i < 40; i++) {
			g.setColor(Color.GRAY);
			int currentX = x1 + i * xLaenge / 40;
			g.drawLine(currentX, y1, xM, yM);
			g.drawLine(currentX, y2, xM, yM);
		}
	}

}
