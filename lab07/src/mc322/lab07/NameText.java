package mc322.lab07;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NameText extends JPanel{

	private static final long serialVersionUID = 8846260413030371668L;
	
	NameText(String text, int iPos, int jPos, int width, int height, int font){
		super();
		
		setSize(width, height);
		setLocation(iPos, jPos);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JLabel jLabelText = new JLabel(text);
		jLabelText.setFont(new Font("Arial", 0, font));
		jLabelText.setForeground(Color.white);
		jLabelText.setLocation(0, 0);
		jLabelText.setSize(width, height);

		
		this.add(jLabelText);
	}
}
