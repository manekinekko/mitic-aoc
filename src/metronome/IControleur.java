package metronome;

import metronome.core.IMoteurMetronome;

/**
 * Cette interface définit les méthodes à implémenter par la classe Controleur.
 * 
 * @author Wassim Chegham <contact@cheghamwassim.com>
 * @author Gurval Le Bouter <gurval.lebouter@gmail.com>
 * @version 1.0
 */
public interface IControleur {

	/**
	 * Démarre le moteur.
	 * 
	 * @version 1.0
	 */
	public void demarrer();

	/**
	 * Stoppe le moteur.
	 * 
	 * @version 1.0
	 */
	public void stopper();

	/**
	 * Méthode appelée par l'horloge pour marquer un temps.
	 * 
	 * @version 1.0
	 */
	public void marquerTemps();

	/**
	 * La valeur du slider a changé, mise a jour du tempo dans le moteur.
	 * 
	 * @param valeur
	 * @version 1.0
	 */
	public void setSlider(int valeur);

	/**
	 * Le moteur notifie le contrôleur du changement de l'état du moteur
	 * (démarré ou stoppé).
	 * 
	 * @version 1.0
	 */
	public void updateEtatMoteur();

	/**
	 * Le moteur notifie le contrôleur de l'incrémentation du nombre de temps
	 * par mesure.
	 * 
	 * @version 1.0
	 */
	public void updateCommandeInc();

	/**
	 * Le moteur notifie le contrôleur de la décrémentation du nombre de temps
	 * par mesure.
	 * 
	 * @version 1.0
	 */
	public void updateCommandeDec();

	/**
	 * TODO: supprimer cette méthode?
	 * 
	 * @version 1.0
	 */
	public void updateCommandeMarqueurTemps();

	/**
	 * Le moteur notifie le contrôleur du changement de la valeur du tempo.
	 * 
	 * @version 1.0
	 */
	public void updateCommandeSlider();

	/**
	 * Retourne l'IHM instanciée dans le contrôleur.
	 * 
	 * @return ihm l'ihm du contrôleur.
	 * @version 1.0
	 */
	public IIHM getIHM();

	/**
	 * Retourne le moteur instancié dans le contrôleur.
	 * 
	 * @return moteur le moteur du contrôleur.
	 * @version 1.0
	 */
	public IMoteurMetronome getMoteur();

	/**
	 * Mise a jour de la valeur du slider dans le moteur.
	 * 
	 * @version 1.0
	 */
	public void updateSlider();

	/**
	 * Incrémente le nombre de temps par mesure dans le moteur.
	 * 
	 * @version 1.0
	 */
	public void incrementer();

	/**
	 * Décrémente le nombre de temps par mesure dans le moteur.
	 * 
	 * @version 1.0
	 */
	public void decrementer();

	/**
	 * Éteint une led dans l'IHM.
	 * 
	 * @param led la led à éteindre.
	 * @version 1.0
	 */
	public void eteindreLed(int led);

	/**
	 * Méthode appelée par l'horloge pour marquer la mesure.
	 * 
	 * @version 1.0
	 */
	public void marquerMesure();

}
