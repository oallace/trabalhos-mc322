package mc322.lab07.view.panels;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageLabel extends JLabel{

	private static final long serialVersionUID = -1623857887826457114L;
	
	public ImageLabel(String imagePath, int iPos, int jPos, int width, int height){
		super();
		setSize(width, height);
		setLocation(iPos, jPos);
		ImageIcon image = new ImageIcon(getClass().getResource(imagePath));
		this.setIcon(image);
	}
}
