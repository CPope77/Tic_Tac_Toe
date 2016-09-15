package edu.jsu.mcis;

import javax.swing.*;

public class Dialog implements Runnable{
	private String message;
	
	public Dialog(String string){
		message = string;
	}
	
	public void run(){
		JOptionPane.showMessageDialog(null, message, "Game Over", JOptionPane.INFORMATION_MESSAGE);
	}
}