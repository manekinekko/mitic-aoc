package metronome;

public class MoteurMetronome implements IMoteurMetronome {

	private boolean etatMarche_;
	private IControleur controleur_;

	@Override
	public int getTempo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTempo(int tempo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getEtatMarche() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setEtatMarche(boolean etatMarche) {
		
		etatMarche_ = etatMarche;
		controleur_.updateEtatMarche();
	}

	@Override
	public int getTempsParMesure() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTempsParMesure(int tempsParMesure) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void traiterCommandeTic() {
		// TODO Auto-generated method stub

	}

	@Override
	public void attach(IControleur o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void detach(IControleur o) {
		// TODO Auto-generated method stub

	}

}
