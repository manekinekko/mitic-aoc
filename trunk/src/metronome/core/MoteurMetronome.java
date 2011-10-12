package metronome.core;

import metronome.IControleur;
import metronome.MetronomeCommandeFactory;
import metronome.command.ICommand;

public class MoteurMetronome implements IMoteurMetronome {

	private boolean etatMarche_;
	private IControleur controleur_;
	private int tempo_;
	private IHorloge horloge_;
	
	private ICommand commandeTic_;
	private ICommand commandeMarqueurTemps_;
	
	public MoteurMetronome(IControleur controleur) {
		controleur_ = controleur;
		etatMarche_ = false;
		tempo_ = 0;
		
		commandeMarqueurTemps_ = MetronomeCommandeFactory.creerCommandeMarqueurTemps(controleur_);
		commandeTic_ = MetronomeCommandeFactory.creerCommandeTic(controleur_);
		horloge_ = new Horloge();
		
	}

	@Override
	public int getTempo() {
		return tempo_;
	}

	@Override
	public void setTempo(int tempo) {
		tempo_ = tempo;
		controleur_.updateCommandeSlider();
	}

	@Override
	public boolean getEtatMarche() {
		return etatMarche_;
	}

	@Override
	public void setEtatMarche(boolean etatMarche) {
		etatMarche_ = etatMarche;
		controleur_.updateEtatMoteur();
		
		if ( etatMarche_ ){
			horloge_.activerPeriodiquement(commandeTic_, tempo_);
		}
		else {
			horloge_.desactiver(commandeTic_);
		}
		
	}

	@Override
	public int getTempsParMesure() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTempsParMesure(int tempsParMesure) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void traiterCommandeTic() {
		commandeMarqueurTemps_.execute();
	}

	@Override
	public void attach(IControleur o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void detach(IControleur o) {
		// TODO Auto-generated method stub

	}

}
