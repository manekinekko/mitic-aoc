package metronome;

import javax.swing.JButton;
import javax.swing.JSlider;

public interface IIHM {
	
	public void afficherTempo(int tempo);
	public void setEtatBouton(JButton bouton, boolean etat);
	public void setEtatSlider(JSlider slider, boolean etat);
	public void allumerLED(int led);
	public void eteindreLED(int led);
	public void emettreClick();
	
	public JButton getBoutonDemarrer();
	public JButton getBoutonStop();
	public JButton getBoutonInc();
	public JButton getBoutonDec();
	public JSlider getSlider();
	public int getValeurSlider();
	public int getTempsParMesure();
	public void setTempsParMesure(int tempsParMesure);
	
}