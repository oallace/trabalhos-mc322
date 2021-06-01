package mc322.lab07;

public class Pawn extends Piece{
	
	Pawn(Player player, Square square){
		super(player, square);
		this.movement = new PawnMovement();
		this.image = "caminhoImagem";
	}
}
