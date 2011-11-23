package metronome.command;

import metronome.IControleur;

/**
 * Commande exécutée pour émettre un "tic".
 * 
 * @author Wassim Chegham <contact@cheghamwassim.com>
 * @author Gurval Le Bouter <gurval.lebouter@gmail.com>
 * @version 1.0
 * @see ICommand
 */
public class CommandeTic implements ICommand {

	private IControleur controleur_;

	/**
	 * Constructeur de la commande.
	 * @param controleur le contrôleur de l'application.
	 * @param led le numéro de la led à éteindre.
	 * @since 1.0
	 */
	public CommandeTic(IControleur controleur) {
		controleur_ = controleur;
	}
	
	@Override
	public void execute() {
		controleur_.getMoteur().traiterCommandeTic();
	}

}
