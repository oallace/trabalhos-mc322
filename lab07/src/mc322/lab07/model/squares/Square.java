package mc322.lab07.model.squares;

import mc322.lab07.model.pieces.Piece;

public class Square {
	
	private int position[];
	
	private Piece piece;

	private boolean isHighlighted; // Indica se o square está marcado com movimento de paça.
	
	// Haverá mais informação, como se este square está congelado.
	
	public Square(int iPos, int jPos){
		position = new int[2];
		position[0] = iPos;
		position[1] = jPos;
		piece = null;
		isHighlighted = false;
	}
	
	
	public int[] getPosition(){
		return this.position;
	}
	
	public Piece getPiece() {
		return this.piece;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public boolean getIsHighlighted(){
		return this.isHighlighted;
	}

	public void setIsHighlighted(boolean bool){
		this.isHighlighted = bool;
	}
}
