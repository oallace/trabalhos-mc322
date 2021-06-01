package mc322.lab07;

import java.util.ArrayList;

public class MoveSelectionState extends State{
	ArrayList<Highlights> activeHighlights = new ArrayList<>();
	ArrayList<Highlights> onReserveHighlights = new ArrayList<>();
	
	public void enter() {
		System.out.println("MoveSelectionState:");
		//ArrayList<Square> moves = Board.instance.getSelectedPiece().movement.;
		
	}
	
	public void exit() {
		
	}
}
