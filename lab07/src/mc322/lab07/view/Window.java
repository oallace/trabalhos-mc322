package mc322.lab07.view;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

import mc322.lab07.controller.StateMachineController;
import mc322.lab07.model.Board;
import mc322.lab07.model.pieces.Piece;
import mc322.lab07.view.panels.BoardPanel;
import mc322.lab07.view.panels.ImageLabel;
import mc322.lab07.view.panels.SquareButton;
import mc322.lab07.view.panels.TextLabel;


public class Window extends JFrame{
	
	private static final long serialVersionUID = 7446721714968740806L;
	public static Window instance;
	private Container contentPane;
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
	
}
