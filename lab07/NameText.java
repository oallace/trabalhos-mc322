package mc322.lab07;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NameText extends JPanel{

	private static final long serialVersionUID = 8846260413030371668L;
	
	NameText(String text, int iPos, int jPos){
		super();
		
		setSize(200, 20);
		setLocation(iPos, jPos);
		setBackground(Color.BLUE);
		setLayout(null);
		
		JLabel jLabelText = new JLabel(text);
		jLabelText.setFont(new Font("Arial", 0, 20));
		jLabelText.setForeground(Color.white);
		jLabelText.setLocation(0, 0);
		jLabelText.setSize(200, 20);

		
		this.add(jLabelText);
	}
}
