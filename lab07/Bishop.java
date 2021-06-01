package mc322.lab07;

public class Bishop extends Piece{
	
	Bishop(Player player, Square square){
		super(player, square);
		this.movement = new BishopMovement();
		this.image = "caminhoImagem";
	}
}
