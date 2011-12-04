package metronome.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import metronome.command.ICommand;

/**
 * Implémentation de l'interface IHorloge. Utilise le timer fourni par swing
 * pour activer des commandes de manière périodique, ou avec délai. Cette classe
 * est utilisée par HorlogeWrapper, qui sert de façade.
 * 
 * 
 * @author <ul>
 *         <li>Wassim Chegham (<a
 *         href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li>
 *         <li>Gurval Le Bouter (<a
 *         href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li>
 *         </ul>
 * @version 1.0
 * @see IHorloge
 */
public class TimerSwing implements IHorloge {

	private Timer timerPeriodique_;
	private Timer timerDelai_;

	/**
	 * Constructeur de TimerSwing. Initialise les timers.
	 * 
	 * @since 1.0
	 */
	public TimerSwing() {
		// Timer.setLogTimers(true);
		timerPeriodique_ = new Timer(0, null);
		timerDelai_ = new Timer(0, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void activerPeriodiquement(final ICommand cmd, final float periodeEnMilliSeconde) {

		timerPeriodique_.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cmd.execute();
			}
		});
		timerPeriodique_.setDelay((int) periodeEnMilliSeconde);
		timerPeriodique_.setRepeats(true);
		timerPeriodique_.setActionCommand("dd");
		timerPeriodique_.restart();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void activerApresDelai(final ICommand cmd, final float delaiEnMilliSecondes) {
		timerDelai_ = new Timer(0, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cmd.execute();
			}
		});

		timerDelai_.setInitialDelay((int) delaiEnMilliSecondes);
		timerDelai_.setRepeats(false);
		timerDelai_.start();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void desactiver(ICommand cmd) {
		timerPeriodique_.stop();

		for (ActionListener listener : timerPeriodique_.getActionListeners()) {
			timerPeriodique_.removeActionListener(listener);
		}

	}

}
