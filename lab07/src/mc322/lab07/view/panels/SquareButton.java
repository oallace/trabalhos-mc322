package mc322.lab07.view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class SquareButton extends JButton{

	private static final long serialVersionUID = 4934802567644563818L;
	private int[] position;
	
	public SquareButton(int iPos, int jPos){
		super();
		position = new int[2];    // A posição será usada na clickFunction para obter as coordenadas do square clicado
		position[0] = iPos;
		position[1] = jPos;
		addActionListener(new SquareButtonlHandler());
	}
	
	
	public int[] getPosition() {
		return this.position;
	}
	
	
	public void addImage(String imagePath) {
		this.add(new ImageLabel(imagePath, 0, 0));
	}
	
	
	public void removeImage() {
		;
	}

	// Classe que será chamada ao clicar no JPanel.
	private static class SquareButtonlHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// Função disparada quando clicamos sobre um SquareButton:
			System.out.println("Clicou!");
		}
	}
}
