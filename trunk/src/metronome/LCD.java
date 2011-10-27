package metronome;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;

public class LCD extends JTextField {

	private static final long serialVersionUID = 1L;
	
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