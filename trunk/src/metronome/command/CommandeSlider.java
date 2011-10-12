package metronome.command;

import metronome.IControleur;

public class CommandeSlider implements ICommandSlider {

	private IControleur controleur_;
	private int valeur_;
	
	public CommandeSlider(IControleur controleur) {
		controleur_ = controleur;
	}
	
	public void setValeur(int valeur){
		valeur_ = valeur;
	}
	
	@Override
	public void execute() {
		controleur_.setSlider(valeur_);
	}

}
