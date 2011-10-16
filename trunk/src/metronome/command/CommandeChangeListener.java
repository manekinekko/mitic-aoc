package metronome.command;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CommandeChangeListener implements ChangeListener {

	private ICommandSlider commande_;

	public CommandeChangeListener(ICommandSlider commande){
		commande_ = commande;
	}
	
	@Override
	public void stateChanged(ChangeEvent event) {
		JSlider source = (JSlider)event.getSource();
        if (!source.getValueIsAdjusting()) {
            //int valeur = (int)source.getValue();
            //int max = (int)source.getMaximum();
            //int min = (int)source.getMinimum();
            //commande_.setValeur(min+valeur*max-min);
        	commande_.setValeur((int)source.getValue());
            commande_.execute();
        }
	}

}
