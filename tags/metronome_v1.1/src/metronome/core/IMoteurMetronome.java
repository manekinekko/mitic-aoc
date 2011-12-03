package metronome.core;

/**
 * Cette interface définit les méthodes à implémenter par la classe
 * MoteurMetronome.
 * 
 * @author <ul><li>Wassim Chegham (<a href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li><li>Gurval Le Bouter (<a href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li></ul>
 * @version 1.0
 */
public interface IMoteurMetronome {

	/**
	 * Récupère le tempo.
	 * 
	 * @return le tempo.
	 * @since 1.0
	 */
	public int getTempo();

	/**
	 * Définit la valeur du tempo.
	 * 
	 * @param tempo la nouvelle valeur du tempo.
	 * @since 1.0
	 */
	public void setTempo(int tempo);

	/**
	 * Retourne l'état du moteur.
	 * 
	 * @return True si le moteur est allumé, False sinon.
	 * @since 1.0
	 */
	public boolean getEtatMarche();

	/**
	 * Définit l'état du moteur.
	 * 
	 * @param etatMarche True pour allumer le moteur, False pour l'éteindre.
	 * @since 1.0
	 */
	public void setEtatMarche(boolean etatMarche);

	/**
	 * Récupère le nombre de temps par mesure.
	 * 
	 * @return le nombre de temps par mesure.
	 * @since 1.0
	 */
	public int getTempsParMesure();

	/**
	 * Définit le nombre de temps par mesure.
	 * 
	 * @param tempsParMesure le nouveau temps par mesure.
	 * @since 1.0
	 */
	public void setTempsParMesure(int tempsParMesure);

	/**
	 * Méthode executée périodiquement via la commande "CommandeTic". Elle
	 * execute les commandes "CommandeMarquerTemps" et "CommandeMarqueurMesure".
	 * 
	 * @since 1.0
	 */
	public void traiterCommandeTic();
}
