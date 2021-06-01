package mc322.lab07;

public abstract class Piece {
	
	protected Player player;
	
	protected Movement movement;
	
	protected Square square;
	
	protected boolean wasMoved;
	
	protected String image;
	
	Piece(Player player, Square square){
		this.player = player;
		this.square = square;
		this.wasMoved = false;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public Movement getMovement() {
		return this.movement;
	}
	
	public Square getSquare() {
		return this.square;
	}
	
	public void setSquare(Square square) {
		this.square = square;
	}
	
	public boolean getWasMoved() {
		return this.wasMoved;
	}
	
	public void setWasMoved() {
		this.wasMoved = true;
	}
	
	public String getImage() {
		return this.image;
	}
}
