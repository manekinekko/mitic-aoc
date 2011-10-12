package metronome;

import java.awt.Color;

public class LEDRunnable extends Thread {

	private ILED led_;
	private long flashDelay_;

	public LEDRunnable(ILED led, long flashDelay) {
		led_ = led;
		flashDelay_ = flashDelay;
	}
	
	@Override
	public void run() {
		try {
			led_.setCouleur(Color.gray);
			sleep(flashDelay_);
			led_.setCouleur(Color.red);
			interrupt();
		} catch (InterruptedException e) {
			interrupt();
		}
	}

}
