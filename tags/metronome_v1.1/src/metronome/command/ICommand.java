package metronome.command;

/**
 * Interface pour le pattern Command. Doit être implémentée par toutes les
 * commandes de l'application.
 * 
 * @author <ul><li>Wassim Chegham (<a href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li><li>Gurval Le Bouter (<a href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li></ul>
 * @version 1.0
 */
public interface ICommand {

	/**
	 * Exécute la commande.
	 * @since 1.0
	 */
	public void execute();

}
