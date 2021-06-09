package mc322.lab07.controller.state;

import java.util.ArrayList;

import mc322.lab07.controller.StateMachineController;
import mc322.lab07.view.Window;
import mc322.lab07.view.panels.SquareButton;

public class MoveSelectionState extends State{

	private ArrayList<int[]> moves;
	
	public void enter() {
		System.out.println("MoveSelectionState:");
		moves = StateMachineController.instance.getSelectedPiece().getMovement().getValidMoves();
		
		if (moves.size() == 0){
			StateMachineController.instance.changeTo(new PieceSelectionState());
		}

		for(int i = 0; i < moves.size(); i++){
			SquareButton square = Window.instance.getSquareButton(moves.get(i)[0], moves.get(i)[1]);
			square.setIsHighlighted(true);
			if (square.getColor() == "beige")
				square.addImage(1, "../images/circleFullBeige.png", 10, 15, 70, 70);
			else
				square.addImage(1, "../images/circleFullGreen.png", 10, 15, 70, 70);
		}
		
	}
	
	public void exit() {
		for(int i = 0; i < moves.size(); i++){
			SquareButton square = Window.instance.getSquareButton(moves.get(i)[0], moves.get(i)[1]);
			square.setIsHighlighted(false);
			square.atualizeRepresentation(1);
		}

		System.out.println("Selected Highlight:  Row " + StateMachineController.instance.getSelectedHighlight()[0] + " - Column " + StateMachineController.instance.getSelectedHighlight()[1]);
	}
}
