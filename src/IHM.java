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
import javax.swing.text.JTextComponent;

public class IHM extends JFrame{

	// la valeur de l'afficheur
	private String valeurAfficheur_;


	public IHM(){
		super("Metronome");
		
		valeurAfficheur_ = "0";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Box vBox = Box.createVerticalBox();
		Box hBox1 = Box.createHorizontalBox();
		Box hBox2 = Box.createHorizontalBox();
		
		JSlider tempo = new JSlider(40, 210, 40);
		JTextField afficheur = new JTextField(this.valeurAfficheur_);
		afficheur.setPreferredSize(new Dimension(120, 50));
		afficheur.setEditable(false);
		afficheur.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		afficheur.setHorizontalAlignment(JTextField.CENTER);
		afficheur.setBackground(Color.black);
		afficheur.setForeground(Color.white);
	
		
		LED led1 = new LED(Color.RED);
		LED led2 = new LED(Color.RED);
		
		JLabel labelLed1 = new JLabel("Led 1");
		labelLed1.setAlignmentX(CENTER_ALIGNMENT);
		JLabel labelLed2 = new JLabel("Led 2");
		labelLed2.setAlignmentX(CENTER_ALIGNMENT);
		
		JButton start = new JButton("START");
		JButton stop = new JButton("STOP");
		JButton inc = new JButton("INC");
		JButton dec = new JButton("DEC");
		
		vBox.add(Box.createVerticalGlue());
		vBox.add(hBox1);
		vBox.add(Box.createVerticalGlue());
		vBox.add(hBox2);
		
		hBox1.add(Box.createHorizontalGlue());
		hBox1.add(Box.createHorizontalStrut(5));
		hBox1.add(tempo);
		hBox1.add(afficheur);
		
		JPanel ledPanel = new JPanel();
		ledPanel.setLayout(new GridLayout(2,2));
		
		ledPanel.add(led1);
		ledPanel.add(labelLed1);
		ledPanel.add(led2);
		ledPanel.add(labelLed2);
		
		hBox1.add(ledPanel);
		hBox1.add(Box.createHorizontalGlue());
		hBox1.add(Box.createHorizontalStrut(5));
		
		hBox1.add(Box.createHorizontalGlue());
		hBox2.add(start);
		hBox2.add(stop);
		hBox2.add(inc);
		hBox2.add(dec);
		hBox1.add(Box.createHorizontalGlue());
		
		add(vBox);
		
		pack();
		setVisible(true);
		setMinimumSize(new Dimension(hBox2.getPreferredSize().width + 10, 
				hBox1.getPreferredSize().height+hBox2.getPreferredSize().height + 10));
		
	}
	
	public void setValeur(int valeur){
		valeurAfficheur_ = ""+valeur;
	}

	public static void main(String[] args) {
		IHM ihm = new IHM();
	}

}
