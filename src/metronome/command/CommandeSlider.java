package metronome.command;

import metronome.IControleur;

public class CommandeSlider implements ICommand {

	private IControleur controleur_;
	
	public CommandeSlider(IControleur controleur) {
		controleur_ = controleur;
	}
	
	@Override
	public void execute() {
		controleur_.updateSlider();
	}

}
