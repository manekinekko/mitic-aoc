package metronome;

import metronome.core.IMoteurMetronome;

/**
 * Cette interface définit les méthodes à implémenter par la classe Controleur.
 * 
 * @author <ul>
 *         <li>Wassim Chegham (<a
 *         href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li>
 *         <li>Gurval Le Bouter (<a
 *         href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li>
 *         </ul>
 * @version 1.0
 */
public interface IControleur {

	/**
	 * Démarre le moteur.
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
	 * Méthode appelée par l'horloge pour marquer un temps.
	 * 
	 * @since 1.0
	 */
	public void marquerTemps();

	/**
	 * La valeur du slider a changé, mise a jour du tempo dans le moteur.
	 * 
	 * @param valeur
	 * @since 1.0
	 */
	public void setSlider(int valeur);

	/**
	 * Le moteur notifie le contrôleur du changement de l'état du moteur
	 * (démarré ou stoppé).
	 * 
	 * @since 1.0
	 */
	public void updateEtatMoteur();

	/**
	 * Le moteur notifie le contrôleur du changement de la valeur du tempo.
	 * 
	 * @since 1.0
	 */
	public void updateCommandeSlider();

	/**
	 * Retourne l'IHM instanciée dans le contrôleur.
	 * 
	 * @return ihm l'ihm du contrôleur.
	 * @since 1.0
	 */
	public IIHM getIHM();

	/**
	 * Retourne le moteur instancié dans le contrôleur.
	 * 
	 * @return moteur le moteur du contrôleur.
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
	 * Incrémente le nombre de temps par mesure dans le moteur.
	 * 
	 * @since 1.0
	 */
	public void incrementer();

	/**
	 * Décrémente le nombre de temps par mesure dans le moteur.
	 * 
	 * @since 1.0
	 */
	public void decrementer();

	/**
	 * Éteint une led dans l'IHM.
	 * 
	 * @param led la led à éteindre.
	 * @since 1.0
	 */
	public void eteindreLed(int led);

	/**
	 * Méthode appelée par l'horloge pour marquer la mesure.
	 * 
	 * @since 1.0
	 */
	public void marquerMesure();

}
