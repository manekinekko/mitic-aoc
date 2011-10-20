package metronome.command;

import metronome.IControleur;

public class CommandeTic implements ICommand {

	private IControleur controleur_;

	public CommandeTic(IControleur controleur) {
		controleur_ = controleur;
	}
	
	@Override
	public void execute() {
		controleur_.getMoteur().traiterCommandeTic();
	}

}
