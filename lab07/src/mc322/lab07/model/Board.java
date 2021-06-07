package mc322.lab07.model;

import java.util.ArrayList;

import mc322.lab07.model.pieces.Piece;
import mc322.lab07.model.squares.Square;

public class Board {

	public static Board instance;
	
	private Square board[][];
	
	private ArrayList<Piece> whitePieces;
	
	private ArrayList<Piece> blackPieces;
	
	
	public Board(){
		instance = this;
		board = new Square[8][8];
		whitePieces = new ArrayList<>();
		blackPieces = new ArrayList<>();
		
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Square square = new Square(i, j);
				board[i][j] = square;
			}
		}
	}
	
	public Square getSquare(int i, int j) {
		if (i>=0 && i<=7 && j>=0 && j<=7){
			return this.board[i][j];
		}
		return null;
	}
	
	
	public void setPiece(int i, int j, Piece piece) {
		this.board[i][j].setPiece(piece);
	}

	public String getPieceName(int i, int j)
	{
		if (board[i][j].getPiece() != null)
			return board[i][j].getPiece().getName();
		return null;
	}
	
	
	public ArrayList<Piece> getTeamPieces(char team){
		if (team == 'W') {
			return this.whitePieces;
		}
		return this.blackPieces;
	}
	
	
	public void addTeamPiece(char team, Piece piece) {
		if (team == 'W') {
			this.whitePieces.add(piece);
		}
		else {
			this.blackPieces.add(piece);
		}
	}
}
