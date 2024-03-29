package metronome.adapter;

/**
 * Implémentation de l'interface IClavier. Cette classe doit être créée à partir
 * de Materiel.
 * 
 * @author <ul>
 *         <li>Wassim Chegham (<a
 *         href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li>
 *         <li>Gurval Le Bouter (<a
 *         href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li>
 *         </ul>
 * @version 2.0
 * @see Materiel#getClavier()
 */
public class Clavier implements IClavier {

	private boolean[] touchePresse_;

	/**
	 * Constructeur du clavier.
	 * 
	 * @since 2.0
	 */
	public Clavier() {
		touchePresse_ = new boolean[5];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean touchePresse(int i) {

		try {

			if (touchePresse_[i]) {
				touchePresse_[i] = false;
				return true;
			}
			return false;

		} catch (IndexOutOfBoundsException e) {
			System.out.printf("La touche d'index " + i + " n'existe pas!");
		}

		return false;
	}

	/**
	 * Appui sur la touche i (voir la méthode touchePresse ou
	 * Constantes.TOUCHE_CLAVIER_* pour les correspondances des touches).
	 * 
	 * @param i le numéro de la touche pressée
	 * @since 2.0
	 */
	public void setTouchePresse(int i) {
		touchePresse_[i] = true;
	}

}
