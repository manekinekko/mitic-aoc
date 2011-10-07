package metronome;

public class Materiel {
	
	private static IHorloge horloge_;
	private static IClavier clavier_;
	private static IMolette molette_;
	private static IEmetteurSonore emetteurSonore_;
	private static IIHM ihm_;
	
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
	public static IIHM getAfficheur(){
		if ( ihm_ == null ){
			ihm_ = new IHM();
		}
		
		return ihm_;
	}
}
