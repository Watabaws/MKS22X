public class KnightBoard{
    int[][] board;

    public KnightBoard(int startingRows, int startingCols){
	       board = new int[startingRows][startingCols];
    }

    public void solve(){
	       solveH(0, 0, 1);
    }

    public boolean solveH(int row, int col, int level){

    	if(level == board.length * board[0].length + 1){
            System.out.println(this);
    	    return true;
    	}

    	try{
    	    if(board[row][col] != 0){
                return false;
    	    }
    	}
    	catch(IndexOutOfBoundsException e){
    	    return false;
    	}

    	board[row][col] = level;

    	level = level + 1;

        if(!(solveH(row + 2, col + 1, level) || solveH(row + 2, col - 1, level) || solveH(row - 2, col + 1, level) || solveH(row - 2, col - 1, level) || solveH(row + 1, col + 2, level) || solveH(row + 1, col - 2, level) || solveH(row - 1, col + 2, level) || solveH(row - 1, col - 2, level))){
                					    board[row][col] = 0;
                					    return false;
        }

        return true;
    }

    public String toString(){
    	String toRet = "";
    	for(int r = 0; r < board.length; r++){
    	    for(int c = 0; c < board.length; c++){
        		if(board[r][c] < 10){
        		    toRet += " " + board[r][c];
        		}
        		else{
        		    toRet += "" + board[r][c];
        		}
        		toRet += " ";
    	    }
    	    toRet += "\n";
    	}
    	return toRet;
    }

    public static void main(String[] args){
	KnightBoard test = new KnightBoard(7,7);

	test.solve();

	System.out.println(test);
    }

}
