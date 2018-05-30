import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

public class TicTacToe{
	boolean xturn = true;
	// Images

    Image _platoImage;
    Image _aristotleImage;
	JButton[] _buttons = new JButton[9];
	
	//constructor
	//most of the work is done here
	public TicTacToe (){
		JFrame _frame = new JFrame("Tic-Tac-Toe");
		
		// Refresh window (well will not be able to see it otherwise)
		// NEVER FORGET thIS
		_frame.setSize(400, 400);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//We want two sections of the frame
		//Called panels
		JPanel _ttt = new JPanel();
		JPanel _newPanel = new JPanel();
		
		//top panel is going to be a grid layout(tictactoe grid)
		//bottom panel is going to have one button in it so doesn't matter what layout
		_ttt.setLayout(new GridLayout(3, 3));
		_newPanel.setLayout(new FlowLayout());
		
		//This will place the tic-tac-toe panel at the top of the frame
		//and the newPanel at the bottom
		_frame.add(_ttt, BorderLayout.NORTH);
		_frame.add(_newPanel, BorderLayout.SOUTH);
		
		for (int j=0; j<9; j++) {
			//Make a new button in the array location with text "_"
			_buttons[j] = new JButton("_");
			
			//Associate a new ButtonListener to the button (see below)
			ActionListener buttonListener = new ButtonListener();
			_buttons[j].addActionListener(buttonListener);
			
			//Set the font on the button
			_buttons[j].setFont(new Font("Courier", Font.PLAIN, 48));
			
			//Add this button to the _tt panel
			_ttt.add(_buttons[j]);
			
		}
		
		try {
			_platoImage = ImageIO.read(getClass().getResource("/plato.png"));
			_aristotleImage = ImageIO.read(getClass().getResource("/aristotle.png"));
		} catch (IOException ioex) {
			System.exit(1);
		}	
		
		//Keep at the end of the constructor 
		_frame.setVisible(true);
	}
    
	
    public static void main(String[] args) {
		new TicTacToe();
    }
	
	class ButtonListener implements ActionListener{
		//Every time we click the button, it will perform the following action
		

		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			String currentText = source.getText();
			if (currentText.equals("_")) {
				if (xturn) {
					source.setIcon(new ImageIcon(_platoImage));
					source.setText("");
					xturn = false;
				} else {
					source.setIcon(new ImageIcon(_aristotleImage));
					source.setText("");
					xturn = true;
				}
			} else if (currentText.equals("Reset")){
				for (int i = 0; i < 9; i++)
				{
					_buttons[i].setText("_");
				}
				xturn = true;
			} else {
				
			}
		}
	}
    
}