package metronome.command;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Exécute une commande au changement de valeur d'un JSlider.
 * 
 * @author Wassim Chegham <contact@cheghamwassim.com>
 * @author Gurval Le Bouter <gurval.lebouter@gmail.com>
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
		JSlider source = (JSlider)event.getSource();
        if (!source.getValueIsAdjusting()) {
            commande_.execute();
        }
	}

}