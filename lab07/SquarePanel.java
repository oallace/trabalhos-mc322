package mc322.lab07;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SquarePanel extends JPanel{

	private static final long serialVersionUID = 4934802567644563818L;
	private int[] position;
	
	SquarePanel(int iPos, int jPos){
		super();
		position = new int[2];    // A posição será usada na clickFunction para obter as coordenadas do square clicado
		position[0] = iPos;
		position[1] = jPos;
	}
	
	
	public int[] getPosition() {
		return this.position;
	}
	
	
	public void addImage(String imagePath) {
		ImageIcon image = new ImageIcon(imagePath);
		JLabel imageField = new JLabel(image);
		this.add(imageField, BorderLayout.CENTER);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	
	public void removeImage() {
		;
	}
}
