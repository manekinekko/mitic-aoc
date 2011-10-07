package metronome;
import java.util.Observable;


public class Controleur implements IControleur{
	
	private IMoteurMetronome moteur_;
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	public void demarrer() {
		moteur_.setEtatMarche(true);
	}

	@Override
	public void marquerTemps() {
		
	}

	@Override
	public void updateEtatMarche() {
		// 
	}

}
