package mc322.lab07.view.panels;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageLabel extends JLabel{

	private static final long serialVersionUID = -1623857887826457114L;
	
	public ImageLabel(String imagePath, int iPos, int jPos){
		super();
				
		ImageIcon image = new ImageIcon(getClass().getResource(imagePath));
		setSize(45, 45);
		setLocation(iPos, jPos);
		this.setIcon(image);
	}
}
