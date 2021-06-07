package mc322.lab07.controller.state;

import mc322.lab07.controller.StateMachineController;

public class PieceSelectionState extends State{
	
	public void enter() {
		System.out.println("PieceSelectionState:");
		
	}

	public void exit(){
		System.out.println("Selected Piece : " + StateMachineController.instance.getSelectedPiece().getName());
	}
	
}
