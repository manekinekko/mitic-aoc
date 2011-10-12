package metronome;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LCD extends JPanel {

	private static final long serialVersionUID = 1L;
	private String message_;
	
	public LCD(String message){
		
		super();
		message_ = message;
		setPreferredSize(new Dimension(200, 100));
		JLabel label = new JLabel(message);
		add(label);
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.gray);
		g.fillRect(0, 0, getWidth(), getHeight());
		
	}

}
