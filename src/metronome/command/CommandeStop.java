package metronome.command;

import metronome.IControleur;

public class CommandeStop implements ICommand {

	private IControleur controleur_;

	public CommandeStop(IControleur controleur) {
		controleur_ =  controleur;
	}

	@Override
	public void execute() {
		controleur_.stopper();
	}

}
