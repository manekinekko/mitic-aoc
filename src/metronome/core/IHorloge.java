package metronome.core;

import metronome.command.ICommand;

/**
 * Cette interface définit les méthodes à implémenter par la classe IHM.
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
public interface IHorloge {

	/**
	 * Appel périodique de l'opération execute de cmd, toutes les
	 * périodeEnSecondes secondes, avec une précision d'une milliseconde.
	 * 
	 * @param cmd la commande a exécuter périodiquement.
	 * @param periodeEnSeconde la période d'éxécution de la commande.
	 * @since 1.0
	 */
	public void activerPeriodiquement(ICommand cmd, float periodeEnSeconde);

	/**
	 * Appel de l'opération execute() de cmd, après un delai de delaiEnSecondes
	 * secondes, avec une précision d'une milliseconde.
	 * 
	 * @param cmd la comande à exécuter après un delai.
	 * @param delaiEnSecondes le delai d'exécution de la commande.
	 * @since 1.0
	 */
	public void activerApresDelai(ICommand cmd, float delaiEnSecondes);

	/**
	 * Désactive la commande activé précédemment par activerPeriodiquement.
	 * 
	 * @param cmd la commande à désactiver.
	 * @since 1.0
	 */
	public void desactiver(ICommand cmd);
}
