package metronome.command;

import metronome.IControleur;

/**
 * Commande exécutée pour stopper le moteur.
 * 
 * @author Wassim Chegham <contact@cheghamwassim.com>
 * @author Gurval Le Bouter <gurval.lebouter@gmail.com>
 * @version 1.0
 * @see ICommand
 */
public class CommandeStop implements ICommand {

	private IControleur controleur_;

	/**
	 * Constructeur de la commande.
	 * @param controleur le contrôleur de l'application.
	 * @since 1.0
	 */
	public CommandeStop(IControleur controleur) {
		controleur_ =  controleur;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() {
		controleur_.stopper();
	}

}
