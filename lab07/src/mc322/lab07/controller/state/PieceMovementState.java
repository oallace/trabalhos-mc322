package mc322.lab07.controller.state;

import mc322.lab07.controller.StateMachineController;
import mc322.lab07.controller.movement.MoveType;
import mc322.lab07.controller.movement.SpecialsMovements;
import mc322.lab07.model.Board;
import mc322.lab07.model.pieces.Piece;
import mc322.lab07.view.Window;

public class PieceMovementState extends State{   // Movimenta a peça e inicia o estado de fim de turno.

    public void enter(){
        System.out.println("PieceMovementState:");

        MoveType moveType = Board.instance.getSquare(StateMachineController.instance.getSelectedHighlight()[0], StateMachineController.instance.getSelectedHighlight()[1]).getMoveType();

        // Analisa qual será o tipo de movimento e executa o movimento necessário.
        if (moveType == MoveType.NormalMovement)
            normalMovement();
        
        else if (moveType == MoveType.CastlingMovement)
            SpecialsMovements.castlingMovement();
        
        else if (moveType == MoveType.PawnPromotionMovement)
            SpecialsMovements.pawnPromotion();
        
        else if (moveType == MoveType.PawnDoubleMovement)
            SpecialsMovements.pawnDoubleMovement();
        
        else if (moveType == MoveType.EnPassantMovement)
            SpecialsMovements.enPassantMovement();

        
        StateMachineController.instance.changeTo(new TurnEndState());
    }



    void normalMovement(){
        // Altera a posição da peça no Board e atualiza a imagem do tabuleiro.
        Piece piece = StateMachineController.instance.getSelectedPiece();
        piece.getSquare().setPiece(null);
        Window.instance.atualizeSquareRepresentation(piece.getSquare().getPosition()[0], piece.getSquare().getPosition()[1], true);
        piece.setSquare(Board.instance.getSquare(StateMachineController.instance.getSelectedHighlight()[0], StateMachineController.instance.getSelectedHighlight()[1]));
        
        // Come uma peça inimiga caso haja alguma na posição alvo.
        if (piece.getSquare().getPiece() != null){
            Piece deadPiece = piece.getSquare().getPiece();
            System.out.println("The " + deadPiece.getName() + " was dead!");
            deadPiece.getSquare().setPiece(null);
            Window.instance.atualizeSquareRepresentation(deadPiece.getSquare().getPosition()[0], deadPiece.getSquare().getPosition()[1], true);
            
            // Retirar ela da array List do jogador, e adicionar um imageLabel na Window das peças capturadas do inimigo.
            Board.instance.removeTeamPiece(deadPiece);
        }

        // Movimenta a peça para a posição alvo.
        piece.getSquare().setPiece(piece);
        piece.setWasMoved();
        Window.instance.atualizeSquareRepresentation(piece.getSquare().getPosition()[0], piece.getSquare().getPosition()[1], true);
    }


    // Percorre os Squares do jogador atual que possui algum EnPassant moveType e transforma em NormalMovement moveType
    void clearEnPassants(){
        
    }
}
