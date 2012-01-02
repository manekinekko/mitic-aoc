package metronome;

import javax.swing.JRadioButton;

/**
 * Cette classe permet d'afficher une LED (ici représentée par un RadioButton),
 * de l'allumer et de l'éteindre. 
 * 
 * @author <ul>
 *         <li>Wassim Chegham (<a
 *         href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li>
 *         <li>Gurval Le Bouter (<a
 *         href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li>
 *         </ul>
 * @see ILED
 * @version 1.0
 * @deprecated Cette classe a été dépréciée depuis la version 2.0. Merci d'utiliser la classe {@link LED}
 */
public class LED_old extends JRadioButton implements ILED {

	private static final long serialVersionUID = 1L;
	private boolean estAllumee_;

	/**
	 * Constructeur de la LED.
	 * 
	 * @since 1.0
	 */
	public LED_old() {
		setSelected(false);
		estAllumee_ = false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean estAllumee() {
		return estAllumee_;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void allumer() {
		setSelected(true);
		estAllumee_ = true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void eteindre() {
		setSelected(false);
		estAllumee_ = false;
	}
}
