package edu.jsu.mcis; 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeGUI extends JPanel implements ActionListener{
    private JButton[][] buttonGrid;
    private boolean playerTurn;
	private TicTacToeModel model;
	private JLabel label;
	public String winner;
    
    public TicTacToeGUI(){
		model = new TicTacToeModel();
        playerTurn = true;
        setLayout(new GridLayout(3, 3));
		winner = "";
        buttonGrid = new JButton[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
				buttonGrid[i][j] = new JButton();
				buttonGrid[i][j].addActionListener(this);
				add(buttonGrid[i][j]);
            }
        }
    }    

    public void actionPerformed(ActionEvent event){
        JButton button = (JButton)event.getSource();
        if(button.getText().length() == 0){
            if(playerTurn){
                button.setText("X");
            }
            else{
                button.setText("O");
            }
            playerTurn = !playerTurn;
        }
		checkForWinner();
    }
	
	private void checkForWinner(){
		model.getWinner();
		String win;
		if(model.isGameStillRunning() && model.winMessage == "X"){
			win = "X";
		}
		else if(model.isGameStillRunning() && model.winMessage == "O"){
			win = "O";
		}
		else if (model.isGameStillRunning() && model.winMessage == "TIE"){
			win = "TIE";
		}
		else {
			win = "";
		}
		if(win.length() > 0){
			Dialog dialog = new Dialog("The winner is " + win);
			Thread thread = new Thread(dialog);
			thread.start();
		}
	}
	
    private boolean isEmpty(int row, int col){
        return buttonGrid[row][col].getText().length() == 0;
    }
}