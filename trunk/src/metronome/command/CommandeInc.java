package metronome.command;

import metronome.IControleur;


public class CommandeInc implements ICommand {

	private IControleur controleur_;

	public CommandeInc(IControleur controleur) {
		controleur_ = controleur;
	}

	@Override
	public void execute() {
		controleur_.updateCommandeInc();
	}

}
