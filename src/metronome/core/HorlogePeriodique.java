package metronome.core;

import metronome.command.ICommand;

public class HorlogePeriodique extends Thread {

	private float periodeEnSeconde_;
	private ICommand command_;
	
	public HorlogePeriodique(ICommand command, float periodeEnSeconde) {
		command_ = command;
		periodeEnSeconde_ = periodeEnSeconde;
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
