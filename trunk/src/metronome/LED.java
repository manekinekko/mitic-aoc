package metronome;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;


public class LED extends JPanel {
	
	private Color couleur_;
	private int height_;
	private int width_;
	
	public LED(Color couleur){
		couleur_ = couleur;
		setPreferredSize(new Dimension(width_, height_));
		height_ = 16;
		width_ = 16;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(couleur_);
		g.fillOval(getWidth()<=width_?0:(getWidth()-width_)/2, 
				getHeight()<=height_?0:(getHeight()-height_)/2, 
				width_, height_);
	}

	public Color getCouleur() {
		return couleur_;
	}
	
	public void setCouleur(Color couleur) {
		couleur_ = couleur;
	}
	
}
