package mc322.lab07;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class BoardPanel extends JPanel{
	
	private static final long serialVersionUID = 5792445905048410976L;

	BoardPanel(){
		super();
		
		setSize(650, 650);
		setLocation(20, 65);
		setLayout(new GridLayout(8, 8));
		setBackground(Color.LIGHT_GRAY);
		int aux = 0;
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (aux == 0) {
					SquarePanel squarePanel = new SquarePanel();
					squarePanel.setBackground(new Color(244, 241, 214)); //244, 241, 214
					this.add(squarePanel);
					aux = 1;
				}
				else {
					SquarePanel squarePanel = new SquarePanel();
					squarePanel.setBackground(new Color(128, 165, 91));  //128, 165, 91
					this.add(squarePanel);
					aux = 0;
				}
			}
			
			aux = (aux == 1) ? 0:1;
		}
	}
}
