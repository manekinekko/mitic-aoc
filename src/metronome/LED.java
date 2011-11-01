package metronome;

import java.awt.Color;
import java.util.Date;
import javax.swing.JRadioButton;

public class LED extends JRadioButton implements ILED {

	private static final long serialVersionUID = 1L;
	private long time;


	public LED(Color on, Color off) {
		setSelected(false);
	}

	@Override
	public synchronized void allumer() {
		time = new Date().getTime();
		setSelected(true);
	}

	@Override
	public synchronized void eteindre() {
		time = new Date().getTime() - time;
		System.out.println("Ecart entre allumer et eteindre:"+time);
		setSelected(false);
	}
}
