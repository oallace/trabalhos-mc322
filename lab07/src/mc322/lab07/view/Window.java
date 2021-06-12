package mc322.lab07.view;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

import mc322.lab07.controller.StateMachineController;
import mc322.lab07.model.Board;
import mc322.lab07.model.squares.Square;
import mc322.lab07.view.panels.BoardPanel;
import mc322.lab07.view.panels.ImageLabel;
import mc322.lab07.view.panels.SquareButton;
import mc322.lab07.view.panels.TextLabel;


public class Window extends JFrame{
	
	private static final long serialVersionUID = 7446721714968740806L;

	public static Window instance;  // Instância estática para acessar o View a partir do Board e do Controller.

	private Container contentPane;  // Matriz que guarda os Squares dentro do BoardPanel.

	private SquareButton board[][];
	
	
	public Window(){
		super();
		instance = this;
		board = new SquareButton[8][8];
			
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(710, 820);
		setLocationRelativeTo(null);
		setResizable(false);
		
		this.contentPane = getContentPane();
		this.contentPane.setLayout(null);
		this.contentPane.setBackground(Color.darkGray);
		
		// Instancia os componentes do jogo dentro do contentPane
		this.contentPane.add(new BoardPanel());
		this.contentPane.add(new TextLabel(StateMachineController.instance.getPlayer1().getName(), 75, 10, 300, 20, 17, 255, 255, 255)); // solicitar nome para Player
		this.contentPane.add(new TextLabel(StateMachineController.instance.getPlayer2().getName(), 75, 728, 300, 20, 17, 255, 255, 255));
		this.contentPane.add(new ImageLabel("../images/user.png", 20, 9, 45, 45)); // editar tamanho da imagem.
		this.contentPane.add(new ImageLabel("../images/user.png", 20, 727, 45, 45));
		
		setVisible(true);
	}
	
	
	public SquareButton getSquareButton(int iPos, int jPos) {
		return this.board[iPos][jPos];
	}
	
	public void setSquareButton(SquareButton squarePanel, int iPos, int jPos) {
		this.board[iPos][jPos] = squarePanel;
	}

	public String getPieceName(int iPos, int jPos)
	{
		return Board.instance.getPieceName(iPos, jPos);
	}
	

	// Atualiza a representação da peça, do highlight e dos efeitos, respectivamente, de um dado square do tabuleiro.
	public void atualizeSquareRepresentation(int iPos, int jPos, boolean attPiece){
		Square square = Board.instance.getSquare(iPos, jPos);
		SquareButton squareButton = this.board[iPos][jPos];

		// Analisar a adição ou remoção de peça
		if (attPiece){
			// Adiciona uma peça
			if (square.getPiece() != null){
				String pieceName = Window.instance.getPieceName(squareButton.getPosition()[0], squareButton.getPosition()[1]);
				if (pieceName != null)
					squareButton.addImage(0, "../images/" +pieceName + ".png", 10, 15, 55, 55);
			}

			// Remove uma peça
			else{
				squareButton.removeImage(0);
			}
		}
			
		// Adiciona um highlight
		if (square.getIsHighlighted()){
			if (squareButton.getColor() == "beige")
				squareButton.addImage(1, "../images/circleFullBeige.png", 10, 15, 70, 70);
			else
				squareButton.addImage(1, "../images/circleFullGreen.png", 10, 15, 70, 70);
		}
		// Remove um highlight
		else{
			squareButton.removeImage(1);
		}
	}
}
