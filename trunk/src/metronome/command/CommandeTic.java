package metronome.command;

import metronome.IControleur;

public class CommandeTic implements ICommand {

	private IControleur controleur_;

	public CommandeTic(IControleur controleur) {
		controleur_ = controleur;
	}
	
	@Override
	public void execute() {
		System.out.println("je suis une action Tic");
//		controleur_.getMoteur().traiterCommandeTic();
	}

}
