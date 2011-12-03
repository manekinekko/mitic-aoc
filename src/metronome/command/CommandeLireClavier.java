package metronome.command;

import metronome.IControleur;
import metronome.adapter.IClavier;
import metronome.adapter.Materiel;

public class CommandeLireClavier implements ICommand {

	private IClavier clavier_;
	private IControleur controleur_;
	
	public CommandeLireClavier(IControleur controleur) {
		controleur_ = controleur;
		clavier_ = Materiel.getClavier();
	}

	@Override
	public void execute() {

		if (clavier_.touchePresse(3)){
			controleur_.incrementer();
		}
		
	}

}
