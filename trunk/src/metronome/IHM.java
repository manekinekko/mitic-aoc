package metronome;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import metronome.command.CommandeChangeListener;
import metronome.command.CommandeMouseListener;
import metronome.core.EmetteurSonore;

public class IHM extends JFrame implements IIHM {

	private static final long serialVersionUID = 1L;
	private JTextField lcd_;
	private LED led1_, led2_;
	private JButton demarrer_, stop_, inc_, dec_;
	private JSlider slider_;
	private IControleur controleur_;
	private EmetteurSonore emetteur_;

	public IHM(IControleur controleur) {
		super("Metronome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controleur_ = controleur;
		construireIHM_();
		emetteur_ = new EmetteurSonore();
	}

	private void construireIHM_() {

		Box vBox = Box.createVerticalBox();
		Box hBox1 = Box.createHorizontalBox();
		Box hBox2 = Box.createHorizontalBox();

		slider_ = new JSlider(40, 210, 40);

		//TODO faire un update de la valeur du JSlider sur le moteur
		slider_.addChangeListener(new CommandeChangeListener(
				MetronomeCommandeFactory.creerCommandeSlider(controleur_)));
		//tempo_.setEnabled(false);

		lcd_ = new JTextField("0");
		lcd_.setPreferredSize(new Dimension(120, 50));
		lcd_.setEditable(false);
		lcd_.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		lcd_.setHorizontalAlignment(JTextField.CENTER);
		lcd_.setBackground(Color.black);
		lcd_.setForeground(Color.white);

		led1_ = new LED(Color.RED);
		led2_ = new LED(Color.RED);

		JLabel labelLed1 = new JLabel("Led 1");
		labelLed1.setAlignmentX(CENTER_ALIGNMENT);
		JLabel labelLed2 = new JLabel("Led 2");
		labelLed2.setAlignmentX(CENTER_ALIGNMENT);

		demarrer_ = new JButton("START");
		stop_ = new JButton("STOP");
		inc_ = new JButton("INC");
		dec_ = new JButton("DEC");

		demarrer_.addMouseListener(new CommandeMouseListener(
				MetronomeCommandeFactory.creerCommandeDemarrer(controleur_)));
		stop_.addMouseListener(new CommandeMouseListener(
				MetronomeCommandeFactory.creerCommandeStop(controleur_)));
		inc_.addMouseListener(new CommandeMouseListener(
				MetronomeCommandeFactory.creerCommandeInc(controleur_)));
		dec_.addMouseListener(new CommandeMouseListener(
				MetronomeCommandeFactory.creerCommandeDec(controleur_)));

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
		hBox2.add(inc_);
		hBox2.add(dec_);
		hBox1.add(Box.createHorizontalGlue());

		add(vBox);

		pack();
		setVisible(true);
		setMinimumSize(new Dimension(hBox2.getPreferredSize().width + 10,
				hBox1.getPreferredSize().height
						+ hBox2.getPreferredSize().height + 10));
	}

	public void afficherTempo(int valeur) {
		lcd_.setText("" + valeur);
	}

	public JButton getBoutonDemarrer() {
		return demarrer_;
	}

	public JButton getBoutonStop() {
		return stop_;
	}

	public JButton getBoutonInc() {
		return inc_;
	}

	public JButton getBoutonDec() {
		return dec_;
	}

	public JSlider getSlider() {
		return slider_;
	}

	public void setEtatBouton(JButton bouton, boolean etat) {
		bouton.setEnabled(etat);
	}

	public void setEtatSlider(JSlider slider, boolean etat) {
		slider.setEnabled(etat);
	}

	public int getValeurSlider(){
		return slider_.getValue();
	}
	
	@Override
	public void flasherLED() {
		led1_.flasher();
	}

	@Override
	public void emettre() {
		emetteur_.emettreClick();
	}
}