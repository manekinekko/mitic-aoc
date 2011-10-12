package metronome;

import javax.swing.JButton;
import javax.swing.JSlider;

public interface IIHM {
	
	public void afficherTempo(int tempo);
	public void setEtatBouton(JButton bouton, boolean etat);
	public void setEtatSlider(JSlider slider, boolean etat);
	public void flasherLED();
	public void emettre();
	
	public JButton getBoutonDemarrer();
	public JButton getBoutonStop();
	public JButton getBoutonInc();
	public JButton getBoutonDec();
	public JSlider getSlider();
	
}