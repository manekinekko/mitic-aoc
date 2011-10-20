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

		commandeMarqueurTemps_ = MetronomeCommandeFactory
				.creerCommandeMarqueurTemps(controleur_);
		commandeTic_ = MetronomeCommandeFactory.creerCommandeTic(controleur_);
		horloge_ = new HorlogeWrapper();
	}

	@Override
	public int getTempo() {
		return tempo_;
	}

	@Override
	public void setTempo(int tempo) {
		tempo_ = (int) tempo;
		controleur_.updateCommandeSlider();
		desactiverLesCommandes_();
		activerLesCommandes_();
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
		return 0;
	}

	@Override
	public void setTempsParMesure(int tempsParMesure) {

	}

	@Override
	public void traiterCommandeTic() {
		commandeMarqueurTemps_.execute();
	}

	@Override
	public void attach(IControleur o) {
	}

	@Override
	public void detach(IControleur o) {
	}

}
