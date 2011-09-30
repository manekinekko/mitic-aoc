import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;


public class LED extends JPanel {
	
	private Color couleur_;
	private String nom_;
	
	public LED(Color couleur, String nom){
		
		couleur_ = couleur;
		nom_ = nom;
		setPreferredSize(new Dimension(16, 16));
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(couleur_);
		g.fillOval(0, 0, getWidth(), getHeight());
		
	}

	public Color getCouleur() {
		return couleur_;
	}
	
	public void setCouleur(Color couleur) {
		couleur_ = couleur;
	}
	
}
