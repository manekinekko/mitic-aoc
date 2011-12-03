package metronome.command;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class CommandeMouseListener implements MouseListener {

	private ICommand commande_;
	
	public CommandeMouseListener(ICommand commande){
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
