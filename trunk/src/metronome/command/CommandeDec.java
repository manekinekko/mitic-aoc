package metronome.command;

import metronome.IControleur;

public class CommandeDec implements ICommand {

	private IControleur controleur_;

	public CommandeDec(IControleur controleur) {
		controleur_ = controleur;
	}

	@Override
	public void execute() {
		controleur_.updateCommandeDec();
	}

}
