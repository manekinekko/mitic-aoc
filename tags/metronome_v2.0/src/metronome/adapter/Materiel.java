package metronome.adapter;

import metronome.core.EmetteurSonore;
import metronome.core.HorlogeWrapper;
import metronome.core.IEmetteurSonore;
import metronome.core.IHorloge;

/**
 * Permet d'acceder aux interfaces de contrôle du materiel. Cette classe est une
 * factory où chaque objet créé est un singleton.
 * 
 * @author <ul>
 *         <li>Wassim Chegham (<a
 *         href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li>
 *         <li>Gurval Le Bouter (<a
 *         href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li>
 *         </ul>
 * @version 2.0
 */
public class Materiel {

	private static IHorloge horloge_;
	private static IClavier clavier_;
	private static IMolette molette_;
	private static IEmetteurSonore emetteurSonore_;

	// private static IAfficheur afficheur_;

	/**
	 * Constructeur privé car il n'y a pas besoin d'avoir d'instances de cette
	 * classe.
	 */
	private Materiel() {
	}

	/**
	 * Créer une horloge.
	 * 
	 * @return une horloge
	 * @since 2.0
	 */
	public static IHorloge getHorloge() {
		if (horloge_ == null) {
			horloge_ = new HorlogeWrapper();
		}

		return horloge_;
	}

	/**
	 * Créer un clavier.
	 * 
	 * @return un clavier
	 * @since 2.0
	 */
	public static IClavier getClavier() {
		if (clavier_ == null) {
			clavier_ = new Clavier();
		}

		return clavier_;
	}

	public static IMolette getMolette() {
		if (molette_ == null) {
			molette_ = new Molette();
		}
		return molette_;
	}

	/**
	 * Créer un émetteur sonore.
	 * 
	 * @return un émeteur sonore
	 * @since 2.0
	 */
	public static IEmetteurSonore getEmetteur() {
		if (emetteurSonore_ == null) {
			emetteurSonore_ = new EmetteurSonore();
		}

		return emetteurSonore_;
	}
	/*
	 * public static IAfficheur getAfficheur(){ if ( afficheur_ == null ){
	 * afficheur_ = new Afficheur(); }
	 * 
	 * return afficheur_; }
	 */
}
