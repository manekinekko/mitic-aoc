package metronome;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;

/**
 * Cette classe Définit le composant permettant d'afficher les valeur du tempo.
 * 
 * @author <ul><li>Wassim Chegham (<a href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li><li>Gurval Le Bouter (<a href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li></ul>
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