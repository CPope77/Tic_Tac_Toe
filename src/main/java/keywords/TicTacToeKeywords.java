import edu.jsu.mcis.*;

public class TicTacToeKeywords {
    private TicTacToeModel model;
    private boolean turn;
	private int[][] board;
	
    public void startNewGame() {
        model = new TicTacToeModel();
        turn = true;
		model.clearGrid();
    }
    
    public void markLocation(int row, int col) {
        String m = (turn)? "X" : "O";
        model.makeMark(m, row, col);
        turn = !turn;
    }
    
    public String getMark(int r, int c) {
        return model.getMark(r, c);
    }
    
    public String getWinner() {
		model.getWinner();
        return model.winMessage;
    }
}



