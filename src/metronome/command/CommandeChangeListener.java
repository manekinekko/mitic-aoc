package metronome.command;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CommandeChangeListener implements ChangeListener {

	private ICommand commande_;

	public CommandeChangeListener(ICommand commande){
		commande_ = commande;
	}
	
	@Override
	public void stateChanged(ChangeEvent event) {
		JSlider source = (JSlider)event.getSource();
        if (!source.getValueIsAdjusting()) {
            commande_.execute();
        }
	}

}