package mc322.lab07.controller.state;

import java.util.ArrayList;

import mc322.lab07.controller.StateMachineController;

public class MoveSelectionState extends State{
	
	public void enter() {
		System.out.println("MoveSelectionState:");
		ArrayList<int[]> moves = StateMachineController.instance.getSelectedPiece().getMovement().getValidMoves();
		
		if (moves.size() == 0){
			StateMachineController.instance.changeTo(new PieceSelectionState());
		}

		for(int i = 0; i < moves.size(); i++){
			
		}
		
		StateMachineController.instance.changeTo(new TurnBeginState());
	}
	
	public void exit() {
		
	}
}
