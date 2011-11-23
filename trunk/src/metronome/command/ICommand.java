package metronome.command;

/**
 * Interface pour le pattern Command. Doit être implémentée par toutes les
 * commandes de l'application.
 * 
 * @author Wassim Chegham <contact@cheghamwassim.com>
 * @author Gurval Le Bouter <gurval.lebouter@gmail.com>
 * @version 1.0
 */
public interface ICommand {

	/**
	 * Execute la commande.
	 * @since 1.0
	 */
	public void execute();

}
