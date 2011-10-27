package metronome.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.Timer;

import metronome.command.ICommand;

public class TimerSwing implements IHorloge {
	
	private Timer timerPeriodique_;
	private Timer timerDelai_;
	
	public TimerSwing(){
		//Timer.setLogTimers(true);
		timerPeriodique_ = new Timer(0, null);
		timerDelai_ = new Timer(0, null);
	}

	public void activerPeriodiquement(final ICommand cmd, final float periodeEnSeconde) {
		
		timerPeriodique_.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cmd.execute();
			}
		});
		timerPeriodique_.setDelay((int)periodeEnSeconde);
		timerPeriodique_.setRepeats(true);
		timerPeriodique_.setActionCommand("dd");
		timerPeriodique_.restart();
	}

	public void activerApresDelai(final ICommand cmd, final float delaiEnSecondes) {
		timerDelai_.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cmd.execute();
			}
		});
		timerDelai_.setDelay((int)delaiEnSecondes);
		timerDelai_.setRepeats(true);
		timerDelai_.setActionCommand("dd");
		timerDelai_.restart();
	}

	public void desactiver(ICommand cmd) {
		timerPeriodique_.stop();
		
		for(ActionListener listener: timerPeriodique_.getActionListeners()){
			timerPeriodique_.removeActionListener(listener);
		}
		
	}
	
}

