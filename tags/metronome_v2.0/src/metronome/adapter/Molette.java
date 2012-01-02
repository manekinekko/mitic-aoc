package metronome.adapter;

import metronome.Constantes;

/**
 * 
 * Implémentation de l'interface {@link IMolette}. Cette classe doit être créée à partir
 * de Materiel.
 * 
 * @author <ul>
 *         <li>Wassim Chegham (<a
 *         href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li>
 *         <li>Gurval Le Bouter (<a
 *         href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li>
 *         </ul>
 * @version 2.0
 * @see Materiel#getMolette()
 *
 */
public class Molette implements IMolette {

	private float currentPosition_;

	public Molette() {
		currentPosition_ = 0.0F;
	}
	
	/**
	 * Met à jout la position courante du curseur.
	 * @param currentPosition La nouvelle position du curseur.
	 */
	public void setCurrentPosition(float currentPosition) {
		this.currentPosition_ = currentPosition;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public float position() {
		return currentPosition_ / (float)Constantes.MAX_TEMPO;
	}

}
