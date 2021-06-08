package mc322.lab07.controller.movement;

import java.util.ArrayList;

import mc322.lab07.controller.StateMachineController;
import mc322.lab07.model.Board;
import mc322.lab07.model.squares.Square;

public abstract class Movement {

    public abstract ArrayList<int[]> getValidMoves();


    protected boolean isEnemy(Square square){
        if (square.getPiece() != null && square.getPiece().getPlayer() != StateMachineController.instance.getCurrentPlayer()){
            return true;
        }
        return false;
    }

    protected ArrayList<int[]> untilBlockedPath(int yDirection, int xDirection, boolean includeBlocked, int limit){
        ArrayList<int[]> moves = new ArrayList<>(); 
        Square currentSquare = StateMachineController.instance.getSelectedPiece().getSquare();

        while (currentSquare != null && moves.size() < limit){
            currentSquare = Board.instance.getSquare(currentSquare.getPosition()[0]+yDirection, currentSquare.getPosition()[1]+xDirection);
            
            if (currentSquare != null){
                if (currentSquare.getPiece() == null){
                    moves.add(currentSquare.getPosition());
                }

                else if (isEnemy(currentSquare)){
                    if (includeBlocked){
                        moves.add(currentSquare.getPosition());
                    }
                    return moves;
                }

                else{
                    return moves;
                }
            }
        }
        return moves;
    }
}
