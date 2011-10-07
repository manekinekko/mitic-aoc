package metronome;
import command.ICommand;


public interface IHorloge {

	public void activerPeriodiquement(ICommand cmd, float periodeEnSeconde);
	public void activerApresDelai(ICommand cmd, float delaiEnSecondes);
	public void desactiver(ICommand cmd);
}
