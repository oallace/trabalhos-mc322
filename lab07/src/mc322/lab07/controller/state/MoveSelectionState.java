package mc322.lab07.controller.state;

import java.util.ArrayList;

import mc322.lab07.controller.StateMachineController;
import mc322.lab07.model.Board;
import mc322.lab07.view.Window;

public class MoveSelectionState extends State{  // Estado de seleção de movimento. No final chama o estado de movimento de peça.

	private ArrayList<int[]> moves;
	
	// Marca no tabuleiro as posições que a peça selecionada pode se mover e nada ocorre até o jogador clicar em alguma dessas posições.
	public void enter() {
		System.out.println("MoveSelectionState:");

		// Obtém os movimentos válidos para aquela paça.
		moves = StateMachineController.instance.getSelectedPiece().getMovement().getValidMoves();
		
		// Caso não haja movimento para aquela peça (peça travada), retorna para o estado de seleção de peça.
		if (moves.size() == 0){
			StateMachineController.instance.changeTo(new PieceSelectionState());
		}

		// Atualiza o tabuleiro marcando as posições válidas
		for(int i = 0; i < moves.size(); i++){
			Board.instance.getSquare(moves.get(i)[0], moves.get(i)[1]).setIsHighlighted(true);
			Window.instance.actualizeSquareRepresentation(moves.get(i)[0], moves.get(i)[1], false);
		}
	}
	
	// Atualiza o tabuleiro desmarcando as posições válidas.
	public void exit() {
		
		for(int i = 0; i < moves.size(); i++){
			Board.instance.getSquare(moves.get(i)[0], moves.get(i)[1]).setIsHighlighted(false);
			Window.instance.actualizeSquareRepresentation(moves.get(i)[0], moves.get(i)[1], false);
		}

		System.out.println("Selected Highlight:  Row " + StateMachineController.instance.getSelectedHighlight()[0] + " - Column " + StateMachineController.instance.getSelectedHighlight()[1]);
	}
}
