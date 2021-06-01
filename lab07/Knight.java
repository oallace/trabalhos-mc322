package mc322.lab07;

public class Knight extends Piece{
	
	Knight(Player player, Square square){
		super(player, square);
		this.movement = new KnightMovement();
		this.image = "caminhoImagem";
	}
}
