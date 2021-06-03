package mc322.lab07.view.panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TextLabel extends JLabel{

	private static final long serialVersionUID = 3198200384504031621L;
	
	public TextLabel(String text, int iPos, int jPos, int width, int height, int font, int rFont, int gFont, int bFont){
		super(text);
		
		setFont(new Font("Arial", 0, font));
		setForeground(new Color(rFont, gFont, bFont));
		setLocation(iPos, jPos);
		setSize(width, height);

	}
}
