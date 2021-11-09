package blatt03;

import java.awt.*;
import javax.swing.JFrame;

/**
 * Klasse f�r eine sehr einfache Zeichnung
 */

public class LoesungsBeispiel extends JFrame {

	/** Konstruktor. Nichts zu �ndern hier */
	public LoesungsBeispiel() {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setTitle("L�sung in der Klasse " + this.getClass().getName());
		this.setVisible(true);
	}

	/** Main-Methode. Nichts zu �ndern hier. */
	public static void main(String[] args) {
		new LoesungsBeispiel();
	}

	/**
	 * Beispiel f�r eine L�sung: Etwas wie ein "C" malen
	 * 
	 */
	public void paint(Graphics g) {
		int x25 = this.getWidth() / 4;
		int x75 = this.getWidth() * 3 / 4;
		int y25 = this.getHeight() / 4;
		int y75 = this.getHeight() * 3 / 4;

		g.drawLine(x75, y25, x25, y25);
		g.drawLine(x25, y25, x25, y75);

		// Beispiel f�r Einsatz anderer Farbe
		g.setColor(Color.RED);
		g.drawLine(x25, y75, x75, y75);
	}
}