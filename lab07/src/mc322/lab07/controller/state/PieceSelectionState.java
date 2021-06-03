package mc322.lab07.controller.state;

import mc322.lab07.controller.StateMachineController;

public class PieceSelectionState extends State{
	
	public void enter() {
		System.out.println("PieceSelectionState:");
		
		//while (!StateMachineController.instance.getWasSquareSelected()) {
		//	;
		//}
		
		StateMachineController.instance.setWasSquareSelected(false);
		StateMachineController.instance.changeTo(new MoveSelectionState());
	}
	
}
