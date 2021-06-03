package mc322.lab07;

public class AppChess {
	
	public static void main(String args[]) {
		
		Board board = new Board();
		StateMachineController machine = new StateMachineController();
		
		machine.startGame();
		StateMachineController.instance.setWasSquareSelected(true);
		
		if (board.getSquare(7, 3) == board.getSquare(7, 3).getPiece().getSquare()) {
			System.out.println("\noi");
		}
		System.out.println(board.getSquare(7, 3).getPiece().getImage());
		
		Window window = new Window();
	}
}
