package metronome.core;

import metronome.command.ICommand;

/**
 * Cette classe est une façade sur la classe TimerSwing. Elle permet de
 * convertir les valeurs passées en paramètre en un format plus approprié à
 * java. Elle apelle ensuite la méthode équivalent de TimerSwing.
 * 
 * @author Wassim Chegham <contact@cheghamwassim.com>
 * @author Gurval Le Bouter <gurval.lebouter@gmail.com>
 * @version 1.0
 * @see IHorloge
 */
public class HorlogeWrapper implements IHorloge {

	private IHorloge horloge_;

	/**
	 * Constructeur de HorlogeWrapper. Initialise le TimerSwing.
	 * @since 1.0
	 */
	public HorlogeWrapper() {
		horloge_ = new TimerSwing();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void activerPeriodiquement(ICommand cmd, float periodeEnSeconde) {
		if (periodeEnSeconde > 0) {

			// covertir en millisecondes
			periodeEnSeconde = periodeEnSeconde * 1000;
			horloge_.activerPeriodiquement(cmd, periodeEnSeconde);

		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void activerApresDelai(ICommand cmd, float delaiEnSecondes) {
		delaiEnSecondes = delaiEnSecondes * 1000;
		horloge_.activerApresDelai(cmd, delaiEnSecondes);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void desactiver(ICommand cmd) {
		horloge_.desactiver(cmd);
	}

}
