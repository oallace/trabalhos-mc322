package mc322.lab07.controller.state;

import mc322.lab07.controller.StateMachineController;
import mc322.lab07.model.Board;
import mc322.lab07.model.pieces.*;

public class LoadState extends State{
	
	public void enter() {
		System.out.println("LoadState:");
		
		for (int j = 0; j < 8; j++) {
			Board.instance.getSquare(1, j).setPiece(new Pawn(StateMachineController.instance.getPlayer2(), Board.instance.getSquare(1, j)));
			Board.instance.getSquare(6, j).setPiece(new Pawn(StateMachineController.instance.getPlayer1(), Board.instance.getSquare(6, j)));
		}
		
		Board.instance.getSquare(0, 0).setPiece(new Rook(StateMachineController.instance.getPlayer2(), Board.instance.getSquare(0, 0)));
		Board.instance.getSquare(0, 1).setPiece(new Knight(StateMachineController.instance.getPlayer2(), Board.instance.getSquare(0, 1)));
		Board.instance.getSquare(0, 2).setPiece(new Bishop(StateMachineController.instance.getPlayer2(), Board.instance.getSquare(0, 2)));
		Board.instance.getSquare(0, 3).setPiece(new Queen(StateMachineController.instance.getPlayer2(), Board.instance.getSquare(0, 3)));
		Board.instance.getSquare(0, 4).setPiece(new King(StateMachineController.instance.getPlayer2(), Board.instance.getSquare(0, 4)));
		Board.instance.getSquare(0, 5).setPiece(new Bishop(StateMachineController.instance.getPlayer2(), Board.instance.getSquare(0, 5)));
		Board.instance.getSquare(0, 6).setPiece(new Knight(StateMachineController.instance.getPlayer2(), Board.instance.getSquare(0, 6)));
		Board.instance.getSquare(0, 7).setPiece(new Rook(StateMachineController.instance.getPlayer2(), Board.instance.getSquare(0, 7)));
		
		Board.instance.getSquare(7, 0).setPiece(new Rook(StateMachineController.instance.getPlayer1(), Board.instance.getSquare(7, 0)));
		Board.instance.getSquare(7, 1).setPiece(new Knight(StateMachineController.instance.getPlayer1(), Board.instance.getSquare(7, 1)));
		Board.instance.getSquare(7, 2).setPiece(new Bishop(StateMachineController.instance.getPlayer1(), Board.instance.getSquare(7, 2)));
		Board.instance.getSquare(7, 3).setPiece(new Queen(StateMachineController.instance.getPlayer1(), Board.instance.getSquare(7, 3)));
		Board.instance.getSquare(7, 4).setPiece(new King(StateMachineController.instance.getPlayer1(), Board.instance.getSquare(7, 4)));
		Board.instance.getSquare(7, 5).setPiece(new Bishop(StateMachineController.instance.getPlayer1(), Board.instance.getSquare(7, 5)));
		Board.instance.getSquare(7, 6).setPiece(new Knight(StateMachineController.instance.getPlayer1(), Board.instance.getSquare(7, 6)));
		Board.instance.getSquare(7, 7).setPiece(new Rook(StateMachineController.instance.getPlayer1(), Board.instance.getSquare(7, 7)));
		
		StateMachineController.instance.setCurrentPlayer(StateMachineController.instance.getPlayer1());
		
		StateMachineController.instance.changeTo(new TurnBeginState());
	}
}
