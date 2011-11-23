package metronome.command;

import metronome.IControleur;

/**
 * Cette classe est une factory de commande.
 * 
 * @author Wassim Chegham <contact@cheghamwassim.com>
 * @author Gurval Le Bouter <gurval.lebouter@gmail.com>
 * @version 1.0
 * 
 */
public class MetronomeCommandeFactory {

	/**
	 * Créer une commande CommandeTic.
	 * @param controleur le contrôleur de l'application.
	 * @return une CommandeTic.
	 */
	public static ICommand creerCommandeTic(IControleur controleur) {
		return new CommandeTic(controleur);
	}

	/**
	 * Créer une commande CommandeMarqueurTemps.
	 * @param controleur le contrôleur de l'application.
	 * @return une CommandeMarqueurTemps.
	 */
	public static ICommand creerCommandeMarqueurTemps(IControleur controleur) {
		return new CommandeMarqueurTemps(controleur);
	}

	/**
	 * Créer une commande CommandeMarqueurMesure.
	 * @param controleur le contrôleur de l'application.
	 * @return une CommandeMarqueurMesure.
	 */
	public static ICommand creerCommandeMarqueurMesure(IControleur controleur) {
		return new CommandeMarqueurMesure(controleur);
	}

	/**
	 * Créer une commande CommandeDemarrer.
	 * @param controleur le contrôleur de l'application.
	 * @return une CommandeDemarrer.
	 */
	public static ICommand creerCommandeDemarrer(IControleur controleur) {
		return new CommandeDemarrer(controleur);
	}

	/**
	 * Créer une commande CommandeStop.
	 * @param controleur le contrôleur de l'application.
	 * @return une CommandeStop.
	 */
	public static ICommand creerCommandeStop(IControleur controleur) {
		return new CommandeStop(controleur);
	}

	/**
	 * Créer une commande CommandeSlider.
	 * @param controleur le contrôleur de l'application.
	 * @return une CommandeSlider.
	 */
	public static ICommand creerCommandeSlider(IControleur controleur) {
		return new CommandeSlider(controleur);
	}

	/**
	 * Créer une commande CommandeEteindreLed.
	 * @param controleur le contrôleur de l'application.
	 * @return une CommandeEteindreLed.
	 */
	public static ICommand creerCommandeEteindreLed(IControleur controleur, int led) {
		return new CommandeEteindreLed(controleur, led);
	}
}
