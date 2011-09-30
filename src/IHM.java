import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;


public class IHM extends JFrame{

	public IHM(){
		super("Métronome");
		
		Dimension taille = new Dimension(640, 360);
		
		setSize(taille);
		setPreferredSize(taille);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ajouterElements();
		
		pack();
		setVisible(true);
	}
	
	public void ajouterElements(){
		
		setLayout(new GridLayout(3, 1));
		

		JPanel monPanel1 = new JPanel();
		

		monPanel1.add(new Afficheur("0"));
		
		JPanel ledPanel = new JPanel();
		ledPanel.setLayout(new GridLayout(2, 2, 2, 2));
		ledPanel.add(new LED(Color.RED, "LED 1"));
		ledPanel.add(new JLabel("LED 1"));
		ledPanel.add(new LED(Color.RED, "LED 2"));
		ledPanel.add(new JLabel("LED 2"));
		monPanel1.add(ledPanel);
		
		JPanel monPanel2 = new JPanel();
		monPanel2.add(creerBouton("START"));
		monPanel2.add(creerBouton("STOP"));
		monPanel2.add(creerBouton("INC"));
		monPanel2.add(creerBouton("DEC"));
		
		add(monPanel1);
		add(new JSlider(10, 200, 10));
		add(monPanel2);
	}
	
	public JPanel creerBouton(String nom) {
		JPanel monBoutonPanel = new JPanel();
		JButton monBouton = new JButton(nom);
		monBoutonPanel.add(monBouton);
//		monBouton.setSize();
		return monBoutonPanel;
	}
	
	public JPanel creerLED(){
		
		JPanel led = new JPanel();
		
		
		
		
		return led;
		
	}
	
	public static void main(String[] args) {
		new IHM();
	}
	
}
