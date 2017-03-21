
public class QueenBoard{
    private int[][] board;
    private int solutionCount;

    public QueenBoard(int size){
	board = new int[size][size];
	for(int[] r : board){
	    for(int c : r){
		board[r][c] = 0;
	    }
	}
    }

    public boolean solve(){
	return solveH(0);
    }

    private boolean solveH(int col){
	if(col == board.length){
	    return true;
	}
	int row = 0;
	while(row < board.length){
	    if(!placeQueen(col, row)){
		row++;
	    }
	    else{
	        return solveH(col + 1);
	    }
	}
    }

    private updateQueen(col, row){
	for(int workRow = row; workRow < board.length; workRow++){
	    board[col, workRow] += 1;
	}
	for(int workCol = col; workCol < board.length; workCol++){
	    board[workCol, row] += 1;
	}
	for(int workRow = row, workCol = col; workRow < board.length && workCol < board.length; workRow++, workCol++){
	    board[workCol][workRow] += 1;
	}
	
	
    }

    private boolean placeQueen(col, row){
	if(board[col][row] == 0){
	    board[col][row] = -1;
	    updateQueen(col, row);
	    return true;
	}
	return false;
    }

    private removeQueen(col, row){
	if(board[col][row] == -1){
	    board[col][row] = 0;
	    dUpdateQueen(col, row);
	}
    }
       

}
