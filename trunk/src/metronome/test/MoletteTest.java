package metronome.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import metronome.Constantes;
import metronome.adapter.Molette;

import org.junit.Before;
import org.junit.Test;

public class MoletteTest {

	private Molette molette_;

	@Before
	public void setUp() throws Exception {
		molette_ = new Molette();
	}
	
	@Test
	public void testMolette() {
		assertTrue(molette_ != null);
	}
	
	@Test
	public void testSetCurrentPosition() {
		molette_.setCurrentPosition(0);
		assertTrue(molette_.position() == 0.0);
		
		molette_.setCurrentPosition(25.0F);
		assertTrue(molette_.position() == (25.0F/Constantes.MAX_TEMPO));
		
		molette_.setCurrentPosition(Constantes.MAX_TEMPO);
		assertTrue(molette_.position() == 1.0);
	}

	@Test
	public void testPosition() {
		molette_.setCurrentPosition(0);
		assertTrue(molette_.position() == 0.0);
		
		molette_.setCurrentPosition(25.0F);
		assertTrue(molette_.position() == (25.0F/Constantes.MAX_TEMPO));
		
		molette_.setCurrentPosition(Constantes.MAX_TEMPO);
		assertTrue(molette_.position() == 1.0);
	}

}
