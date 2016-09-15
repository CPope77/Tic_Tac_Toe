package edu.jsu.mcis; 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeGUI extends JFrame implements ActionListener{
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
		label = new JLabel(winner, JLabel.TOP);
		add(label);
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
            getWinner();
        }
    }
    
    private void getWinner(){
		model.getWinner();
		String winMessage = model.winMessage;
		int count = model.playCount;		
        if(winMessage != ""){
            winner = winMessage;
            label.setText(winner);
        }
        else{
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(!isEmpty(i, j)){
                        count++;
                    }
                }
            }
        }
    }
	
    private boolean isEmpty(int row, int col){
        return buttonGrid[row][col].getText().length() == 0;
    }
}