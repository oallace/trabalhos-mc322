package mc322.lab07.controller.movement;

import java.util.ArrayList;

import mc322.lab07.controller.StateMachineController;
import mc322.lab07.model.Board;
import mc322.lab07.model.pieces.Piece;
import mc322.lab07.model.squares.Square;

public class PawnMovement extends Movement{

    public ArrayList<int[]> getValidMoves(){
        int limit = 1;
        if (!StateMachineController.instance.getSelectedPiece().getWasMoved()){
            limit = 2;
        }

        int[] direction = getDirection();
        ArrayList<int[]> moves = new ArrayList<>();
        moves.addAll(untilBlockedPath(direction[0], direction[1], false, limit));
        moves.addAll(getPawnAttack(direction));

        return moves;
    }

    int[] getDirection(){
        int[] direction = new int[2];
        direction[1] = 0;
        if (StateMachineController.instance.getCurrentPlayer().getTeam() == 'W'){
            direction[0] = -1;
        }
        else{
            direction[0] = 1;
        }
        return direction;
    }

    ArrayList<int[]> getPawnAttack(int[] direction){
        ArrayList<int[]> pawnAttack = new ArrayList<>();
        Square square;
        Piece selectedPiece = StateMachineController.instance.getSelectedPiece();

        square = Board.instance.getSquare(selectedPiece.getSquare().getPosition()[0]+direction[0], selectedPiece.getSquare().getPosition()[1]-1);
        if (square != null && isEnemy(square)){
            pawnAttack.add(square.getPosition());
        }

        square = Board.instance.getSquare(selectedPiece.getSquare().getPosition()[0]+direction[0], selectedPiece.getSquare().getPosition()[1]+1);
        if (square != null && isEnemy(square)){
            pawnAttack.add(square.getPosition());
        }

        return pawnAttack;
    }
}
