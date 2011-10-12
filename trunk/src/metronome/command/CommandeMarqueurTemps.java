package metronome.command;

import metronome.IControleur;

public class CommandeMarqueurTemps implements ICommand {

	private IControleur controleur_;

	public CommandeMarqueurTemps(IControleur controleur){
		controleur_ = controleur;
	}
	
	@Override
	public void execute() {
		controleur_.marquerTemps();
	}

}
