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
	private ICommand commandeMarqueurMesure_;
	public static final int MIN_TEMPO = 40;
	public static final int MAX_TEMPO = 240;
	public static final int MIN_TEMPS_PAR_MESURE = 2;
	public static final int MAX_TEMPS_PAR_MESURE = 7;
	private int tempsParMesure_;
	private int mesureActuelle_;

	public MoteurMetronome(IControleur controleur, IHorloge horloge) {
		horloge_ = horloge;
		controleur_ = controleur;
		etatMarche_ = false;
		setTempsParMesure(4);
		tempo_ = 0;
		mesureActuelle_ = 0;

		commandeMarqueurTemps_ = MetronomeCommandeFactory
				.creerCommandeMarqueurTemps(controleur_);
		commandeMarqueurMesure_ = MetronomeCommandeFactory
				.creerCommandeMarqueurMesure(controleur_);
		commandeTic_ = MetronomeCommandeFactory.creerCommandeTic(controleur_);
	}

	@Override
	public int getTempo() {
		return tempo_;
	}

	@Override
	public void setTempo(int tempo) {
		tempo_ = (int) MIN_TEMPO + tempo*(MAX_TEMPO-MIN_TEMPO)/1000;
		controleur_.updateCommandeSlider();
		desactiverLesCommandes_();
		activerLesCommandes_();
		System.out.println(tempo);
	}

	@Override
	public boolean getEtatMarche() {
		return etatMarche_;
	}

	@Override
	public void setEtatMarche(boolean etatMarche) {
		etatMarche_ = etatMarche;
		controleur_.updateEtatMoteur();

		if (etatMarche_) {
			desactiverLesCommandes_();
			activerLesCommandes_();
		} else {
			horloge_.desactiver(commandeTic_);
		}

	}

	private void desactiverLesCommandes_() {
		horloge_.desactiver(commandeTic_);
	}

	private void activerLesCommandes_() {

		if (etatMarche_ && tempo_ > 0) {
			horloge_.activerPeriodiquement(commandeTic_,
					(float) (60.0 / tempo_));
		}
	}

	@Override
	public int getTempsParMesure() {
		return tempsParMesure_;
	}

	@Override
	public void setTempsParMesure(int tempsParMesure) {
		if(tempsParMesure >= MAX_TEMPS_PAR_MESURE){
			tempsParMesure_ = MAX_TEMPS_PAR_MESURE;
		} else if(tempsParMesure <= MIN_TEMPS_PAR_MESURE){
			tempsParMesure_ = MIN_TEMPS_PAR_MESURE;
		} else {
			tempsParMesure_ = tempsParMesure;
		}
	}

	@Override
	public void traiterCommandeTic() {
		commandeMarqueurTemps_.execute();
		
		if(mesureActuelle_ == tempsParMesure_){
			mesureActuelle_ = 0;
		}
		
		if(mesureActuelle_ == 0){
			commandeMarqueurMesure_.execute();
		}
		
		mesureActuelle_++;
		
	}
	
	public int getTempsParMesure_() {
		return tempsParMesure_;
	}

	@Override
	public void attach(IControleur o) {
		//TODO virer cette methode?
	}

	@Override
	public void detach(IControleur o) {
		//TODO virer cette methode?
	}

}
