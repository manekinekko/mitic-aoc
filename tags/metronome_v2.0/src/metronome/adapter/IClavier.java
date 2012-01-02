package metronome.adapter;

/**
 * Interface du clavier.
 * 
 * @author <ul>
 *         <li>Wassim Chegham (<a
 *         href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li>
 *         <li>Gurval Le Bouter (<a
 *         href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li>
 *         </ul>
 * @version 2.0
 */
public interface IClavier {
	/**
	 * Retourne true si le bouton i est enfoncé, et false sinon.
	 * 
	 * @param i 1 pour le bouton start, 2 pour stop, 3 pour inc et 4 pour dec.
	 * @return l'état du bouton
	 * @since 2.0
	 */
	public boolean touchePresse(int i);

}
