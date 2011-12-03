package metronome;

/**
 * Cette interface définit les opérations à implémenter dans la classe LED.
 * 
 * @author <ul><li>Wassim Chegham (<a href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li><li>Gurval Le Bouter (<a href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li></ul>
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
	 * Récupère l'etat lumineux de la LED
	 * @return True si la LED est allumee, False sinon.
	 */
	public boolean estAllumee();
}
