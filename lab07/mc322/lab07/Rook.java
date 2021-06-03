package mc322.lab07;

public class Rook extends Piece{
	
	Rook(Player player, Square square){
		super(player, square);
		this.movement = new RookMovement();
		this.image = "caminhoImagem";
	}
}
