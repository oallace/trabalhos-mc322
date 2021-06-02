package mc322.lab07;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


public class Window extends JFrame{
	
	private static final long serialVersionUID = 7446721714968740806L;
	private Container contentPane;
	
	
	Window(){
		super();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(710, 820);
		setLocationRelativeTo(null);
		setResizable(false);
		
		this.contentPane = getContentPane();
		this.contentPane.setLayout(null);
		this.contentPane.setBackground(Color.darkGray);
		
		this.contentPane.add(new BoardPanel());
		this.contentPane.add(new NameText(StateMachineController.instance.getPlayer1().name, 20, 10));
		this.contentPane.add(new NameText(StateMachineController.instance.getPlayer2().name, 20, 730));
		
		setVisible(true);
	}
	
	
	public void addImage(String imagePath) {
		ImageIcon image = new ImageIcon(imagePath);
		JLabel imageField = new JLabel(image);
		this.contentPane.add(imageField, BorderLayout.CENTER);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void removeImage() {
		;
	}
}
