package metronome.test;

import static org.junit.Assert.*;

import metronome.Controleur;
import metronome.IControleur;
import metronome.IIHM;
import metronome.core.IMoteurMetronome;
import metronome.core.MoteurMetronome;

import org.junit.Before;
import org.junit.Test;

public class ControleurTest {

	private IMoteurMetronome moteur_;
	private IIHM ihm_;
	private IControleur controleur_;
	
	@Before
	public void setUp() throws Exception {
		controleur_ = new Controleur();
		ihm_ = controleur_.getIHM();
		moteur_ = controleur_.getMoteur();
	}
	
	@Test
	public void testControleur() {
	}

	@Test
	public void testDemarrer() {
		controleur_.demarrer();
		assertTrue(moteur_.getEtatMarche());
	}

	@Test
	public void testStopper() {
		controleur_.demarrer();
		controleur_.stopper();
		assertFalse(moteur_.getEtatMarche());
	}

	@Test
	public void testUpdateEtatMoteur() {
		
	}

	@Test
	public void testIncrementer() {
		int tempsParMesure = moteur_.getTempsParMesure();
		
		//si le nombre de temps par mesure est deja a sa valeur max, on decremente
		if(tempsParMesure == MoteurMetronome.MAX_TEMPS_PAR_MESURE){
			controleur_.decrementer();
			controleur_.decrementer();
			tempsParMesure = moteur_.getTempsParMesure();
		}
		
		controleur_.incrementer();
		assertEquals(tempsParMesure+1, moteur_.getTempsParMesure());
	}

	@Test
	public void testDecrementer() {
		int tempsParMesure = moteur_.getTempsParMesure();
		
		//si le nombre de temps par mesure est deja a sa valeur min, on incremente
		if(tempsParMesure == MoteurMetronome.MIN_TEMPS_PAR_MESURE){
			controleur_.incrementer();
			controleur_.incrementer();
			tempsParMesure = moteur_.getTempsParMesure();
		}
		
		controleur_.decrementer();
		assertEquals(tempsParMesure-1, moteur_.getTempsParMesure());
	}

	@Test
	/**
	 * Not yet implemented
	 */
	public void testUpdateCommandeInc() {
		assertTrue(true);		
	}

	@Test
	/**
	 * Not yet implemented
	 */
	public void testUpdateCommandeDec() {
		assertTrue(true);		
	}

	@Test
	public void testUpdateSlider() {
		
		ihm_.getSlider().setValue(100);
		int valeurSet = ihm_.getValeurSlider();
		moteur_.setTempo(valeurSet);
		int valeurGet = moteur_.getTempo();
		assertEquals(valeurGet, valeurSet);
	}

	@Test
	public void testUpdateCommandeSlider() {
		int tempo = moteur_.getTempo();
		ihm_.afficherTempo(tempo);
		assertEquals(tempo+"", ihm_.getLCD().getTextTempo());
	}

	@Test
	/**
	 * Not yet implemented
	 */
	public void testUpdateCommandeMarqueurTemps() {
		assertTrue(true);		
	}

	@Test
	public void testSetSlider() {
		int valeurSet = 100;
		moteur_.setTempo(valeurSet);
		int valeurGet = moteur_.getTempo();
		assertEquals(valeurGet, valeurSet);
	}

	@Test
	public void testGetIHM() {
		assertNotNull(controleur_.getIHM());
	}

	@Test
	public void testGetMoteur() {
		assertNotNull(controleur_.getMoteur());
	}

	@Test
	public void testMarquerTemps() {
		ihm_.allumerLED(1);
		assertTrue(ihm_.getLED(1).estAllumee());		
	}

	@Test
	public void testEteindreLed() {
		ihm_.eteindreLED(1);
		ihm_.eteindreLED(2);
		assertFalse(ihm_.getLED(1).estAllumee());
		assertFalse(ihm_.getLED(2).estAllumee());
	}

	@Test
	public void testMarquerMesure() {
		ihm_.allumerLED(2);
		assertTrue(ihm_.getLED(2).estAllumee());
	}

}
