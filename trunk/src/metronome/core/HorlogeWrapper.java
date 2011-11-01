package metronome.core;

import metronome.command.ICommand;

public class HorlogeWrapper implements IHorloge {

	private IHorloge horloge_;

	public HorlogeWrapper() {
		horloge_ = new TimerSwing();
	}
	
	@Override
	public void activerPeriodiquement(ICommand cmd, float periodeEnSeconde) {
		if ( periodeEnSeconde > 0 ){
			
			// covertir en millisecondes
			periodeEnSeconde = periodeEnSeconde * 1000;
			horloge_.activerPeriodiquement(cmd, periodeEnSeconde);
		
		}
	}

	@Override
	public void activerApresDelai(ICommand cmd, float delaiEnSecondes) {
		delaiEnSecondes = delaiEnSecondes * 1000;
		horloge_.activerApresDelai(cmd, delaiEnSecondes);
	}

	@Override
	public void desactiver(ICommand cmd) {
		horloge_.desactiver(cmd);
	}
	
}
