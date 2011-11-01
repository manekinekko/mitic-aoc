package metronome.test;

import metronome.IControleur;
import metronome.IIHM;
import metronome.core.IMoteurMetronome;

public class ControleurBidon implements IControleur{

	@Override
	public void demarrer() {
	}

	@Override
	public void stopper() {
	}

	@Override
	public void marquerTemps() {
	}

	@Override
	public void setSlider(int valeur) {
	}

	@Override
	public void updateEtatMoteur() {
	}

	@Override
	public void updateCommandeInc() {
	}

	@Override
	public void updateCommandeDec() {
	}

	@Override
	public void updateCommandeMarqueurTemps() {
	}

	@Override
	public void updateCommandeSlider() {
	}

	@Override
	public IIHM getIHM() {
		return null;
	}

	@Override
	public IMoteurMetronome getMoteur() {
		return null;
	}

	@Override
	public void updateSlider() {
	}

	@Override
	public void incrementer() {
	}

	@Override
	public void decrementer() {
	}

	@Override
	public void eteindreLed(int led_) {
	}

	@Override
	public void marquerMesure() {
	}

}
