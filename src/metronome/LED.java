package metronome;

import javax.swing.JRadioButton;

/**
 * La classe LED permet d'afficher une LED (ici représentée par un RadioButton)
 * et de l'allumer et de l'éteindre.
 * 
 * @author <ul><li>Wassim Chegham (<a href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li><li>Gurval Le Bouter (<a href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li></ul>
 * @see ILED
 * @version 1.0
 */
public class LED extends JRadioButton implements ILED {

	private static final long serialVersionUID = 1L;
	private boolean estAllumee_;

	/**
	 * Constructeur de la LED.
	 * @since 1.0
	 */
	public LED() {
		setSelected(false);
		estAllumee_ = false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean estAllumee(){
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
