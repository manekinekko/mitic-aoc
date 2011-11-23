package metronome.command;

import metronome.IControleur;

/**
 * Commande exécutée pour incrémenter le nombre de temps par mesure.
 * 
 * @author Wassim Chegham <contact@cheghamwassim.com>
 * @author Gurval Le Bouter <gurval.lebouter@gmail.com>
 * @version 1.0
 * @see ICommand
 */
public class CommandeInc implements ICommand {

	private IControleur controleur_;

	/**
	 * Constructeur de la commande.
	 * @param controleur le contrôleur de l'application.
	 * @since 1.0
	 */
	public CommandeInc(IControleur controleur) {
		controleur_ = controleur;
	}

	@Override
	public void execute() {
		controleur_.updateCommandeInc();
	}

}
