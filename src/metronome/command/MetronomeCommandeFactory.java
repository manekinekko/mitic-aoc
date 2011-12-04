package metronome.command;

import metronome.IControleur;

/**
 * Cette classe est une factory de commandes.
 * 
 * @author <ul>
 *         <li>Wassim Chegham (<a
 *         href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li>
 *         <li>Gurval Le Bouter (<a
 *         href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li>
 *         </ul>
 * @version 1.0
 * 
 */
public class MetronomeCommandeFactory {

	/**
	 * Créer une commande CommandeTic.
	 * 
	 * @param controleur le contrôleur de l'application.
	 * @return une CommandeTic.
	 * @since 1.0
	 */
	public static ICommand creerCommandeTic(IControleur controleur) {
		return new CommandeTic(controleur);
	}

	/**
	 * Créer une commande CommandeMarqueurTemps.
	 * 
	 * @param controleur le contrôleur de l'application.
	 * @return une CommandeMarqueurTemps.
	 * @since 1.0
	 */
	public static ICommand creerCommandeMarqueurTemps(IControleur controleur) {
		return new CommandeMarqueurTemps(controleur);
	}

	/**
	 * Créer une commande CommandeMarqueurMesure.
	 * 
	 * @param controleur le contrôleur de l'application.
	 * @return une CommandeMarqueurMesure.
	 * @since 1.0
	 */
	public static ICommand creerCommandeMarqueurMesure(IControleur controleur) {
		return new CommandeMarqueurMesure(controleur);
	}

	/**
	 * Créer une commande CommandeSlider.
	 * 
	 * @param controleur le contrôleur de l'application.
	 * @return une CommandeSlider.
	 * @since 1.0
	 */
	public static ICommand creerCommandeSlider(IControleur controleur) {
		return new CommandeSlider(controleur);
	}

	/**
	 * Créer une commande CommandeEteindreLed.
	 * 
	 * @param controleur le contrôleur de l'application.
	 * @return une CommandeEteindreLed.
	 * @since 1.0
	 */
	public static ICommand creerCommandeEteindreLed(IControleur controleur, int led) {
		return new CommandeEteindreLed(controleur, led);
	}

	/**
	 * Créer une commande CommandeLireClavier.
	 * 
	 * @param controleur le contrôleur de l'application.
	 * @return une CommandeLireClavier.
	 * @since 1.0
	 */
	public static ICommand creerCommandeLireClavier(IControleur controleur) {
		return new CommandeLireClavier(controleur);
	}

}
