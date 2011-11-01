package metronome.core;

public interface IMoteurMetronome {

	public int getTempo();
	public void setTempo(int tempo);
	public boolean getEtatMarche();
	public void setEtatMarche(boolean etatMarche);
	public int getTempsParMesure();
	public void setTempsParMesure(int tempsParMesure);
	public void traiterCommandeTic();
}
