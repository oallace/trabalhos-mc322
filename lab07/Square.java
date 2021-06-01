package mc322.lab07;

public class Square {
	private int position[];
	
	private Piece piece;
	
	// Haverá mais informação, como se este square está congelado.
	
	Square(int iPos, int jPos){
		position = new int[2];
		position[0] = iPos;
		position[1] = jPos;
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
}
