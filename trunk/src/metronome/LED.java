package metronome;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class LED extends JRadioButton implements ILED {

	private static final long serialVersionUID = 1L;
	private Color couleurOn_;
	private Color couleurOff_;
	private Color couleur_;
	private int height_;
	private int width_;
	private long time;


	public LED(Color on, Color off) {
//		couleurOn_ = on;
//		couleurOff_ = off;
//		setPreferredSize(new Dimension(width_, height_));
//		height_ = 16;
//		width_ = 16;
		setSelected(false);
	}

//	public void paint(Graphics g) {
//		super.paint(g);
//		g.setColor(couleur_);
//		g.fillOval(getWidth() <= width_ ? 0 : (getWidth() - width_) / 2,
//				getHeight() <= height_ ? 0 : (getHeight() - height_) / 2,
//				width_, height_);
//	}

	@Override
	public synchronized void allumer() {
		time = new Date().getTime();
		setSelected(true);
		//couleur_ = couleurOn_;
		//repaint();
	}

	@Override
	public synchronized void eteindre() {
		time = new Date().getTime() - time;
		System.out.println("Ecart entre allumer et eteindre:"+time);
		setSelected(false);
		//couleur_ = couleurOff_;
		//repaint();
	}
}
