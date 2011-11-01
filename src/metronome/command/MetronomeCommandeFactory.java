package metronome.command;

import metronome.IControleur;

public class MetronomeCommandeFactory {

	public static ICommand creerCommandeTic(IControleur controleur) {
		return new CommandeTic(controleur);
	}

	public static ICommand creerCommandeMarqueurTemps(IControleur controleur) {
		return new CommandeMarqueurTemps(controleur);
	}

	public static ICommand creerCommandeMarqueurMesure(IControleur controleur) {
		return new CommandeMarqueurMesure(controleur);
	}

	public static ICommand creerCommandeDemarrer(IControleur controleur) {
		return new CommandeDemarrer(controleur);
	}

	public static ICommand creerCommandeStop(IControleur controleur) {
		return new CommandeStop(controleur);
	}

	public static ICommand creerCommandeInc(IControleur controleur) {
		return new CommandeInc(controleur);
	}

	public static ICommand creerCommandeDec(IControleur controleur) {
		return new CommandeDec(controleur);
	}

	public static ICommand creerCommandeSlider(IControleur controleur) {
		return new CommandeSlider(controleur);
	}

	public static ICommand creerCommandeEteindreLed(IControleur controleur,
			int led) {
		return new CommandeEteindreLed(controleur, led);
	}
}
