package metronome.adapter;

import metronome.Controleur;
import metronome.command.MetronomeCommandeFactory;
import metronome.core.HorlogeWrapper;
import metronome.core.IHorloge;

/**
 * Classe servant d'adaptateur (voir pattern adapter). Elle permet d'aller lire
 * les états des boutons et de la molette. En fonction de ceux-ci, elle execute
 * les commandes appropriées.
 * 
 * @author <ul>
 *         <li>Wassim Chegham (<a
 *         href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li>
 *         <li>Gurval Le Bouter (<a
 *         href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li>
 *         </ul>
 * @version 2.0
 */
public class Adapter {

	private IHorloge horloge_;

	/**
	 * Constructeur de l'adaptateur.
	 * 
	 * @param controleur
	 * @since 2.0
	 */
	public Adapter(Controleur controleur) {
		horloge_ = new HorlogeWrapper();
		horloge_.activerPeriodiquement(MetronomeCommandeFactory.creerCommandeLireClavier(controleur), 0.2F);
		horloge_.activerPeriodiquement(MetronomeCommandeFactory.creerCommandeSlider(controleur), 0.8F);
	}

}
