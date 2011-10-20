package metronome;

import metronome.core.IMoteurMetronome;
import metronome.core.MoteurMetronome;

public class Controleur implements IControleur{
	
	private IMoteurMetronome moteur_;
	private IIHM ihm_;
	
	public Controleur(){
		moteur_ = new MoteurMetronome(this);
		ihm_ = new IHM(this);
		MetronomeCommandeFactory.creerCommandeSlider(this).execute();
	}
	
	public void demarrer() {
		moteur_.setEtatMarche(true);
	}
	
	public void stopper() {
		moteur_.setEtatMarche(false);
	}

	@Override
	public void marquerTemps() {
		ihm_.flasherLED();
		ihm_.emettre();
	}

	@Override
	public void updateEtatMoteur() {
		if ( moteur_.getEtatMarche() ){
			System.out.println("Le moteur vient de notifier le controleur qu'il vient de démarrer!");
			ihm_.setEtatBouton(ihm_.getBoutonStop(), true);
			ihm_.setEtatBouton(ihm_.getBoutonDec(), true);
			ihm_.setEtatBouton(ihm_.getBoutonInc(), true);
			ihm_.setEtatBouton(ihm_.getBoutonDemarrer(), false);
			ihm_.setEtatSlider(ihm_.getSlider(), true);
		}
		else {
			System.out.println("Le moteur vient de notifier le controleur qu'il vient de stopper!");
			ihm_.setEtatBouton(ihm_.getBoutonStop(), false);
			ihm_.setEtatBouton(ihm_.getBoutonDec(), false);
			ihm_.setEtatBouton(ihm_.getBoutonInc(), false);
			ihm_.setEtatBouton(ihm_.getBoutonDemarrer(), true);
			ihm_.setEtatSlider(ihm_.getSlider(), false);

		}
	}

	@Override
	public void updateCommandeInc() {
		
	}

	@Override
	public void updateCommandeDec() {
		
	}
	
	public void updateSlider(){
		int valeur = ihm_.getValeurSlider();
		moteur_.setTempo(valeur);
	}
	
	@Override
	public void updateCommandeSlider() {
		int tempo = moteur_.getTempo();
		ihm_.afficherTempo(tempo);
	}

	@Override
	public void updateCommandeMarqueurTemps() {
		
	}

	@Override
	public void setSlider(int valeur) {
		moteur_.setTempo(valeur);
	}

	@Override
	public IIHM getIHM() {
		return ihm_;
	}

	@Override
	public IMoteurMetronome getMoteur() {
		return moteur_;
	}
}
