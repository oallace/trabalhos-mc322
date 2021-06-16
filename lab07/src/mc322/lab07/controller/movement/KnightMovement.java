package mc322.lab07.controller.movement;

import java.util.ArrayList;

import mc322.lab07.controller.StateMachineController;
import mc322.lab07.model.Board;
import mc322.lab07.model.pieces.Piece;
import mc322.lab07.model.squares.Square;

public class KnightMovement extends Movement{

    public ArrayList<int[]> getValidMoves(){

        ArrayList<int[]> moves = new ArrayList<>();
        moves.addAll(getLMovement(0, 1));
        moves.addAll(getLMovement(0, -1));
        moves.addAll(getLMovement(1, 0));
        moves.addAll(getLMovement(-1, 0));

        setNormalMovement(moves);

        return moves;
    }

    ArrayList<int[]> getLMovement(int yDirection, int xDirection){
        ArrayList<int[]> moves = new ArrayList<>();
        Piece selectePiece = StateMachineController.instance.getSelectedPiece();
        Square square = Board.instance.getSquare(selectePiece.getSquare().getPosition()[0]+2*yDirection, selectePiece.getSquare().getPosition()[1]+2*xDirection);
        
        if (square != null){
            moves.addAll(getCurvedPart(square.getPosition(), xDirection, yDirection));
        }

        return moves;
    }

    ArrayList<int[]> getCurvedPart(int[] squarePosition, int yDirection, int xDirection){

        ArrayList<int[]> moves = new ArrayList<>();
        Square square1 = Board.instance.getSquare(squarePosition[0] + yDirection, squarePosition[1] + xDirection);
        Square square2 = Board.instance.getSquare(squarePosition[0] - yDirection, squarePosition[1] - xDirection);

        if (square1 != null && (square1.getPiece()==null || isEnemy(square1))){
            moves.add(square1.getPosition());
        }
        if (square2 != null && (square2.getPiece()==null || isEnemy(square2))){
            moves.add(square2.getPosition());
        }

        return moves;
    }
}
