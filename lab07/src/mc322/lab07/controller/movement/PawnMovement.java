package mc322.lab07.controller.movement;

import java.util.ArrayList;
import java.lang.Math;

import mc322.lab07.controller.StateMachineController;
import mc322.lab07.model.Board;
import mc322.lab07.model.pieces.Piece;
import mc322.lab07.model.squares.Square;

public class PawnMovement extends Movement{

    public ArrayList<int[]> getValidMoves(){
        // Pega 2 como limite de movimentos caso seja o primeiro movimento do peão
        int limit = 1;
        if (!StateMachineController.instance.getSelectedPiece().getWasMoved()){
            limit = 2;
        }

        // Pegar os movimentos válidos
        int[] direction = getDirection();
        ArrayList<int[]> moves = new ArrayList<>();
        moves.addAll(untilBlockedPath(direction[0], direction[1], false, limit));
        moves.addAll(getPawnAttack(direction));

        // Analisa os movimentos válidos do peão. Se algum deles gerar uma promoção ou pulo duplo atualiza o moveType do square no qual o peão
        // irá se movimentar para PawnPromotionMovement ou PawnDoubleMovement
        for (int i = 0; i < moves.size(); i++){
            int[] position = moves.get(i);
            if (position[0] == 0 || position[0] == 7)
                Board.instance.getSquare(position[0], position[1]).setMoveType(MoveType.PawnPromotionMovement);
            
            if (Math.abs(position[0] - StateMachineController.instance.getSelectedPiece().getSquare().getPosition()[0]) == 2)
                Board.instance.getSquare(position[0], position[1]).setMoveType(MoveType.PawnDoubleMovement);
        }

        return moves;
    }

    // Pega a direção de movimento do peão.
    int[] getDirection(){
        int[] direction = new int[2];
        direction[1] = 0;
        if (StateMachineController.instance.getCurrentPlayer().getTeam() == "WhiteTeam"){
            direction[0] = -1;
        }
        else{
            direction[0] = 1;
        }
        return direction;
    }

    // Analisa se nas diagonais no sentido retornado pela getDirection() há alguma peça inimiga. Se sim, o peão pode comê-las, logo são
    // posições válidas para o movimento.
    ArrayList<int[]> getPawnAttack(int[] direction){
        ArrayList<int[]> pawnAttack = new ArrayList<>();
        Square square;
        Piece selectedPiece = StateMachineController.instance.getSelectedPiece();

        square = Board.instance.getSquare(selectedPiece.getSquare().getPosition()[0]+direction[0], selectedPiece.getSquare().getPosition()[1]-1);
        if (square != null && (isEnemy(square) || square.getMoveType() == MoveType.EnPassantMovement)){
            pawnAttack.add(square.getPosition());
        }

        square = Board.instance.getSquare(selectedPiece.getSquare().getPosition()[0]+direction[0], selectedPiece.getSquare().getPosition()[1]+1);
        if (square != null && (isEnemy(square) || square.getMoveType() == MoveType.EnPassantMovement)){
            pawnAttack.add(square.getPosition());
        }

        return pawnAttack;
    }
}
