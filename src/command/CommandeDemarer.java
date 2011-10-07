package command;

import metronome.Controleur;
import metronome.IControleur;

public class CommandeDemarer implements ICommand {

	private IControleur controleur_;

	public CommandeDemarer(){
		controleur_ = new Controleur();
	}
	
	@Override
	public void execute() {
		controleur_.demarrer();
	}

}
