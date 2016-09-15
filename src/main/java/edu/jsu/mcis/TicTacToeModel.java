package edu.jsu.mcis; 

public class TicTacToeModel{
	public int[][] grid;
	private boolean empty;
	public int playCount;
	public String winMessage;
	public boolean playerTurn;

	public TicTacToeModel(){
		playerTurn = true;
		grid = new int[3][3];
		empty = true;
		playCount = 0;
		winMessage = "";
		clearGrid();
	}
	
	public void clearGrid(){
		playCount = 0;
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid.length; j++){
				grid[i][j] = 0;
			}
		}
	}
	
	public String getMark(int row, int col){
		if(grid[row][col] == 0){
			return "";
		}
		else if(grid[row][col] == 1){
			return "X";
		}
		else return "O";
	}

	public void makeMark(String mark, int row, int col){	
		if(grid[row][col] < 1){
			if(grid[row][col] == 0){
				if(mark.equals("X")){
					grid[row][col] = 1;
				}
				else if(mark.equals("O")){
					grid[row][col] = 2; 
				}
				else if(mark.equals("")){
					grid[row][col] = 0; 
				}
				playCount++;
			}
		}
	}
	
	public boolean isBoardEmpty(){
		for(int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				if(grid[i][j] == 0){
					empty = true;
				}
				else{
					empty = false;
				}
			}
		}
		return empty;
	}
	
	public boolean isGameStillRunning(){
		if(playCount == 9){
			return false;
		}
		else{
			return true;
		}
	}
	
	public String horizontalWinner(){
		for(int i = 0; i < 3; i++){				
			if(getMark(0, i).equals("X")){
				winMessage = "X";
			}
			if(getMark(0, i).equals("O")){
				winMessage = "O";
			}
			if(getMark(1, i).equals("X")){
				winMessage = "X";
			}
			if(getMark(1, i).equals("O")){
				winMessage = "O";
			}
			if(getMark(2, i).equals("X")){
				winMessage = "X";
			}
			if(getMark(2, i).equals("O")){
				winMessage = "O";
			}
		}
		return winMessage;
	}
	
	public String verticalWinner(){
		for(int i = 0; i < 3; i++){				
			if((getMark(0, i).equals("X") || getMark(1, i).equals("X") || getMark(2, i).equals("X")) && !empty){
				winMessage = getMark(0, i);
			}
			if((getMark(0, i).equals("O") || getMark(1, i).equals("O") || getMark(2, i).equals("O")) && !empty){
				winMessage = getMark(0, i);
			}
		}
		return winMessage;
	}
	
	private String diagonalWinner(){
		if (grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2] && grid[0][0] != 0){
			winMessage = getMark(0, 0);
		}
		if (grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0] &&	grid[0][2] != 0){
			winMessage = getMark(0, 2);
		}
		return winMessage;
	}
	
	private String tieGame(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if((getMark(i, j).equals("X") || getMark(i, j).equals("O")) && playCount == 9){
					winMessage = "TIE";
				}
			}
		}
		return winMessage;
	}
	
	public String getWinner(){
		if (playCount != 9){
			horizontalWinner();
			diagonalWinner();
			verticalWinner();
		}
		if(playCount == 9){
			tieGame();
		}
		return winMessage;
	}
}




