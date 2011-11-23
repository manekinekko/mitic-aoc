package metronome;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;

/**
 * Cette classe Définit le composant peremttant d'afficher les valeur du tempo.
 * 
 * @author Wassim Chegham <contact@cheghamwassim.com>
 * @author Gurval Le Bouter <gurval.lebouter@gmail.com>
 * @version 1.0
 */
public class LCD extends JTextField {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur du LCD.
	 * @since 1.0
	 */
	public LCD(){
		super();
		setPreferredSize(new Dimension(120, 50));
		setEditable(false);
		setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		setHorizontalAlignment(JTextField.CENTER);
		setBackground(Color.black);
		setForeground(Color.white);
	}
	
}