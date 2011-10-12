package metronome.command;

import metronome.IControleur;


public class CommandeInc implements ICommand {

	private IControleur controleur_;

	public CommandeInc(IControleur controleur) {
		controleur_ = controleur;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
