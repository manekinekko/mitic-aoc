package metronome.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import metronome.command.ICommand;

public class Horloge implements IHorloge {

	private Timer timer_1, timer_2;

	public Horloge() {
		timer_1 = null;
		timer_2 = null;
	}

	public void activerApresDelai(ICommand cmd, float delaiEnSecondes) {
		TimerAction ta = new TimerAction();
		ta.setCommand(cmd);
		int delai = (int) (delaiEnSecondes * 1000);
		timer_1 = new Timer(delai, ta);
		timer_1.setRepeats(false);
		timer_1.start();
	}

	public void activerPeriodiquement(ICommand cmd, float periodeEnSecondes) {
		TimerAction ta = new TimerAction();
		ta.setCommand(cmd);
		if (timer_2 != null)
			timer_2.stop();
		int delai = (int) (periodeEnSecondes * 1000);
		timer_2 = new Timer(delai, ta);
		timer_2.start();
	}

	public void desactiver() {
		timer_1.stop();
		timer_2.stop();
	}

	class TimerAction implements ActionListener {
		ICommand c;

		public void setCommand(ICommand c) {
			this.c = c;
		}

		public void actionPerformed(ActionEvent e) {
			c.execute();
		}

	}

	@Override
	public void desactiver(ICommand cmd) {
	}

}