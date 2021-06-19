package mc322.lab07.controller.movement;

import java.util.ArrayList;

import mc322.lab07.model.Board;
import mc322.lab07.model.pieces.Piece;
import mc322.lab07.model.pieces.Rook;
import mc322.lab07.model.squares.Square;

public class KingMovement extends Movement{

    public ArrayList<int[]> getValidMoves(boolean safeMovements, Piece piece){

        ArrayList<int[]> moves = new ArrayList<>();

        moves.addAll(untilBlockedPath(piece, 1, 0, true, 1));
        moves.addAll(untilBlockedPath(piece, -1, 0, true, 1));
        moves.addAll(untilBlockedPath(piece, 0, 1, true, 1));
        moves.addAll(untilBlockedPath(piece, 0, -1, true, 1));
        moves.addAll(untilBlockedPath(piece, 1, 1, true, 1));
        moves.addAll(untilBlockedPath(piece, -1, 1, true, 1));
        moves.addAll(untilBlockedPath(piece, 1, -1, true, 1));
        moves.addAll(untilBlockedPath(piece, -1, -1, true, 1));

        // Retira da lista moves os squares que estão sendo atacados por alguma peça inimiga.
        if (safeMovements){
            getSafeMovements(moves, piece);
        }

        // Obter novas posições para o movimento do Rei caso o castling seja uma escolha possível
        moves.addAll(castling(piece));

        return moves;
    }


    // Obter posições para o movimento do castling
    ArrayList<int[]> castling(Piece piece){
        ArrayList<int[]> moves = new  ArrayList<>();

        if (piece.getWasMoved()){
            return moves;
        }
        // Checa as posições para direita
        int[] position = checkRook(1, piece);
        if (position != null){
            moves.add(position);
            Board.instance.getSquare(position[0], position[1]).setMoveType(MoveType.CastlingMovement);
        }
        // Checa as posições para esquerda
        position = checkRook(-1, piece);
        if (position != null){
            moves.add(position);
            Board.instance.getSquare(position[0], position[1]).setMoveType(MoveType.CastlingMovement);
        }

        return moves;
    }


    // Analisar condições para o castling ser possível
    int[] checkRook(int xDirection, Piece piece){
        Square currentSquare = piece.getSquare();
        currentSquare = Board.instance.getSquare(currentSquare.getPosition()[0], currentSquare.getPosition()[1]+xDirection);

        while (currentSquare != null){
            if (currentSquare.getPiece() != null){
                break;
            }

            currentSquare = Board.instance.getSquare(currentSquare.getPosition()[0], currentSquare.getPosition()[1]+xDirection);
        }

        // Se chegou na borda do tabuleiro e não encontrou nenhuma peça
        if (currentSquare == null){
            return null;
        }
        // Se encontrar uma peça que não seja uma torre, ou se a torre já foi movida alguma vez
        if (!(currentSquare.getPiece() instanceof Rook) || currentSquare.getPiece().getWasMoved()){
            return null;
        }

        return currentSquare.getPosition();
    }
}
