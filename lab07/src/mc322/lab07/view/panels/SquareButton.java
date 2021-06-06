package mc322.lab07.view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.text.Position;

import mc322.lab07.controller.StateMachineController;
import mc322.lab07.controller.state.PieceSelectionState;
import mc322.lab07.controller.state.MoveSelectionState;
import mc322.lab07.view.Window;
import mc322.lab07.model.Board;
import mc322.lab07.model.pieces.Piece;

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
	
	public void atualizeRepresentation()
	{
		// representação da peça:
		String pieceName = Window.instance.getPieceName(position[0]-1, position[1]-1);
		if (pieceName != null)
			addImage("../images/" +pieceName + ".png");
	}
	
	public void addImage(String imagePath) {
		if (imagePath != null)
			this.add(new ImageLabel(imagePath, 10, 15, 55, 55));
	}
	
	
	public void removeImage() {
		;
	}

	// Classe que será chamada ao clicar no JPanel.
	private class SquareButtonlHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// Função disparada quando clicamos sobre um SquareButton:
			System.out.println("Selected Square:  Row " + position[0] + " - Column "+ position[1]);

			if (StateMachineController.instance.getCurrentState() instanceof PieceSelectionState){
				Piece selectedPiece = Board.instance.getSquare(position[0] - 1, position[1] - 1).getPiece();

				if (selectedPiece != null && StateMachineController.instance.getCurrentPlayer() == selectedPiece.getPlayer()){
					Board.instance.setSelectedPiece(selectedPiece);
					StateMachineController.instance.changeTo(new MoveSelectionState());
				}
			}
		}
	}
}
