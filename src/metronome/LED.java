package metronome;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class LED extends JPanel implements ILED {

	private static final long serialVersionUID = 1L;
	private Color couleurOn_;
	private Color couleurOff_;
	private Color couleur_;
	private int height_;
	private int width_;

	public LED(Color on, Color off) {
		couleurOn_ = on;
		couleurOff_ = off;
		setPreferredSize(new Dimension(width_, height_));
		height_ = 16;
		width_ = 16;
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(couleur_);
		g.fillOval(getWidth() <= width_ ? 0 : (getWidth() - width_) / 2,
				getHeight() <= height_ ? 0 : (getHeight() - height_) / 2,
				width_, height_);
	}

	@Override
	public void allumer() {
		couleur_ = couleurOn_;
		repaint();
	}

	@Override
	public void eteindre() {
		couleur_ = couleurOff_;
		repaint();
	}
}
