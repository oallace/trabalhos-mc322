package mc322.lab07.view.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.text.Position;

import mc322.lab07.controller.StateMachineController;
import mc322.lab07.controller.state.PieceSelectionState;
import mc322.lab07.controller.state.TurnBeginState;
import mc322.lab07.controller.state.MoveSelectionState;
import mc322.lab07.controller.state.PieceMovementState;
import mc322.lab07.view.Window;
import mc322.lab07.model.Board;
import mc322.lab07.model.pieces.Piece;

public class SquareButton extends JButton{

	private static final long serialVersionUID = 4934802567644563818L;
	private int[] position;
	private Component[] components;
	private String color;
	private boolean isHighlighted;
	
	public SquareButton(int iPos, int jPos){
		super();
		position = new int[2];    // A posição será usada na clickFunction para obter as coordenadas do square clicado
		position[0] = iPos;
		position[1] = jPos;
		components = new Component[2]; // 0 : peça   1 : highlight
		isHighlighted = false;
		addActionListener(new SquareButtonlHandler());

		// Estilo do botão:
		this.setBorderPainted(false);
		this.setFocusPainted(false);
	}
	
	
	public int[] getPosition() {
		return this.position;
	}

	public String getColor(){
		return this.color;
	}

	public void setColor(String color){
		this.color = color;
	}

	public boolean getIsHighlighted(){
		return this.isHighlighted;
	}

	public void setIsHighlighted(boolean bool){
		this.isHighlighted = bool;
	}

	
	// FALTA UTILIZAR A UTILITIES PARA ATUALIZAR A IMAGEM DINAMICAMENTE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! =========>
	public void atualizeRepresentation(int idx)
	{
		//Remove imagens antigas:
			// remove a representação passada de peça:
		if (components[idx] != null)
		{
			this.remove(components[idx]);
			components[idx] = null;
		}
		SwingUtilities.updateComponentTreeUI(this);
		// novas imagens sobre o Square:
		if (idx == 0){
			String pieceName = Window.instance.getPieceName(position[0], position[1]);
			if (pieceName != null)
				addImage(idx, "../images/" +pieceName + ".png", 10, 15, 55, 55);
		}
	}
	
	public void addImage(int idx, String imagePath, int x, int y, int width, int height) {
		if (imagePath != null) {
			ImageLabel newImage = new ImageLabel(imagePath, x, y, width, height);
			this.add(newImage);
			components[idx] = newImage; // 0 se refere à imagem da peça.
		}
		SwingUtilities.updateComponentTreeUI(this);
	}
	

	// Classe que será chamada ao clicar no JPanel.
	private class SquareButtonlHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// Função disparada quando clicamos sobre um SquareButton:
			System.out.println("Selected Square:  Row " + position[0] + " - Column "+ position[1]);

			if (StateMachineController.instance.getCurrentState() instanceof PieceSelectionState ||
				StateMachineController.instance.getCurrentState() instanceof MoveSelectionState){
					
					// Estado de MoveSelection
					if (isHighlighted){
						StateMachineController.instance.setSelectedHighlight(position[0], position[1]);
						StateMachineController.instance.changeTo(new PieceMovementState());
					}
					
					// Estado de PieceSelection
					else if (Board.instance.getSquare(position[0], position[1]).getPiece() != null){
						Piece selectedPiece = Board.instance.getSquare(position[0], position[1]).getPiece();

						if (selectedPiece != null && StateMachineController.instance.getCurrentPlayer() == selectedPiece.getPlayer()){
							StateMachineController.instance.setSelectedPiece(selectedPiece);
							StateMachineController.instance.changeTo(new MoveSelectionState());
						}
					}
			}
		}
	}
}
