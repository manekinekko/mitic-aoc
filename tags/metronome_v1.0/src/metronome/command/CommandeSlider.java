package metronome.command;

import metronome.IControleur;

/**
 * Commande exécutée pour mettre à jour la valeur du slider.
 * 
 * @author Wassim Chegham <contact@cheghamwassim.com>
 * @author Gurval Le Bouter <gurval.lebouter@gmail.com>
 * @version 1.0
 * @see ICommand
 */
public class CommandeSlider implements ICommand {

	private IControleur controleur_;
	
	/**
	 * Constructeur de la commande.
	 * @param controleur le contrôleur de l'application.
	 * @param led le numéro de la led à éteindre.
	 * @since 1.0
	 */
	public CommandeSlider(IControleur controleur) {
		controleur_ = controleur;
	}
	
	@Override
	public void execute() {
		controleur_.updateSlider();
	}

}