package metronome.adapter;

import metronome.Controleur;
import metronome.command.CommandeLireClavier;
import metronome.core.HorlogeWrapper;
import metronome.core.IHorloge;

public class Adapter{

	private IHorloge horloge_;
	
	public Adapter(Controleur controleur) {
		horloge_ = new HorlogeWrapper();
		horloge_.activerPeriodiquement(new CommandeLireClavier(controleur), 0.2F);
	}
	
}
