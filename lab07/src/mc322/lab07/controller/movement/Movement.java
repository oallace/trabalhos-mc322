package mc322.lab07.controller.movement;

import java.util.ArrayList;

import mc322.lab07.controller.StateMachineController;
import mc322.lab07.model.Board;
import mc322.lab07.model.squares.Square;

public abstract class Movement {

    // Retorna uma lista com as posições de todos os movimentos possíveis para uma dada peça.
    public abstract ArrayList<int[]> getValidMoves();

    // Analisa se uma peça é inimiga do jogador do turno atual
    protected boolean isEnemy(Square square){
        if (square.getPiece() != null && square.getPiece().getPlayer() != StateMachineController.instance.getCurrentPlayer()){
            return true;
        }
        return false;
    }

    // Retorna uma lista com as posições de todos os movimentos possíveis em uma dada direção, para uma dada peça. O parametro "includeBlocked",
    //  sendo false, indica que ao encontrar uma peça inimiga deve-se interromper o movimento sem poder comer a peça (caso do peão).
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

    // Altera o moveType dos squares nas posições dadas para NormalMovement
    public void setNormalMovement(ArrayList<int[]> moves){
        for (int i = 0; i < moves.size(); i++){
            int[] position = moves.get(i);
            Board.instance.getSquare(position[0], position[1]).setMoveType(MoveType.NormalMovement);
        }
    }
}
