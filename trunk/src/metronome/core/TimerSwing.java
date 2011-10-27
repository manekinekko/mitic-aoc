package metronome.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.Timer;

import metronome.command.ICommand;

public class TimerSwing implements IHorloge {
	
	private Timer timer_;
	private ICommand cmd_;
	private float periodeEnSeconde_;
	
	private Hashtable<ICommand, Float> listCommandes_;
	
	public TimerSwing(){
		//Timer.setLogTimers(true);
		timer_ = new Timer(0, null);
	}

	public void activerPeriodiquement(final ICommand cmd, final float periodeEnSeconde) {
		//listCommandes_.put(cmd, new Float(periodeEnSeconde));
		
		timer_.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//cmd.execute();
				System.out.println(periodeEnSeconde);
			}
		});
		timer_.setDelay((int)periodeEnSeconde);
		timer_.setRepeats(true);
		timer_.setActionCommand("dd");
		timer_.restart();
	}

	public void activerApresDelai(ICommand cmd, float delaiEnSecondes) {
		// TODO Auto-generated method stub
		
	}

	public void desactiver(ICommand cmd) {
		
		timer_.stop();
		
		for(ActionListener listener: timer_.getActionListeners()){
			timer_.removeActionListener(listener);
		}
		
	}
	
}

