package metronome.core;

import metronome.command.ICommand;

/**
 * Cette classe sert d'adaptateur pour l'horloge utilisée dans {@link MoteurMetronome}. 
 * 
 * @author <ul><li>Wassim Chegham (<a href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li><li>Gurval Le Bouter (<a href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li></ul>
 * @version 1.0
 * @see IHorloge
 * @role Horloge Adapter
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
