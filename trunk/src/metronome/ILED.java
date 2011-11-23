package metronome;

/**
 * Cette interface définit les opérations à implémenter dans la classe LED.
 * 
 * @author Wassim Chegham <contact@cheghamwassim.com>
 * @author Gurval Le Bouter <gurval.lebouter@gmail.com>
 * @version 1.0
 */
public interface ILED {
	
	/**
	 * Permet d'allumer la LED.
	 * @since 1.0
	 */
	public void allumer();
	/**
	 * Permet d'éteindre la LED.
	 * @since 1.0
	 */
	public void eteindre();
	
	/**
	 * R�cup�re l'etat lumineux de la LED
	 * @return True si la LED est allumee, False sinon.
	 */
	public boolean estAllumee();
}
