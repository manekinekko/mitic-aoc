package metronome.command;

import metronome.IControleur;

/**
 * Commande exécutée pour éteindre une led.
 * 
 * @author <ul><li>Wassim Chegham (<a href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li><li>Gurval Le Bouter (<a href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li></ul>
 * @version 1.0
 * @see ICommand
 */
public class CommandeEteindreLed implements ICommand {

	private IControleur controleur_;
	private int led_;

	/**
	 * Constructeur de la commande.
	 * @param controleur le contrôleur de l'application.
	 * @param led le numéro de la led à éteindre.
	 * @since 1.0
	 */
	public CommandeEteindreLed(IControleur controleur, int led){
		controleur_ = controleur;
		led_ = led;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() {
		controleur_.eteindreLed(led_);
	}

}