package metronome;

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

import metronome.adapter.Clavier;
import metronome.adapter.Materiel;
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
 * @author <ul><li>Wassim Chegham (<a href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li><li>Gurval Le Bouter (<a href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li></ul>
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
	private Clavier clavier;

	/**
	 * Le constructeur de la classe IHM peremet d'initialiser la construction
	 * de l'IHM.
	 * @param controleur Le contrôleur associé à cette vue.
	 * @since 1.0
	 */
	public IHM(IControleur controleur) {
		super("Metronome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controleur_ = controleur;
		emetteur_ = new EmetteurSonore();
		construireIHM_();
		
		clavier = (Clavier) Materiel.getClavier();
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
		
		//TODO utiliser la factory pour créer cette commande?
		inc_.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clavier.setTouchePresse(3);
			}

		});
		dec_ = new JButton("DEC");
		//TODO utiliser la factory pour créer cette commande?
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

	public JTextField getLCD() {
		return lcd_;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void afficherTempo(int valeur) {
		lcd_.setText("" + valeur);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JButton getBoutonDemarrer() {
		return demarrer_;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JButton getBoutonStop() {
		return stop_;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JButton getBoutonInc() {
		return inc_;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JButton getBoutonDec() {
		return dec_;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JSlider getSlider() {
		return slider_;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEtatBouton(JButton bouton, boolean etat) {
		bouton.setEnabled(etat);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEtatSlider(JSlider slider, boolean etat) {
		slider.setEnabled(etat);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getValeurSlider() {
		return slider_.getValue();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void allumerLED(int led) {
		if (led == 1)
			led1_.allumer();
		else if (led == 2)
			led2_.allumer();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LED getLED(int num) {
		switch(num){
			case 1: return led1_;
			case 2: return led2_;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void eteindreLED(int led) {
		if (led == 1)
			led1_.eteindre();
		else if (led == 2)
			led2_.eteindre();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void emettreClick() {
		emetteur_.emettreClick();
	}

}