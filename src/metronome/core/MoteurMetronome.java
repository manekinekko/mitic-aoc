package metronome.core;

import metronome.Constantes;
import metronome.IControleur;
import metronome.command.CommandeMarqueurMesure;
import metronome.command.CommandeMarqueurTemps;
import metronome.command.CommandeTic;
import metronome.command.ICommand;

/**
 * Cette classe est le coeur du programme. Elle permet de stocker et de
 * récupérer les différentes valeurs nécessaires au bon fonctionnement du
 * métronome, comme son état, le tempo, le nombre de temps par mesure...<br/>
 * <b>En d'autres termes cette classe représente le Model du pattern MVC.</b>
 * 
 * @author <ul>
 *         <li>Wassim Chegham (<a
 *         href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li>
 *         <li>Gurval Le Bouter (<a
 *         href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li>
 *         </ul>
 * @version 1.0
 * @see IMoteurMetronome
 */
public class MoteurMetronome implements IMoteurMetronome, Constantes {

	private boolean etatMarche_;
	private IControleur controleur_;
	private IHorloge horloge_;

	private ICommand commandeTic_;
	private ICommand commandeMarqueurTemps_;
	private ICommand commandeMarqueurMesure_;

	private int tempo_;
	private int tempsParMesure_;
	private int mesureActuelle_;

	/**
	 * Le constructeur du metronome. Permet d'initialiser les valeurs ainsi que
	 * les différentes commandes.
	 * 
	 * @param controleur le contrôleur à qui appartient ce moteur.
	 * @param horloge l'horloge destinée à activer les commandes.
	 * @since 1.0
	 */
	public MoteurMetronome(IControleur controleur, IHorloge horloge) {
		horloge_ = horloge;
		controleur_ = controleur;
		etatMarche_ = false;
		setTempsParMesure(4);
		tempo_ = 0;
		mesureActuelle_ = 0;

		commandeMarqueurTemps_ = new CommandeMarqueurTemps(controleur_);
		commandeMarqueurMesure_ = new CommandeMarqueurMesure(controleur_);
		commandeTic_ = new CommandeTic(controleur_);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getTempo() {
		return tempo_;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTempo(int tempo) {
		
		if ( tempo > MAX_TEMPO ) {
			tempo = MAX_TEMPO;
		}
		else if ( tempo < MIN_TEMPO ) {
			tempo = MIN_TEMPO;
		}
		
		tempo_ = tempo;
		controleur_.updateCommandeSlider();
		desactiverLesCommandes_();
		activerLesCommandes_();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean getEtatMarche() {
		return etatMarche_;
	}

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * Désactive toutes les commandes activées périodiquement de l'horloge.
	 * 
	 * @since 1.0
	 */
	private void desactiverLesCommandes_() {
		horloge_.desactiver(commandeTic_);
	}

	/**
	 * Active périodiquement la commande tic (qui appelle la méthode
	 * traiterCommandeTic).
	 * 
	 * @since 1.0
	 */
	private void activerLesCommandes_() {

		if (etatMarche_ && tempo_ > 0) {
			horloge_.activerPeriodiquement(commandeTic_, (float) (60.0 / tempo_));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getTempsParMesure() {
		return tempsParMesure_;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTempsParMesure(int tempsParMesure) {
		if (tempsParMesure >= MAX_TEMPS_PAR_MESURE) {
			tempsParMesure_ = MAX_TEMPS_PAR_MESURE;
		} else if (tempsParMesure <= MIN_TEMPS_PAR_MESURE) {
			tempsParMesure_ = MIN_TEMPS_PAR_MESURE;
		} else {
			tempsParMesure_ = tempsParMesure;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traiterCommandeTic() {
		commandeMarqueurTemps_.execute();

		if (mesureActuelle_ == tempsParMesure_) {
			mesureActuelle_ = 0;
		}

		if (mesureActuelle_ == 0) {
			commandeMarqueurMesure_.execute();
		}

		mesureActuelle_++;

	}

}
