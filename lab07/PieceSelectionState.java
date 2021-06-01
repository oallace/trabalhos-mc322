package mc322.lab07;

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
