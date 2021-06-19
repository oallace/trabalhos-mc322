package mc322.lab07.controller.movement;

import java.util.ArrayList;

import mc322.lab07.controller.StateMachineController;
import mc322.lab07.model.Board;
import mc322.lab07.model.Player;
import mc322.lab07.model.pieces.Pawn;
import mc322.lab07.model.pieces.Piece;
import mc322.lab07.model.squares.Square;

public abstract class Movement {

    // Retorna uma lista com as posições de todos os movimentos possíveis para uma dada peça. O parametro safeMovements, caso tenha o valor
    // true, faz com que o método retorne apenas os movimentos que evitem que o Rei do jogador fique em cheque.
    public abstract ArrayList<int[]> getValidMoves(boolean safeMovements, Piece piece);

    // Analisa se uma peça é inimiga do jogador passado como argumento
    protected boolean isEnemy(Square square, Player player){
        if (square.getPiece() != null && square.getPiece().getPlayer() != player){
            return true;
        }
        return false;
    }

    // Retorna uma lista com as posições de todos os movimentos possíveis em uma dada direção, para uma dada peça. O parametro "includeBlocked",
    //  sendo false, indica que ao encontrar uma peça inimiga deve-se interromper o movimento sem poder comer a peça (caso do peão).
    protected ArrayList<int[]> untilBlockedPath(Piece piece, int yDirection, int xDirection, boolean includeBlocked, int limit){
        ArrayList<int[]> moves = new ArrayList<>(); 
        Square currentSquare = piece.getSquare();

        while (currentSquare != null && moves.size() < limit){
            currentSquare = Board.instance.getSquare(currentSquare.getPosition()[0]+yDirection, currentSquare.getPosition()[1]+xDirection);
            
            if (currentSquare != null){
                if (currentSquare.getPiece() == null){
                    moves.add(currentSquare.getPosition());
                }

                else if (isEnemy(currentSquare, piece.getPlayer())){
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


    // Analisa se um dado square está sob ataque de alguma peça do jogador passado como argumento
    public static boolean isSquareAttacked(Player player, Square square){
        Piece piece;
        int yPawnDirection = (player.getTeam() == "WhiteTeam") ? -1 : 1;
        ArrayList<Piece> listPieces = Board.instance.getTeamPieces(player.getTeam());

        for (int i = 0; i < listPieces.size(); i++){
            piece = listPieces.get(i);

            // Se for um peão, analisa e o square está na linha de ataque diagonal do peão
            if (piece instanceof Pawn){
                int [] pawnPosition = piece.getSquare().getPosition();

                if ((pawnPosition[0] + yPawnDirection) == square.getPosition()[0] && 
                    ((pawnPosition[1] - 1) == square.getPosition()[1] || (pawnPosition[1] + 1) == square.getPosition()[1])){
                    
                    return true;
                }
            }
            // Se não for um peão, analisa se o square esta nos movimentos válidos daquela peça.
            else{
                if (piece.getMovement().getValidMoves(false, piece).contains(square.getPosition())){
                    return true;
                }
            }
        }

        return false;
    }

    // Analisa quais dos movimentos de uma lista de movimentos são seguros, excluindo os demais.
    protected void getSafeMovements(ArrayList<int[]> moves, Piece piece){
        Player enemyPlayer = (piece.getPlayer() == StateMachineController.instance.getPlayer1()) ? StateMachineController.instance.getPlayer2() : StateMachineController.instance.getPlayer1();
        
        for (int i = 0; i < moves.size(); i++){
            if (!isSafeMovement(piece, moves.get(i), enemyPlayer)){
                moves.remove(i);
                i -= 1;
            }
        }
    }


    // Analisa se um movimento é seguro
    boolean isSafeMovement(Piece piece, int[] movement, Player enemyPlayer){
        return true;
    }
}
