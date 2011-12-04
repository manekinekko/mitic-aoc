package metronome.command;

import metronome.IControleur;

/**
 * Commande exécutée pour démarrer le moteur.
 * 
 * @author <ul>
 *         <li>Wassim Chegham (<a
 *         href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li>
 *         <li>Gurval Le Bouter (<a
 *         href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li>
 *         </ul>
 * @version 1.0
 * @see ICommand
 */
public class CommandeDemarrer implements ICommand {

	private IControleur controleur_;

	/**
	 * Constructeur de la commande.
	 * 
	 * @param controleur le contrôleur de l'application.
	 * @since 1.0
	 */
	public CommandeDemarrer(IControleur controleur) {
		controleur_ = controleur;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() {
		controleur_.demarrer();
	}

}
