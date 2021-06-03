package mc322.lab07;

import mc322.lab07.controller.StateMachineController;
import mc322.lab07.model.Board;
import mc322.lab07.view.Window;

public class AppChess {
	
	public static void main(String args[]) {
		
		Board board = new Board();
		StateMachineController machine = new StateMachineController();
		
		machine.startGame();
		StateMachineController.instance.setWasSquareSelected(true);
		
		if (board.getSquare(7, 3) == board.getSquare(7, 3).getPiece().getSquare()) {
			System.out.println("\noi");
		}
		
		Window window = new Window(board);
	}
}
