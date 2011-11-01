package metronome;

import metronome.core.IMoteurMetronome;

public interface IControleur{

	public void demarrer();
	public void stopper();
	public void marquerTemps();
	public void setSlider(int valeur);
	
	public void updateEtatMoteur();
	public void updateCommandeInc();
	public void updateCommandeDec();
	public void updateCommandeMarqueurTemps();
	public void updateCommandeSlider();
	
	public IIHM getIHM();
	public IMoteurMetronome getMoteur();
	public void updateSlider();
	void incrementer();
	void decrementer();
	public void eteindreLed(int led_);
	
}
