package metronome.command;

import metronome.IControleur;
import metronome.adapter.IClavier;
import metronome.adapter.Materiel;

/**
 * Commande exécutée pour appeler les différentes méthodes de controleur en
 * fonction de l'état des touches du clavier.
 * 
 * @author <ul>
 *         <li>Wassim Chegham (<a
 *         href="mailto:contact@cheghamwassim.com">contact
 *         @cheghamwassim.com</a>)</li>
 *         <li>Gurval Le Bouter (<a
 *         href="mailto:gurval.lebouter@gmail.com">gurval
 *         .lebouter@gmail.com</a>)</li>
 *         </ul>
 * @version 2.0
 * @see ICommand
 */
public class CommandeLireClavier implements ICommand {

	private IClavier clavier_;
	private IControleur controleur_;

	/**
	 * Constructeur de la commande.
	 * @param controleur le contrôleur de l'application.
	 * @since 2.0
	 */
	public CommandeLireClavier(IControleur controleur) {
		controleur_ = controleur;
		clavier_ = Materiel.getClavier();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() {

		if (clavier_.touchePresse(1)) {
			controleur_.demarrer();
		}
		if (clavier_.touchePresse(2)) {
			controleur_.stopper();
		}
		if (clavier_.touchePresse(3)) {
			controleur_.incrementer();
		}
		if (clavier_.touchePresse(4)) {
			controleur_.decrementer();
		}

	}

}
