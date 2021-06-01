package mc322.lab07;

import java.awt.Color;
import javax.swing.JPanel;

public class BoardPanel extends JPanel{
	
	private static final long serialVersionUID = 5792445905048410976L;

	BoardPanel(){
		super();
		
		setSize(650, 650);
		setLocation(20, 65);
		//setLayout(new gridLayout());
		setBackground(Color.BLUE);
	}
}
