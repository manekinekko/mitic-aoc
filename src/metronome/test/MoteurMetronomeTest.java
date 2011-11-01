package metronome.test;

import static org.junit.Assert.*;
import metronome.Controleur;
import metronome.core.HorlogeWrapper;
import metronome.core.MoteurMetronome;
import org.junit.Before;
import org.junit.Test;

public class MoteurMetronomeTest {

	MoteurMetronome metronome;
	
    @Before
    public void setUp() throws Exception {
    	metronome = new MoteurMetronome(new Controleur(), new HorlogeWrapper());
    }
	
	@Test
	public void testMoteurMetronome() {
		assertFalse(metronome.getEtatMarche());
	}

	@Test
	public void testTempo() {
		//test des valeurs min
		metronome.setTempo(0);
		assertEquals(MoteurMetronome.MIN_TEMPO, metronome.getTempo());
		
		metronome.setTempo(-1000);
		assertEquals(MoteurMetronome.MIN_TEMPO, metronome.getTempo());
		
		//test des valeur max
		metronome.setTempo(1000);
		assertEquals(MoteurMetronome.MAX_TEMPO, metronome.getTempo());
		
		metronome.setTempo(2000);
		assertEquals(MoteurMetronome.MAX_TEMPO, metronome.getTempo());
		
		//test de la valeur moyenne
		int tempo = (int) ((MoteurMetronome.MAX_TEMPO + MoteurMetronome.MIN_TEMPO) / 2);
		metronome.setTempo(500);
		assertEquals(tempo, metronome.getTempo());
	}

	@Test
	public void testEtatMarche() {
		metronome.setEtatMarche(false);
		assertFalse(metronome.getEtatMarche());
		
		metronome.setEtatMarche(true);
		assertTrue(metronome.getEtatMarche());
	}

	@Test
	public void testTempsParMesure() {
		metronome.setTempsParMesure(MoteurMetronome.MIN_TEMPS_PAR_MESURE-1);
		assertEquals(MoteurMetronome.MIN_TEMPS_PAR_MESURE, metronome.getTempsParMesure());
		
		metronome.setTempsParMesure(MoteurMetronome.MAX_TEMPS_PAR_MESURE+1);
		assertEquals(MoteurMetronome.MAX_TEMPS_PAR_MESURE, metronome.getTempsParMesure());
		
		int temps = (int) (MoteurMetronome.MAX_TEMPS_PAR_MESURE + MoteurMetronome.MIN_TEMPS_PAR_MESURE) / 2;
		metronome.setTempsParMesure(temps);
		assertEquals(temps, metronome.getTempsParMesure());
	}

	@Test
	public void testTraiterCommandeTic() {
	}

	@Test
	public void testAttach() {
	}

	@Test
	public void testDetach() {
	}

}
