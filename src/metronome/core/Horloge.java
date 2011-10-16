package metronome.core;

import java.util.Hashtable;

import metronome.command.ICommand;


public class Horloge extends Thread implements IHorloge{

//	private Thread horloge_;
	private Hashtable<ICommand, Float> listeDeCommandes_;
	private Hashtable<ICommand, Float> tempsPourChaqueCommande_;
	
	public Horloge() {
//		horloge_ = new HorlogePeriodique();
		listeDeCommandes_ = new Hashtable<ICommand, Float>();
		tempsPourChaqueCommande_ = new Hashtable<ICommand, Float>();
	}
	
	@Override
	public void activerPeriodiquement(ICommand cmd, float periodeEnSecondes) {
		listeDeCommandes_.put(cmd, periodeEnSecondes);
		tempsPourChaqueCommande_.put(cmd, Float.MAX_VALUE);
		
		if(!this.isAlive()){
			this.start();
		}
		
//		((HorlogePeriodique)horloge_).setCommand(cmd);
//		((HorlogePeriodique)horloge_).setPeriodeEnSecondes(periodeEnSecondes);
//		horloge_.start();
	}

	@Override
	public void activerApresDelai(ICommand cmd, float delaiEnSecondes) {
		
	}

	@Override
	public void desactiver(ICommand cmd) {
//		horloge_.interrupt();
		listeDeCommandes_.remove(cmd);
		tempsPourChaqueCommande_.remove(cmd);
	}
	
	@Override
	public void run() {
		while( !isInterrupted() ){
			try {
				for(ICommand cmd: tempsPourChaqueCommande_.keySet()){
					float temps = tempsPourChaqueCommande_.get(cmd);
					tempsPourChaqueCommande_.put(cmd, new Float(temps+0.010));
					
					if(tempsPourChaqueCommande_.get(cmd) > listeDeCommandes_.get(cmd)){
						cmd.execute();
						tempsPourChaqueCommande_.put(cmd, new Float(0));
					}
				}
				
				sleep(10);
			} catch (InterruptedException e) {
			}
		}
		
	}
	
}
