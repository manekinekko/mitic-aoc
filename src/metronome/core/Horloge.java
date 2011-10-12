package metronome.core;

import metronome.command.ICommand;


public class Horloge implements IHorloge {

	private Thread horloge_;
	
	public Horloge() {}
	
	@Override
	public void activerPeriodiquement(ICommand cmd, float periodeEnSeconde) {
		horloge_ = new HorlogePeriodique(cmd, periodeEnSeconde);
		horloge_.start();
	}

	@Override
	public void activerApresDelai(ICommand cmd, float delaiEnSecondes) {
		// TODO Auto-generated method stub

	}

	@Override
	public void desactiver(ICommand cmd) {
		horloge_.interrupt();
	}
	
}
