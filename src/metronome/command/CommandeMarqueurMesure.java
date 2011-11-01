package metronome.command;

import metronome.IControleur;

public class CommandeMarqueurMesure implements ICommand {

	private IControleur controleur_;

	public CommandeMarqueurMesure(IControleur controleur){
		controleur_ = controleur;
	}
	
	@Override
	public void execute() {
		controleur_.marquerMesure();
	}

}
