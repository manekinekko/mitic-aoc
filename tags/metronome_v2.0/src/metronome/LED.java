package metronome;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
/**
 * 
 * Cette classe permet d'afficher une LED (ici représentée par un Graphics)
 * et de l'allumer et de l'éteindre.
 * 
 * @author <ul>
 *         <li>Wassim Chegham (<a
 *         href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li>
 *         <li>Gurval Le Bouter (<a
 *         href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li>
 *         </ul>
 * @see ILED
 * @version 1.0
 */
public class LED extends JPanel implements ILED {

	private static final long serialVersionUID = 1L;
	private Color bg_;
	private boolean estAllume_;

	public LED() {
		super();
		estAllume_ = false;
		setBounds(0, 0, 200, 100);
		setBackground(Color.white);
		bg_ = Color.white;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int radius = 10;
		g.setColor(bg_);
		g.fillOval(0, 0, radius * 2, radius * 2);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void allumer() {
		estAllume_ = true;
		bg_ = Color.red;
		repaint();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void eteindre() {
		estAllume_ = false;
		bg_ = Color.white;
		repaint();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean estAllumee() {
		return estAllume_;
	}
}
