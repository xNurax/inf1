package blatt03;

import java.awt.*;
import javax.swing.JFrame;

/**
 * Klasse für erste eigene einfache Zeichnung
 */
public class LoesungDiagonalen extends JFrame {

	/** Konstruktor. Nichts zu ändern hier */
	public LoesungDiagonalen() {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setTitle("Lösung in der Klasse " + this.getClass().getName());
		this.setVisible(true);
	}

	/** Main-Methode. Nichts zu ändern hier. */
	public static void main(String[] args) {
		new LoesungDiagonalen();
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

		this.meineDiagonalen(g); // Aufruf der selbst programmierten Methode
	}

	/**
	 * Bitte den gegebenen Code unten aus der Methode meinPaint der Klasse
	 * LoesungsBeispiel so abändern, dass:
	 * <ol>
	 * <li>Das Rechteck komplett und in schwarz gemalt wird.</li>
	 * <li>Die Diagonale von links oben nach rechts unten in rot gezeichnet wird.
	 * </li>
	 * <li>Die Diagonale von rechts oben nach links unten in blau gezeichnet wird.
	 * </li>
	 * </ol>
	 * 
	 * @param g Grafik, auf die gezeichnet wird.
	 */
	public void meineDiagonalen(Graphics g) {
		int x25 = this.getWidth() / 4; // x-Koordinate bei 25% der Fensterbreite (von links)
		int x75 = this.getWidth() * 3 / 4; // x-Koordinate bei 75% der Fensterbreite (von links)
		int y25 = this.getHeight() / 4; // y-Koordinate bei 25% der Fensterbreite (von oben)
		int y75 = this.getHeight() * 3 / 4; // y-Koordinate bei 75% der Fensterbreite (von oben)

		// TODO: Komplettes Rechteck zeichnen
		g.drawLine(x75, y25, x25, y25);
		g.drawLine(x25, y25, x25, y75);
		g.drawLine(x25, y75, x75, y75);
		g.drawLine(x75, y75, x75, y25);

		// TODO: rote Diagonale zeichnen
		g.setColor(Color.RED);
		g.drawLine(x25,y25,x75,y75);

		// TODO: blaue Diagonale zeichnen
		g.setColor(Color.BLUE);
		g.drawLine(x75, y25, x25, y75);

	}
}
