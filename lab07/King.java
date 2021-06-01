package mc322.lab07;

public class King extends Piece{
	
	King(Player player, Square square){
		super(player, square);
		this.movement = new KingMovement();
		this.image = "caminhoImagem";
	}
}
