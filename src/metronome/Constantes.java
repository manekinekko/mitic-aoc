package metronome;

/**
 * Cette interface définit les constantes utilisées dans le projet.
 * 
 * @author <ul>
 *         <li>Wassim Chegham (<a
 *         href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li>
 *         <li>Gurval Le Bouter (<a
 *         href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li>
 *         </ul>
 * @version 1.0
 */
public interface Constantes {
	/**
	 * La valeur maximale du slider.
	 */
	public final static int SLIDER_MAX = 1000;
	/**
	 * La valeur miniale du slider.
	 */
	public final static int SLIDER_MIN = 0;
	/**
	 * La valeur par défaut du slider.
	 */
	public final static int SLIDER_DEFAULT = 0;
	/**
	 * La valeur minimale du tempo.
	 */
	public static final int MIN_TEMPO = 40;
	/**
	 * La valeur maximale du tempo.
	 */
	public static final int MAX_TEMPO = 240;
	/**
	 * La valeur minimale du temps par mesure.
	 */
	public static final int MIN_TEMPS_PAR_MESURE = 2;
	/**
	 * La valeur maximale du temps par mesure.
	 */
	public static final int MAX_TEMPS_PAR_MESURE = 7;
	/**
	 * Le nombre de LED supportées.
	 */
	public static final short NB_LED = 2;

	public static final int LED_1 = 1;
	public static final int LED_2 = 2;

	/**
	 * Codes des touches du clavier
	 */
	public static final int TOUCHE_CLAVIER_START = 1;
	public static final int TOUCHE_CLAVIER_STOP = 2;
	public static final int TOUCHE_CLAVIER_INC = 3;
	public static final int TOUCHE_CLAVIER_DEC = 4;
	
}
