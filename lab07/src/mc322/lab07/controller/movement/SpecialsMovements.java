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

        king.getSquare().setPiece(null);
        rook.getSquare().setPiece(null);
        Window.instance.atualizeSquareRepresentation(king.getSquare().getPosition()[0], king.getSquare().getPosition()[1], true);
        Window.instance.atualizeSquareRepresentation(rook.getSquare().getPosition()[0], rook.getSquare().getPosition()[1], true);

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
        Window.instance.atualizeSquareRepresentation(king.getSquare().getPosition()[0], king.getSquare().getPosition()[1], true);
        Window.instance.atualizeSquareRepresentation(rook.getSquare().getPosition()[0], rook.getSquare().getPosition()[1], true);

        king.setWasMoved();
        rook.setWasMoved();
    }


    // Movimento de promoção de peão
    public static void pawnPromotion(){
        Piece pawn = StateMachineController.instance.getSelectedPiece();
        
        pawn.getSquare().setPiece(null);
        Window.instance.atualizeSquareRepresentation(pawn.getSquare().getPosition()[0], pawn.getSquare().getPosition()[1], true);
        Board.instance.removeTeamPiece(pawn);

        Square highlightSquare = Board.instance.getSquare(StateMachineController.instance.getSelectedHighlight()[0], StateMachineController.instance.getSelectedHighlight()[1]);
        Piece queen = new Queen(StateMachineController.instance.getCurrentPlayer(), highlightSquare);
        Board.instance.addTeamPiece(StateMachineController.instance.getCurrentPlayer().getTeam(), queen);

        if (highlightSquare.getPiece() != null){
            Piece deadPiece = highlightSquare.getPiece();
            System.out.println("The " + deadPiece.getName() + " was dead!");
            deadPiece.getSquare().setPiece(null);
            Window.instance.atualizeSquareRepresentation(deadPiece.getSquare().getPosition()[0], deadPiece.getSquare().getPosition()[1], true);
            
            // Retirar ela da array List do jogador, e adicionar um imageLabel na Window das peças capturadas do inimigo.
            Board.instance.removeTeamPiece(deadPiece);
        }

        queen.getSquare().setPiece(queen);
        Window.instance.atualizeSquareRepresentation(queen.getSquare().getPosition()[0], queen.getSquare().getPosition()[1], true);
    }
}
