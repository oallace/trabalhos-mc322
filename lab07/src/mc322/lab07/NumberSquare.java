package mc322.lab07;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NumberSquare extends JPanel{
	
	private static final long serialVersionUID = -7060869116920444980L;

	NumberSquare(String text, int iPos, int jPos, int width, int height, int font, int rPane, int gPane, int bPane, int rFont, int gFont, int bFont){
		super();
		
		setSize(width, height);
		setLocation(iPos, jPos);
		setBackground(new Color(rPane, gPane, bPane));
		setLayout(null);
		
		JLabel jLabelText = new JLabel(text);
		jLabelText.setFont(new Font("Arial", 0, font));
		jLabelText.setForeground(new Color(rFont, gFont, bFont));
		jLabelText.setLocation(0, 0);
		jLabelText.setSize(width, height);

		
		this.add(jLabelText);
	}
}
