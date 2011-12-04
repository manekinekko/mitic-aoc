package metronome.command;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Classe destiné à executer une commande à l'event mouseClicked()
 * 
 * @author <ul>
 *         <li>Wassim Chegham (<a
 *         href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li>
 *         <li>Gurval Le Bouter (<a
 *         href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li>
 *         </ul>
 * @version 1.0
 * 
 */
public class CommandeMouseListener implements MouseListener {

	private ICommand commande_;

	/**
	 * Constructeur du MouseListener
	 * 
	 * @param commande
	 * @since 1.0
	 */
	public CommandeMouseListener(ICommand commande) {
		commande_ = commande;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		commande_.execute();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}
