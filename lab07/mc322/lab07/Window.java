package mc322.lab07;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Window extends JFrame{
	
	private static final long serialVersionUID = 7446721714968740806L;
	public static Window instance;
	private Container contentPane;
	private SquarePanel board[][];
	
	
	Window(){
		super();
		instance = this;
		board = new SquarePanel[8][8];
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(710, 820);
		setLocationRelativeTo(null);
		setResizable(false);
		
		this.contentPane = getContentPane();
		this.contentPane.setLayout(null);
		this.contentPane.setBackground(Color.darkGray);
		
		this.contentPane.add(new BoardPanel());
		this.contentPane.add(new NameText(StateMachineController.instance.getPlayer1().getName(), 75, 10, 300, 20, 17));
		this.contentPane.add(new NameText(StateMachineController.instance.getPlayer2().getName(), 75, 728, 300, 20, 17));
		this.contentPane.add(new ImagePanel("../../../images/user.png", 20, 9));
		this.contentPane.add(new ImagePanel("../../../images/user.png", 20, 727));
		
		
		setVisible(true);
	}
	
	
	public SquarePanel getSquarePanel(int iPos, int jPos) {
		return this.board[iPos][jPos];
	}
	
	public void setSquarePanel(SquarePanel squarePanel, int iPos, int jPos) {
		this.board[iPos][jPos] = squarePanel;
	}
	
}
