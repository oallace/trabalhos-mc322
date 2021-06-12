package mc322.lab07.controller.state;

import mc322.lab07.controller.StateMachineController;
import mc322.lab07.model.Board;
import mc322.lab07.model.pieces.Piece;
import mc322.lab07.view.Window;

public class PieceMovementState extends State{   // Movimenta a peça e inicia o estado de fim de turno.

    public void enter(){
        System.out.println("PieceMovementState:");
        
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
        
        StateMachineController.instance.changeTo(new TurnEndState());
    }
}
