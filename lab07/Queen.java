package mc322.lab07;

public class Queen extends Piece{
	
	Queen(Player player, Square square){
		super(player, square);
		this.movement = new QueenMovement();
		this.image = "Ri";
	}
}
