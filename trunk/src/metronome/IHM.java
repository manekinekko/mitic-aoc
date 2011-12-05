package metronome;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import metronome.adapter.Clavier;
import metronome.adapter.Materiel;
import metronome.adapter.Molette;
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
	private LCD lcd_;

	private ILED[] led_ = new ILED[ Constantes.NB_LED ];
	private JButton demarrer_, stop_, inc_, dec_;
	private JSlider slider_;
	private IControleur controleur_;
	private EmetteurSonore emetteur_;
	private Clavier clavier;
	private Molette molette_;

	/**
	 * Le constructeur de la classe IHM peremet d'initialiser la construction
	 * de l'IHM.
	 * @param controleur Le contrôleur associé à cette vue.
	 * @since 1.0
	 */
	public IHM(IControleur controleur) {
		super("Metronome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		getContentPane().setBackground(Color.white);
		
		
		controleur_ = controleur;
		emetteur_ = new EmetteurSonore();
		construireIHM_();
		
		clavier = (Clavier) Materiel.getClavier();
		molette_ = (Molette) Materiel.getMolette();
		
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
		slider_.setPaintTicks(true);
	    slider_.setMajorTickSpacing(50);
	    slider_.setMinorTickSpacing(10);
	    slider_.setBackground(Color.white);
	    slider_.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    
		slider_.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				float currentValue = (float)( (JSlider) e.getSource()).getValue();
				molette_.setCurrentPosition(currentValue);
			}
		});
		this.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				int wheelValue = e.getWheelRotation();
				
				if ( e.getModifiers() == MouseWheelEvent.SHIFT_MASK ) {
					wheelValue *= 50;
				}
				
				int newValue = slider_.getValue() + wheelValue;
				
				if ( newValue < Constantes.SLIDER_MIN ) {
					newValue = Constantes.SLIDER_MIN;
				}
				else if ( newValue > Constantes.SLIDER_MAX ){
					newValue = Constantes.SLIDER_MAX;
				}
				
				slider_.setValue(newValue);
			}
		});
		
		//-- ajout des elements graphiques
		
		lcd_ = new LCD();

		for(short i=0; i<led_.length; i++) {
			led_[i] = new LED();
		}

		demarrer_ = new JButton("START");
		demarrer_.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		stop_ = new JButton("STOP");
		stop_.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		inc_ = new JButton("INC");
		inc_.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//TODO utiliser la factory pour créer cette commande?
		inc_.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clavier.setTouchePresse(Constantes.TOUCHE_CLAVIER_INC);
			}
		});
		dec_ = new JButton("DEC");
		dec_.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//TODO utiliser la factory pour créer cette commande?
		dec_.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clavier.setTouchePresse(Constantes.TOUCHE_CLAVIER_DEC);
			}
		});

		demarrer_.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clavier.setTouchePresse(Constantes.TOUCHE_CLAVIER_START);
			}
		});
		stop_.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clavier.setTouchePresse(Constantes.TOUCHE_CLAVIER_STOP);
			}
		});

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
		hBox1.add(Box.createHorizontalGlue());
		hBox1.add(Box.createHorizontalStrut(5));
		
		JPanel ledPanel = new JPanel();
		ledPanel.setPreferredSize(new Dimension(20, 50));
		ledPanel.setLayout(new BoxLayout(ledPanel, BoxLayout.Y_AXIS));
		for(short i=0; i<led_.length; i++) {
			ledPanel.add((Component)led_[i]);
		}
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
		setResizable(false);
		setMinimumSize(new Dimension(hBox2.getPreferredSize().width + 10,
				hBox1.getPreferredSize().height
						+ hBox2.getPreferredSize().height + 10));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LCD getLCD() {
		return lcd_;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void afficherTempo(int valeur) {
		lcd_.setTextTempo("" + valeur);
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
		try {
			led_[led-1].allumer();
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("[allumerLED] La LED d'index "+led+" n'existe pas!");
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ILED getLED(int num) {
		try {
			return led_[num-1];
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("[getLED] La LED d'index "+num+" n'existe pas!");
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void eteindreLED(int led) {
		try {
			led_[led-1].eteindre();
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("[eteindreLED] La LED d'index "+led+" n'existe pas!");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void emettreClick() {
		emetteur_.emettreClick();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void afficherMesure(int mesure) {
		lcd_.setTextMesure("" + mesure);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void showNextMesureIndicator() {
		lcd_.showNextMesureIndicator( controleur_.getMoteur().getTempsParMesure() );
	}

}