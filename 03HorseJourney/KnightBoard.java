public class KnightBoard{
    int[][] board;
    
    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
    }

    public void solve(){
	solveH((int)Math.random() * board.length, (int)Math.random() * board[0].length, 0);
    }

    public boolean solveH(int row, int col, int level){
	if(level == board.length * board[0].length){
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

	    if(!solveH(row + 2, col + 1, level)){
		if(!solveH(row + 2, col - 1, level)){
		    if(!solveH(row - 2, col + 1, level)){
			if(!solveH(row - 2, col - 1, level)){
			    if(!solveH(row + 1, col + 2, level)){
				if(!solveH(row + 1, col - 2, level)){
				    if(!solveH(row - 1, col + 2, level)){
					if(!solveH(row - 1, col - 2, level)){
					    return false;
					}
				    }
				}
			    }
			}
		    }
		}
	    }

	return true;
    }

    public String toString(){
	String toRet = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board.length; c++){
		toRet += " " + board[r][c];
	    }
	    toRet += "\n";
	}
	return toRet;
    }

    public static void main(String[] args){
	KnightBoard test = new KnightBoard(5, 5);

	test.solve();

	System.out.println(test);
    }

}
