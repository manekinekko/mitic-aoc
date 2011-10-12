package metronome.command;

import metronome.IControleur;

public class CommandeDemarrer implements ICommand {

	private IControleur controleur_;

	public CommandeDemarrer(IControleur controleur){
		controleur_ = controleur;
	}
	
	@Override
	public void execute() {
		controleur_.demarrer();
	}

}
