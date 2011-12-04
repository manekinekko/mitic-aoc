package metronome.command;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Exécute une commande au changement de valeur d'un JSlider.
 * 
 * @author <ul><li>Wassim Chegham (<a href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li><li>Gurval Le Bouter (<a href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li></ul>
 * @version 1.0
 * @see ICommand
 */
public class CommandeChangeListener implements ChangeListener {

	private ICommand commande_;

	/**
	 * Constructeur de la commande.
	 * @param commande la commande à executer.
	 * @since 1.0
	 */
	public CommandeChangeListener(ICommand commande){
		commande_ = commande;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stateChanged(ChangeEvent event) {
		commande_.execute();
	}

}