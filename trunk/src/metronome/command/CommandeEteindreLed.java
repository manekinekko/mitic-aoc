package metronome.command;

import metronome.IControleur;

public class CommandeEteindreLed implements ICommand {

	private IControleur controleur_;
	private int led_;

	public CommandeEteindreLed(IControleur controleur, int led){
		controleur_ = controleur;
		led_ = led;
	}
	
	@Override
	public void execute() {
		controleur_.eteindreLed(led_);
	}

}