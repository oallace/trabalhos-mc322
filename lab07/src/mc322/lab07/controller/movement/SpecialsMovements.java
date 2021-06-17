package mc322.lab07.controller.movement;

import mc322.lab07.controller.StateMachineController;
import mc322.lab07.model.Board;
import mc322.lab07.model.pieces.Piece;
import mc322.lab07.model.pieces.Queen;
import mc322.lab07.model.squares.Square;
import mc322.lab07.view.Window;

public abstract class SpecialsMovements {

    // Movimento que altera as posições do rei e da torre
    public static void castlingMovement(){
        Piece king = StateMachineController.instance.getSelectedPiece();
        Piece rook = Board.instance.getSquare(StateMachineController.instance.getSelectedHighlight()[0], StateMachineController.instance.getSelectedHighlight()[1]).getPiece();

        // Retirar as peças do tabuleiro e atualizar a imagem
        king.getSquare().setPiece(null);
        rook.getSquare().setPiece(null);
        Window.instance.actualizeSquareRepresentation(king.getSquare().getPosition()[0], king.getSquare().getPosition()[1], true);
        Window.instance.actualizeSquareRepresentation(rook.getSquare().getPosition()[0], rook.getSquare().getPosition()[1], true);

        // Colocar as peças nas novas posições e atualizar a imagem
        int direction = rook.getSquare().getPosition()[1] - king.getSquare().getPosition()[1];
        if (direction > 0){
            king.setSquare(Board.instance.getSquare(king.getSquare().getPosition()[0], king.getSquare().getPosition()[1]+2));
            rook.setSquare(Board.instance.getSquare(king.getSquare().getPosition()[0], king.getSquare().getPosition()[1]-1));
        }
        else{
            king.setSquare(Board.instance.getSquare(king.getSquare().getPosition()[0], king.getSquare().getPosition()[1]-2));
            rook.setSquare(Board.instance.getSquare(king.getSquare().getPosition()[0], king.getSquare().getPosition()[1]+1));
        }
        king.getSquare().setPiece(king);
        rook.getSquare().setPiece(rook);
        Window.instance.actualizeSquareRepresentation(king.getSquare().getPosition()[0], king.getSquare().getPosition()[1], true);
        Window.instance.actualizeSquareRepresentation(rook.getSquare().getPosition()[0], rook.getSquare().getPosition()[1], true);

        king.setWasMoved();
        rook.setWasMoved();
    }



    // Movimento de promoção de peão
    public static void pawnPromotion(){
        Piece pawn = StateMachineController.instance.getSelectedPiece();
        
        // Retira a peça do tabuleiro e atualiza a imagem
        pawn.getSquare().setPiece(null);
        Window.instance.actualizeSquareRepresentation(pawn.getSquare().getPosition()[0], pawn.getSquare().getPosition()[1], true);
        Board.instance.removeTeamPiece(pawn);

        // Cria uma nova peça rainha, adiciona ela no tabuleiro e atualiza a imagem
        Square highlightSquare = Board.instance.getSquare(StateMachineController.instance.getSelectedHighlight()[0], StateMachineController.instance.getSelectedHighlight()[1]);
        Piece queen = new Queen(StateMachineController.instance.getCurrentPlayer(), highlightSquare);
        Board.instance.addTeamPiece(StateMachineController.instance.getCurrentPlayer().getTeam(), queen);

        // Remove alguma peça inimiga que estivesse naquela posição
        if (highlightSquare.getPiece() != null){
            Piece deadPiece = highlightSquare.getPiece();
            System.out.println("The " + deadPiece.getName() + " was dead!");
            deadPiece.getSquare().setPiece(null);
            Window.instance.actualizeSquareRepresentation(deadPiece.getSquare().getPosition()[0], deadPiece.getSquare().getPosition()[1], true);
            
            // Retirar ela da array List do jogador, e adicionar um imageLabel na Window das peças capturadas do inimigo.
            Board.instance.removeTeamPiece(deadPiece);
        }

        queen.getSquare().setPiece(queen);
        Window.instance.actualizeSquareRepresentation(queen.getSquare().getPosition()[0], queen.getSquare().getPosition()[1], true);
    }



    // Movimento de pulo duplo do peão
    public static void pawnDoubleMovement(){

    }



    // Movimento de comer um peão EnPassant
    public static void enPassantMovement(){

    }
}
