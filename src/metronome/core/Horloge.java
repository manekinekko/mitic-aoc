package metronome.core;

import metronome.command.ICommand;


public class Horloge implements IHorloge {

	private Thread horloge_;
	
	public Horloge() {

		horloge_ = new HorlogePeriodique();
	}
	
	@Override
	public void activerPeriodiquement(ICommand cmd, float periodeEnSeconde) {
		((HorlogePeriodique)horloge_).setCommand(cmd);
		((HorlogePeriodique)horloge_).setPeriodeEnSeconde(periodeEnSeconde);
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
