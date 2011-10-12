package metronome.core;

import metronome.command.ICommand;

public class HorlogePeriodique extends Thread {

	private float periodeEnSeconde_;
	private ICommand command_;
	
	public HorlogePeriodique(ICommand command, float periodeEnSeconde) {
		command_ = command;
		periodeEnSeconde_ = periodeEnSeconde;
	}

	public HorlogePeriodique() {
		
	}

	public void setPeriodeEnSeconde(float periodeEnSeconde_) {
		this.periodeEnSeconde_ = periodeEnSeconde_;
	}

	public void setCommand(ICommand command_) {
		this.command_ = command_;
	}

	@Override
	public void run() {
		while( !isInterrupted() ){
			try {
				command_.execute();
				sleep((long)periodeEnSeconde_);
				System.out.println("Tic");
			} catch (InterruptedException e) {
				interrupt();
			}
		}
		
	}
}
