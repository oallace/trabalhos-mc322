package mc322.lab07.controller.state;

import mc322.lab07.controller.StateMachineController;
import mc322.lab07.model.Board;
import mc322.lab07.model.pieces.Piece;
import mc322.lab07.view.Window;

public class PieceMovementState extends State{

    public void enter(){
        System.out.println("PieceMovementState:");

        Piece piece = StateMachineController.instance.getSelectedPiece();
        piece.getSquare().setPiece(null);
        Window.instance.getSquareButton(piece.getSquare().getPosition()[0], piece.getSquare().getPosition()[1]).atualizeRepresentation(0);
        piece.setSquare(Board.instance.getSquare(StateMachineController.instance.getSelectedHighlight()[0], StateMachineController.instance.getSelectedHighlight()[1]));
        
        if (piece.getSquare().getPiece() != null){
            Piece deadPiece = piece.getSquare().getPiece();
            System.out.println("The " + deadPiece.getName() + " was dead!");
            deadPiece.getSquare().setPiece(null);
            Window.instance.getSquareButton(piece.getSquare().getPosition()[0], piece.getSquare().getPosition()[1]).atualizeRepresentation(0);
            
            // Retirar ela da array List do jogador, e adicionar um imageLabel na Window das peças capturadas do inimigo.
        }

        piece.getSquare().setPiece(piece);
        piece.setWasMoved();
        Window.instance.getSquareButton(piece.getSquare().getPosition()[0], piece.getSquare().getPosition()[1]).atualizeRepresentation(0);
        StateMachineController.instance.changeTo(new TurnEndState());
    }
}
