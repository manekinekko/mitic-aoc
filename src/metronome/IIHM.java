package metronome;

import javax.swing.JButton;
import javax.swing.JSlider;

/**
 * Cette interface définit les méthodes à implémenter par la classe IHM.
 * 
 * @author Wassim Chegham <contact@cheghamwassim.com>
 * @version 1.0
 *
 */
public interface IIHM {
	
	/**
	 * Afficher le tempo dans le cadre prévu.
	 * @param tempo La valeur du tempo à afficher.
	 * @since 1.0
	 */
	public void afficherTempo(int tempo);
	/**
	 * Permet d'activer ou désactiver un bouton.
	 * @param bouton Le bouton à activer ou désactiver.
	 * @param etat True pour activer le bouton, False pour le desactiver.
	 * @since 1.0
	 */
	public void setEtatBouton(JButton bouton, boolean etat);
	/**
	 * Permet d'activer ou désactiver un slider.
	 * @param slider Le slider à activer ou désactiver.
	 * @param etat True pour activer le slider, False pour le désactiver.
	 * @since 1.0
	 */
	public void setEtatSlider(JSlider slider, boolean etat);
	/**
	 * Permet d'allumer une LED.
	 * @param led Le numéro de la LED à allumer.
	 * @since 1.0
	 */
	public void allumerLED(int led);
	/**
	 * Permet d'éteindre une LED.
	 * @param led Le numéro de la LED à éteindre.
	 * @since 1.0
	 */
	public void eteindreLED(int led);
	/**
	 * Permet d'émettre un son à chaque marquage de temps.
	 */
	public void emettreClick();
	/**
	 * Récupère le bouton "Démarrer".
	 * @return Le bouton "Démarrer".
	 */
	public JButton getBoutonDemarrer();
	/**
	 * Récupère le bouton "Stop".
	 * @return Le bouton "Stop".
	 */
	public JButton getBoutonStop();
	/**
	 * Récupère le bouton "Inc".
	 * @return Le bouton "Inc".
	 */
	public JButton getBoutonInc();
	/**
	 * Récupère le bouton "Dec".
	 * @return Le bouton "Dec".
	 */
	public JButton getBoutonDec();
	/**
	 * Récupère le slider.
	 * @return Le slider.
	 */
	public JSlider getSlider();
	/**
	 * Récupère la valeur courante du slider.
	 * @return La valeur courante du slider.
	 */
	public int getValeurSlider();
	
}