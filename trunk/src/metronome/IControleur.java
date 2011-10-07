package metronome;
import java.util.Observer;


public interface IControleur extends Observer{

	public void demarrer();
	public void marquerTemps();
	public void updateEtatMarche();
	
}
