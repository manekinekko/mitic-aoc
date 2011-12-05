package metronome.adapter;

import metronome.Controleur;
import metronome.command.CommandeLireClavier;
import metronome.command.CommandeSlider;
import metronome.core.HorlogeWrapper;
import metronome.core.IHorloge;

/**
 * Classe servant d'adaptateur (voir pattern adapter). Elle permet d'aller lire
 * les états des boutons et de la molette. En fonction de ceux-ci, elle exécute
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
		horloge_.activerPeriodiquement(new CommandeLireClavier(controleur), 0.2F);
		horloge_.activerPeriodiquement(new CommandeSlider(controleur), 0.2F);
	}

}
