package metronome;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import metronome.command.CommandeChangeListener;
import metronome.command.CommandeMouseListener;
import metronome.command.MetronomeCommandeFactory;
import metronome.core.EmetteurSonore;

/**
 * Cette classe définit la représentation graphique du programme.
 * Elle permet d'accueillir tout les autres composants graphiques tels
 * les boutons, slider et LED.<br/> 
 * <b>En d'autres termes cette classe représente la Vue du pattern MVC.</b> 
 * 
 * @author Wassim Chegham <contact@cheghamwassim.com>
 * @author Gurval Le Bouter <gurval.lebouter@gmail.com>
 * @version 1.0
 * @see IIHM
 */
public class IHM extends JFrame implements IIHM {

	private static final long serialVersionUID = 1L;
	private JTextField lcd_;
	private LED led1_, led2_;
	private JButton demarrer_, stop_, inc_, dec_;
	private JSlider slider_;
	private IControleur controleur_;
	private EmetteurSonore emetteur_;

	/**
	 * Le constructeur de la classe IHM peremet d'initialiser la construction
	 * de l'IHM.
	 * @param controleur Le controleur associé à cette vue.
	 * @since 1.0
	 */
	public IHM(IControleur controleur) {
		super("Metronome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controleur_ = controleur;
		emetteur_ = new EmetteurSonore();
		construireIHM_();
	}

	/**
	 * Cette méthode contruit l'IHM.
	 * @since 1.0
	 */
	private void construireIHM_() {

		Box vBox = Box.createVerticalBox();
		Box hBox1 = Box.createHorizontalBox();
		Box hBox2 = Box.createHorizontalBox();

		slider_ = new JSlider(Constantes.SLIDER_MIN, Constantes.SLIDER_MAX,
				Constantes.SLIDER_DEFAULT);

		slider_.addChangeListener(new CommandeChangeListener(
				MetronomeCommandeFactory.creerCommandeSlider(controleur_)));

		lcd_ = new LCD();

		led1_ = new LED();
		led2_ = new LED();

		JLabel labelLed1 = new JLabel("Led 1");
		labelLed1.setAlignmentX(CENTER_ALIGNMENT);
		JLabel labelLed2 = new JLabel("Led 2");
		labelLed2.setAlignmentX(CENTER_ALIGNMENT);

		demarrer_ = new JButton("START");
		stop_ = new JButton("STOP");
		inc_ = new JButton("INC");
		inc_.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controleur_.incrementer();
			}

		});
		dec_ = new JButton("DEC");
		dec_.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controleur_.decrementer();
			}

		});

		demarrer_.addMouseListener(new CommandeMouseListener(
				MetronomeCommandeFactory.creerCommandeDemarrer(controleur_)));
		stop_.addMouseListener(new CommandeMouseListener(
				MetronomeCommandeFactory.creerCommandeStop(controleur_)));

		stop_.setEnabled(false);
		inc_.setEnabled(false);
		dec_.setEnabled(false);

		vBox.add(Box.createVerticalGlue());
		vBox.add(hBox1);
		vBox.add(Box.createVerticalGlue());
		vBox.add(hBox2);

		hBox1.add(Box.createHorizontalGlue());
		hBox1.add(Box.createHorizontalStrut(5));
		hBox1.add(slider_);
		hBox1.add(lcd_);

		JPanel ledPanel = new JPanel();
		ledPanel.setLayout(new GridLayout(2, 2));

		ledPanel.add(led1_);
		ledPanel.add(labelLed1);
		ledPanel.add(led2_);
		ledPanel.add(labelLed2);

		hBox1.add(ledPanel);
		hBox1.add(Box.createHorizontalGlue());
		hBox1.add(Box.createHorizontalStrut(5));

		hBox1.add(Box.createHorizontalGlue());
		hBox2.add(demarrer_);
		hBox2.add(stop_);
		hBox2.add(dec_);
		hBox2.add(inc_);
		hBox1.add(Box.createHorizontalGlue());

		add(vBox);

		pack();
		setVisible(true);
		setMinimumSize(new Dimension(hBox2.getPreferredSize().width + 10,
				hBox1.getPreferredSize().height
						+ hBox2.getPreferredSize().height + 10));
	}

	@Override
	public void afficherTempo(int valeur) {
		lcd_.setText("" + valeur);
	}

	@Override
	public JButton getBoutonDemarrer() {
		return demarrer_;
	}

	@Override
	public JButton getBoutonStop() {
		return stop_;
	}

	@Override
	public JButton getBoutonInc() {
		return inc_;
	}

	@Override
	public JButton getBoutonDec() {
		return dec_;
	}

	@Override
	public JSlider getSlider() {
		return slider_;
	}

	@Override
	public void setEtatBouton(JButton bouton, boolean etat) {
		bouton.setEnabled(etat);
	}
	
	@Override
	public void setEtatSlider(JSlider slider, boolean etat) {
		slider.setEnabled(etat);
	}

	@Override
	public int getValeurSlider() {
		return slider_.getValue();
	}

	@Override
	public void allumerLED(int led) {
		if (led == 1)
			led1_.allumer();
		else if (led == 2)
			led2_.allumer();
	}

	@Override
	public void eteindreLED(int led) {
		if (led == 1)
			led1_.eteindre();
		else if (led == 2)
			led2_.eteindre();
	}

	@Override
	public void emettreClick() {
		emetteur_.emettreClick();
	}

}