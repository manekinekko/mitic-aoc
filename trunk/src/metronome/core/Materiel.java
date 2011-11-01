package metronome.core;

import metronome.Clavier;
import metronome.IAfficheur;
import metronome.IClavier;

public class Materiel {
	
	private static IHorloge horloge_;
	private static IClavier clavier_;
	private static IMolette molette_;
	private static IEmetteurSonore emetteurSonore_;
	private static IAfficheur afficheur_;
	
	private Materiel(){}
	
	public static IHorloge getHorloge(){
		if ( horloge_ == null ){
			horloge_ = new Horloge();
		}
		
		return horloge_;
	}
	public static IClavier getClavier(){
		if ( clavier_ == null ){
			clavier_ = new Clavier();
		}
		
		return clavier_;
	}
	public static IMolette getMolette(){
		if ( molette_ == null ){
			molette_ = new Molette();
		}
		
		return molette_;
	}
	public static IEmetteurSonore getEmetteur(){
		if ( emetteurSonore_ == null ){
			emetteurSonore_ = new EmetteurSonore();
		}
		
		return emetteurSonore_;
	}
	public static IAfficheur getAfficheur(){
		if ( afficheur_ == null ){
			afficheur_ = new Afficheur();
		}
		
		return afficheur_;
	}
}
