package metronome;

import metronome.command.MetronomeCommandeFactory;
import metronome.core.HorlogeWrapper;
import metronome.core.IHorloge;
import metronome.core.IMoteurMetronome;
import metronome.core.MoteurMetronome;

/**
 * Cette classe fait office de contrôleur dans ls pattern MVC. Elle permet à
 * l'IHM d'interagir sur le moteur et vice versa.
 * 
 * @author Wassim Chegham <contact@cheghamwassim.com>
 * @author Gurval Le Bouter <gurval.lebouter@gmail.com>
 * @version 1.0
 * @see IControleur
 */
public class Controleur implements IControleur, Constantes {

	private IMoteurMetronome moteur_;
	private IIHM ihm_;
	private IHorloge horloge_;

	/**
	 * Constructeur du controleur
	 * @since 1.0
	 */
	public Controleur() {
		horloge_ = new HorlogeWrapper();
		moteur_ = new MoteurMetronome(this, horloge_);
		ihm_ = new IHM(this);
		changeEtatBouttonsIncDec();
		// mise a jour de la valeur du tempo de l'IHM
		MetronomeCommandeFactory.creerCommandeSlider(this).execute();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void demarrer() {
		moteur_.setEtatMarche(true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stopper() {
		moteur_.setEtatMarche(false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateEtatMoteur() {
		if (moteur_.getEtatMarche()) {
			ihm_.setEtatBouton(ihm_.getBoutonStop(), true);
			ihm_.setEtatBouton(ihm_.getBoutonDemarrer(), false);
			changeEtatBouttonsIncDec();
		} else {
			ihm_.setEtatBouton(ihm_.getBoutonStop(), false);
			ihm_.setEtatBouton(ihm_.getBoutonDemarrer(), true);
			changeEtatBouttonsIncDec();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void incrementer() {
		moteur_.setTempsParMesure(moteur_.getTempsParMesure() + 1);
		changeEtatBouttonsIncDec();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void decrementer() {
		moteur_.setTempsParMesure(moteur_.getTempsParMesure() - 1);
		changeEtatBouttonsIncDec();
	}

	/**
	 * Active ou désactive les boutons INC/DEC de l'IHM en fonction du nombre de
	 * temps par mesure.
	 * @since 1.0
	 */
	private void changeEtatBouttonsIncDec() {
		if (moteur_.getTempsParMesure() > MoteurMetronome.MIN_TEMPS_PAR_MESURE) {
			ihm_.setEtatBouton(ihm_.getBoutonDec(), true);
		} else {
			ihm_.setEtatBouton(ihm_.getBoutonDec(), false);
		}
		if (moteur_.getTempsParMesure() < MoteurMetronome.MAX_TEMPS_PAR_MESURE) {
			ihm_.setEtatBouton(ihm_.getBoutonInc(), true);
		} else {
			ihm_.setEtatBouton(ihm_.getBoutonInc(), false);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateSlider() {
		int valeur = ihm_.getValeurSlider();
		valeur = convertirTempo_(valeur);
		moteur_.setTempo(valeur);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateCommandeSlider() {
		int tempo = moteur_.getTempo();
		ihm_.afficherTempo(tempo);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSlider(int valeur) {
		valeur = convertirTempo_(valeur);
		moteur_.setTempo(valeur);
	}

	/**
	 * Convertit la la valeur rendu par le slider vers le tempo correspondant
	 * @param valeur la valeur du slider
	 * @return le tempo
	 */
	private int convertirTempo_(int valeur) {
		if (valeur < 0) {
			valeur = MIN_TEMPO;
		} else if (valeur > 1000) {
			valeur = MAX_TEMPO;
		} else {
			valeur = (int) MIN_TEMPO + valeur * (MAX_TEMPO - MIN_TEMPO) / 1000;
		}
		
		return valeur;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IIHM getIHM() {
		return ihm_;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IMoteurMetronome getMoteur() {
		return moteur_;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void marquerTemps() {

		ihm_.allumerLED(1);
		horloge_.activerApresDelai(MetronomeCommandeFactory.creerCommandeEteindreLed(this, 1),
				0.15F);
		ihm_.emettreClick();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void eteindreLed(int led) {
		ihm_.eteindreLED(led);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void marquerMesure() {
		ihm_.allumerLED(2);
		horloge_.activerApresDelai(MetronomeCommandeFactory.creerCommandeEteindreLed(this, 2),
				0.15F);
	}

}
