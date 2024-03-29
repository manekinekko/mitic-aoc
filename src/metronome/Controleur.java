package metronome;

import metronome.adapter.Adapter;
import metronome.adapter.Materiel;
import metronome.command.CommandeEteindreLed;
import metronome.command.CommandeSlider;
import metronome.core.IHorloge;
import metronome.core.IMoteurMetronome;
import metronome.core.MoteurMetronome;

/**
 * Cette classe fait office de contrôleur dans le pattern MVC. Elle permet à
 * l'IHM d'interagir sur le moteur et vice versa.
 * 
 * @author <ul>
 *         <li>Wassim Chegham (<a
 *         href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li>
 *         <li>Gurval Le Bouter (<a
 *         href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li>
 *         </ul>
 * @version 1.0
 * @see IControleur
 */
public class Controleur implements IControleur, Constantes {

	private IMoteurMetronome moteur_;
	private IIHM ihm_;
	private IHorloge horloge_;
	@SuppressWarnings("unused")
	private Adapter adapter_;

	/**
	 * Constructeur du contrôleur
	 * 
	 * @since 1.0
	 */
	public Controleur() {
		horloge_ = Materiel.getHorloge();
		moteur_ = new MoteurMetronome(this, horloge_);
		ihm_ = new IHM(this);
		changeEtatBouttonsIncDec_();
		ihm_.afficherMesure(moteur_.getTempsParMesure());
		
		// mise a jour de la valeur du tempo de l'IHM
		new CommandeSlider(this).execute();
		adapter_ = new Adapter(this);
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
			changeEtatBouttonsIncDec_();
		} else {
			ihm_.setEtatBouton(ihm_.getBoutonStop(), false);
			ihm_.setEtatBouton(ihm_.getBoutonDemarrer(), true);
			changeEtatBouttonsIncDec_();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void incrementer() {
		int mesure = moteur_.getTempsParMesure() + 1;
		moteur_.setTempsParMesure(mesure);
		ihm_.afficherMesure(mesure);
		changeEtatBouttonsIncDec_();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void decrementer() {
		int mesure = moteur_.getTempsParMesure() - 1;
		moteur_.setTempsParMesure(mesure);
		ihm_.afficherMesure(mesure);
		changeEtatBouttonsIncDec_();
	}

	/**
	 * Active ou désactive les boutons INC/DEC de l'IHM en fonction du nombre de
	 * temps par mesure.
	 * 
	 * @since 1.0
	 */
	private void changeEtatBouttonsIncDec_() {
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
		int ancienneValeur = moteur_.getTempo();
		int valeur = ihm_.getValeurSlider();
		valeur = convertirTempo_(valeur);
		if (ancienneValeur != valeur) {
			moteur_.setTempo(valeur);
		}
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
	 * 
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

		horloge_.activerApresDelai(new CommandeEteindreLed(this, Constantes.LED_1),
				0.15F);
		ihm_.allumerLED(Constantes.LED_1);
		ihm_.emettreClick();
		ihm_.showNextMesureIndicator();
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
		horloge_.activerApresDelai(new CommandeEteindreLed(this, Constantes.LED_2),
				0.15F);
		ihm_.allumerLED(Constantes.LED_2);
	}

}
