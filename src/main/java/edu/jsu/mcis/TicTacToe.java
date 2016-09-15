package edu.jsu.mcis; 

import javax.swing.JFrame;

public class TicTacToe{	
    public static void main(String[] args){
		JFrame window = new JFrame("Tic Tac Toe");
		window.add(new TicTacToeGUI());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(300, 300);
        window.setVisible(true);
    }
}
