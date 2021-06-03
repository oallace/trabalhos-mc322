package mc322.lab07;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

	private static final long serialVersionUID = -1623857887826457114L;
	
	ImagePanel(String path, int iPos, int jPos){
		super();
		
		setSize(45, 45);
		setLocation(iPos, jPos);
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		
		//ImageIcon image = new ImageIcon(getClass().getResource(path));
		//JLabel imageLabel = new JLabel(image);
		//imageLabel.setSize(45, 45);
		//imageLabel.setLocation(0, 0);
		
		//this.add(imageLabel);
	}
}
