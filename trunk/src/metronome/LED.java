package metronome;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;


public class LED extends JPanel implements ILED{
	
	private static final long serialVersionUID = 1L;
	private Color couleur_;
	private int height_;
	private int width_;
	private long flashDelay_;
	private LEDRunnable ledRunnable_;
	
	
	public LED(Color couleur){
		couleur_ = couleur;
		setPreferredSize(new Dimension(width_, height_));
		height_ = 16;
		width_ = 16;
		flashDelay_ = 1000;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(couleur_);
		g.fillOval(getWidth()<=width_?0:(getWidth()-width_)/2, 
				getHeight()<=height_?0:(getHeight()-height_)/2, 
				width_, height_);
		System.out.println(couleur_);
	}

	@Override
	public Color getCouleur() {
		return couleur_;
	}
	
	@Override
	public synchronized void setCouleur(Color couleur) {
		couleur_ = couleur;
	}

	public void flasher() {
		ledRunnable_ = new LEDRunnable(this, flashDelay_);
		ledRunnable_.start();
	}
	
}
