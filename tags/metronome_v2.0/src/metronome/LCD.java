package metronome;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Cette classe définit le composant permettant d'afficher les valeur du tempo.
 * 
 * @author <ul>
 *         <li>Wassim Chegham (<a
 *         href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li>
 *         <li>Gurval Le Bouter (<a
 *         href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li>
 *         </ul>
 * @version 1.0
 */
public class LCD extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textTempo_;
	private JTextField textMesure_;
	private JTextField[] textMesureIndicateurs_ = new JTextField[Constantes.MAX_TEMPS_PAR_MESURE];
	private short indicateurCourant_;
	
	/**
	 * Constructeur du LCD.
	 * 
	 * @since 1.0
	 */
	public LCD() {
		super();
		indicateurCourant_ = 0;
		setBackground(Color.black);
		setLayout(new GridLayout(2, 1));

		// in case we dont find the digital font
		// we init the digitalFont var to a known font
		Font digitalFont = new Font(Font.SANS_SERIF, Font.BOLD, 40); 
		
		try {
			digitalFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/metronome/assets/DIGIT.TTF"));
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(digitalFont);
			
		} catch (FontFormatException e) {
			System.out.println("Font format is not valid");
		} catch (IOException e) {
			System.out.println("Font file was not found!");
		}
		
		textTempo_ = new JTextField();
		textTempo_.setPreferredSize(new Dimension(100, 40));
		textTempo_.setEditable(false);
		textTempo_.setFont(digitalFont.deriveFont(Font.PLAIN, 60F));
		textTempo_.setBackground(Color.orange);
		textTempo_.setForeground(Color.black);
		textTempo_.setBorder(null);
		textTempo_.setHorizontalAlignment(JTextField.RIGHT);
		
		textMesure_ = new JTextField();
		textMesure_.setPreferredSize(new Dimension(100, 40));
		textMesure_.setEditable(false);
		textMesure_.setFont(digitalFont.deriveFont(Font.PLAIN, 50F));
		textMesure_.setBackground(Color.orange);
		textMesure_.setForeground(Color.black);
		textMesure_.setBorder(null);
		textMesure_.setHorizontalAlignment(JTextField.CENTER);

		JPanel textMesureIndicateursBox = new JPanel();
		textMesureIndicateursBox.setLayout(new GridLayout(Constantes.MAX_TEMPS_PAR_MESURE, 1));
		for(short i=0; i<Constantes.MAX_TEMPS_PAR_MESURE; i++) {
			textMesureIndicateurs_[i] = new JTextField("-");
			textMesureIndicateurs_[i].setPreferredSize(new Dimension(20,8));
			textMesureIndicateurs_[i].setEditable(false);
			textMesureIndicateurs_[i].setFont(digitalFont.deriveFont(Font.BOLD, 40F));
			textMesureIndicateurs_[i].setBackground(Color.orange);
			textMesureIndicateurs_[i].setForeground( i==0?Color.black:Color.orange ); // initialement caché
			textMesureIndicateurs_[i].setBorder(null);
			textMesureIndicateurs_[i].setHorizontalAlignment(JTextField.CENTER);
			textMesureIndicateursBox.add(textMesureIndicateurs_[i]);
		}
		
		Box hBox1 = Box.createHorizontalBox();
		hBox1.add(textTempo_);
		hBox1.add(textMesure_);
		hBox1.add(textMesureIndicateursBox);
		add(hBox1);
		
		//--
		
		Box hBox2 = Box.createHorizontalBox();
		JTextField tempoLabel = new JTextField("Tempo");
		tempoLabel.setEditable(false);
		tempoLabel.setFont(digitalFont.deriveFont(Font.PLAIN, 20F));
		tempoLabel.setBackground(Color.orange);
		tempoLabel.setForeground(Color.black);
		tempoLabel.setBorder(null);
		tempoLabel.setHorizontalAlignment(JTextField.CENTER);
		
		JTextField mesureLabel = new JTextField("Measure");
		mesureLabel.setEditable(false);
		mesureLabel.setFont(digitalFont.deriveFont(Font.PLAIN, 20F));
		mesureLabel.setBackground(Color.orange);
		mesureLabel.setForeground(Color.black);
		mesureLabel.setBorder(null);
		mesureLabel.setHorizontalAlignment(JTextField.CENTER);
		
		hBox2.add(tempoLabel);
		hBox2.add(mesureLabel);
		add(hBox2);
		
	}
	
	public void setTextTempo(String text) {
		textTempo_.setText(text);
	}
	
	public String getTextTempo() {
		return textTempo_.getText();
	}

	public void setTextMesure(String text) {
		textMesure_.setText(text);
	}
	
	public String getTextMesure() {
		return textMesure_.getText();
	}
	
	public void showNextMesureIndicator(int maxMesure) {
		for(short i=0; i<Constantes.MAX_TEMPS_PAR_MESURE; i++) {
			textMesureIndicateurs_[i].setForeground( i==indicateurCourant_?Color.black:Color.orange );
		}
		indicateurCourant_ = (short) (indicateurCourant_+1 >= maxMesure ? 0 : indicateurCourant_+1);
	}
	
}