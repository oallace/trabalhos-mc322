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
		setBackground(Color.DARK_GRAY);
		int aux = 0;
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				SquarePanel squarePanel = new SquarePanel(8-i, 8-j);
				squarePanel.setLayout(null);
				if (aux == 0) {
					squarePanel.setBackground(new Color(244, 241, 214)); //244, 241, 214
				}
				else {
					squarePanel.setBackground(new Color(128, 165, 91));  //128, 165, 91
				}
				
				if (i == 7) {
					if (aux == 0)
						squarePanel.add(new TextLabel(Character.toString((char)('a' + j)), 65, 60, 15, 18, 19, 128, 165, 91));
					else
						squarePanel.add(new TextLabel(Character.toString((char)((int)'a' + j)), 65, 60, 15, 19, 18, 244, 241, 214));
				}
				if (j == 0) {
					if (aux == 0)
						squarePanel.add(new TextLabel(Integer.toString(8 - i), 4, 4, 18, 18, 19, 128, 165, 91));
					else
						squarePanel.add(new TextLabel(Integer.toString(8 - i), 4, 4, 18, 18, 19, 244, 241, 214));
				}
				
				this.add(squarePanel);
				Window.instance.setSquarePanel(squarePanel, 7-i, 7-j);
				aux = (aux == 1) ? 0:1;
			}
			
			aux = (aux == 1) ? 0:1;
		}
	}
}
