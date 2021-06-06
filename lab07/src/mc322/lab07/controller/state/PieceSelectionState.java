package mc322.lab07.controller.state;

import mc322.lab07.controller.StateMachineController;
import mc322.lab07.model.Board;

public class PieceSelectionState extends State{
	
	public void enter() {
		System.out.println("PieceSelectionState:");
		
	}

	public void exit(){
		System.out.println("Selected Piece : " + Board.instance.getSelectedPiece().getName());
	}
	
}
