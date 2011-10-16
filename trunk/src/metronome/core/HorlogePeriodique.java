package metronome.core;

import metronome.command.ICommand;

public class HorlogePeriodique extends Thread {

	private float periodeEnSecondes_;
	private ICommand command_;
	
	public HorlogePeriodique(ICommand command, float periodeEnSecondes) {
		command_ = command;
		periodeEnSecondes_ = periodeEnSecondes;
	}

	public HorlogePeriodique() {
		
	}

	public void setPeriodeEnSecondes(float periodeEnSecondes_) {
		this.periodeEnSecondes_ = periodeEnSecondes_;
	}

	public void setCommand(ICommand command_) {
		this.command_ = command_;
	}

	@Override
	public void run() {
		while( !isInterrupted() ){
			try {
				command_.execute();
				sleep((long)(periodeEnSecondes_*1000));
				System.out.println("Tic");
			} catch (InterruptedException e) {
				interrupt();
			}
		}
		
	}
}
