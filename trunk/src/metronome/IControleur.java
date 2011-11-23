package metronome;

import metronome.core.IMoteurMetronome;

/**
 * Cette interface dÃ©finit les mÃ©thodes Ã  implÃ©menter par la classe Controleur.
 * 
 * @author Wassim Chegham <contact@cheghamwassim.com>
 * @author Gurval Le Bouter <gurval.lebouter@gmail.com>
 * @version 1.0
 */
public interface IControleur {

	/**
	 * DÃ©marre le moteur.
	 * 
	 * @since 1.0
	 */
	public void demarrer();

	/**
	 * Stoppe le moteur.
	 * 
	 * @since 1.0
	 */
	public void stopper();

	/**
	 * MÃ©thode appelÃ©e par l'horloge pour marquer un temps.
	 * 
	 * @since 1.0
	 */
	public void marquerTemps();

	/**
	 * La valeur du slider a changÃ©, mise a jour du tempo dans le moteur.
	 * 
	 * @param valeur
	 * @since 1.0
	 */
	public void setSlider(int valeur);

	/**
	 * Le moteur notifie le contrÃ´leur du changement de l'Ã©tat du moteur
	 * (dÃ©marrÃ© ou stoppÃ©).
	 * 
	 * @since 1.0
	 */
	public void updateEtatMoteur();

	/**
	 * Le moteur notifie le contrÃ´leur de l'incrÃ©mentation du nombre de temps
	 * par mesure.
	 * 
	 * @since 1.0
	 */
	public void updateCommandeInc();

	/**
	 * Le moteur notifie le contrÃ´leur de la dÃ©crÃ©mentation du nombre de temps
	 * par mesure.
	 * 
	 * @since 1.0
	 */
	public void updateCommandeDec();

	/**
	 * TODO: supprimer cette mÃ©thode?
	 * 
	 * @since 1.0
	 */
	public void updateCommandeMarqueurTemps();

	/**
	 * Le moteur notifie le contrÃ´leur du changement de la valeur du tempo.
	 * 
	 * @since 1.0
	 */
	public void updateCommandeSlider();

	/**
	 * Retourne l'IHM instanciÃ©e dans le contrÃ´leur.
	 * 
	 * @return ihm l'ihm du contrÃ´leur.
	 * @since 1.0
	 */
	public IIHM getIHM();

	/**
	 * Retourne le moteur instanciÃ© dans le contrÃ´leur.
	 * 
	 * @return moteur le moteur du contrÃ´leur.
	 * @since 1.0
	 */
	public IMoteurMetronome getMoteur();

	/**
	 * Mise a jour de la valeur du slider dans le moteur.
	 * 
	 * @since 1.0
	 */
	public void updateSlider();

	/**
	 * IncrÃ©mente le nombre de temps par mesure dans le moteur.
	 * 
	 * @since 1.0
	 */
	public void incrementer();

	/**
	 * DÃ©crÃ©mente le nombre de temps par mesure dans le moteur.
	 * 
	 * @since 1.0
	 */
	public void decrementer();

	/**
	 * Ã‰teint une led dans l'IHM.
	 * 
	 * @param led la led Ã  Ã©teindre.
	 * @since 1.0
	 */
	public void eteindreLed(int led);

	/**
	 * MÃ©thode appelÃ©e par l'horloge pour marquer la mesure.
	 * 
	 * @since 1.0
	 */
	public void marquerMesure();

}
