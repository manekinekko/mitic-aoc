package metronome;

import javax.swing.JRadioButton;

/**
 * La classe LED permet d'afficher une LED (ici représentée par un RadioButton)
 * et de l'allumer et de l'éteindre.
 * 
 * @author Wassim Chegham <contact@cheghamwassim.com>
 * @author Gurval Le Bouter <gurval.lebouter@gmail.com>
 * @see ILED
 * @version 1.0
 */
public class LED extends JRadioButton implements ILED {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de la LED.
	 */
	public LED() {
		setSelected(false);
	}

	@Override
	public synchronized void allumer() {
		setSelected(true);
	}

	@Override
	public synchronized void eteindre() {
		setSelected(false);
	}
}
