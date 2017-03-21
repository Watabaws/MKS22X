<<<<<<< HEAD
public class QueenBoard{
    private int[][] board;
    private int solutionCount;

    public QueenBoard(int size){
        board = new int[size][size];
        solutionCount = -1;
        for(int r = 0;r <  board.length; r++){
            for(int c = 0; c < board.length; c++){
                board[r][c] = 0;
            }
        }


    }

    public boolean solve(){
        return solveH(0);
    }


    private boolean solveH(int col){
        //System.out.println(this);

        int row = 0;

        if(col == board.length){
            return true;
        }

        while(row < board.length){
            if(board[col][row] == 0){

		//System.out.println("Placing queen @ " + col + " " + row + " ");
                placeQueen(col, row);
		boolean workd = solveH(col + 1);
                if(!workd){
		    //System.out.println("Removing queen @ " + col + " " + row + " ");
                    removeQueen(col, row);
                    System.out.println(this);
                    row++;
                }
                else{
                    return true;
                }
            }
            else{
                row++;
            }
        }

        return false;
    }

    private void placeQueen(int col, int row){
        updateBoard(col, row);
        board[col][row] = -1;
    }

    private void updateBoard(int col, int row){
        for(int c = 0; c < board.length; c++){

            if(board[c][row] != -1){
                board[c][row] += 1;
            }

            if(board[col][c] != -1){
                board[col][c] += 1;
            }
        }

        for(int offset = 1; col + offset < board.length && row + offset < board.length;offset++){
            board[col + offset][row + offset] += 1;
        }

        for(int offset = 1; col + offset < board.length && row - offset >= 0; offset++){
            board[col + offset][row - offset] += 1;
        }

        for(int offset = 1; col - offset >= 0 && row + offset < board.length; offset++){
            board[col - offset][row + offset] += 1;
        }

        for(int offset = 1; col - offset >= 0 && row - offset >= 0; offset++){
            board[col - offset][row - offset] += 1;
        }
    }

    private void removeQueen(int col, int row){
        dUpdateBoard(col, row);
        board[col][row] = 0;
    }

    private void dUpdateBoard(int col, int row){
        for(int c = 0; c < board.length; c++){
            if(board[c][row] != -1){
                board[c][row] -= 1;
            }
            if(board[col][c] != -1){
                board[col][c] -= 1;
            }
        }

        for(int offset = 1; col + offset < board.length && row + offset < board.length;offset++){
            board[col + offset][row + offset] -= 1;
        }

        for(int offset = 1; col + offset < board.length && row - offset >= 0; offset++){
            board[col + offset][row - offset] -= 1;
        }

        for(int offset = 1; col - offset >= 0 && row + offset < board.length; offset++){
            board[col - offset][row + offset] -= 1;
        }

        for(int offset = 1; col - offset >= 0 && row - offset >= 0; offset++){
            board[col - offset][row - offset] -= 1;
        }
    }

    public void countSolutions(){
        solutionCount = 0;
        countSolutionsH(0);
    }

    public boolean countSolutionsH(int col){
        int row = 0;

        if(col == board.length){
            solutionCount += 1;
            return false;
        }

        while(row < board.length){
            if(board[col][row] == 0){
                placeQueen(col, row);
		        boolean workd = countSolutionsH(col + 1);
                if(!workd){
                    removeQueen(col, row);
                    //System.out.println(this);
                    row++;
                }
                else{
                    return true;
                }
            }
            else{
                row++;
            }
        }

        return false;
    }

    public int getSolutionCount(){
        return solutionCount;
    }



    public String toString(){
        String toret = "";
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board.length; c++){
                toret += board[c][r] + "   ";
            }
            toret += "\n";
        }
        return toret;
    }

    public static void main(String[] args){
        QueenBoard test = new QueenBoard(8);

        //test.solve();
        test.countSolutions();
        //test.placeQueen(4,4);
        //System.out.println(test.getSolutionCount());
    }
}
=======
public class QueenBoard{
    private int[][] board;
    private int solutionCount;

    public QueenBoard(int size){
        board = new int[size][size];
        for(int r = 0;r <  board.length; r++){
            for(int c = 0; c < board.length; c++){
                board[r][c] = 0;
            }
        }


    }

    public boolean solve(){
        return solveH(0);
    }


    private boolean solveH(int col){
        System.out.println(this);

        int row = 0;

        if(col == board.length){
            return true;
        }

        while(row < board.length){
            if(board[col][row] == 0){

		System.out.println("Placing queen @ " + col + " " + row + " ");
                placeQueen(col, row);
		boolean workd = solveH(col + 1);
                if(!workd){
		    System.out.println("Removing queen @ " + col + " " + row + " ");
                    removeQueen(col, row);
                    System.out.println(this);
                    row++;
                }
                else{
                    return true;
                }
            }
            else{
                row++;
            }
        }

        return false;
    }

    private void placeQueen(int col, int row){
        updateBoard(col, row);
        board[col][row] = -1;
    }

    private void updateBoard(int col, int row){
        for(int c = 0; c < board.length; c++){

            if(board[c][row] != -1){
                board[c][row] += 1;
            }

            if(board[col][c] != -1){
                board[col][c] += 1;
            }
        }

        for(int offset = 1; col + offset < board.length && row + offset < board.length;offset++){
            board[col + offset][row + offset] += 1;
        }

        for(int offset = 1; col + offset < board.length && row - offset >= 0; offset++){
            board[col + offset][row - offset] += 1;
        }

        for(int offset = 1; col - offset >= 0 && row + offset < board.length; offset++){
            board[col - offset][row + offset] += 1;
        }

        for(int offset = 1; col - offset >= 0 && row - offset >= 0; offset++){
            board[col - offset][row - offset] += 1;
        }
    }

    private void removeQueen(int col, int row){
        dUpdateBoard(col, row);
        board[col][row] = 0;
    }

    private void dUpdateBoard(int col, int row){
        for(int c = 0; c < board.length; c++){
            if(board[c][row] != -1){
                board[c][row] -= 1;
            }
            if(board[col][c] != -1){
                board[col][c] -= 1;
            }
        }

        for(int offset = 1; col + offset < board.length && row + offset < board.length;offset++){
            board[col + offset][row + offset] -= 1;
        }

        for(int offset = 1; col + offset < board.length && row - offset >= 0; offset++){
            board[col + offset][row - offset] -= 1;
        }

        for(int offset = 1; col - offset >= 0 && row + offset < board.length; offset++){
            board[col - offset][row + offset] -= 1;
        }

        for(int offset = 1; col - offset >= 0 && row - offset >= 0; offset++){
            board[col - offset][row - offset] -= 1;
        }
    }

    public void countSolutions(){
        countSolutionsH(0);
    }

    public boolean countSolutionsH(int col){
        int row = 0;

        if(col == board.length){
            solutionCount += 1;
            return false;
        }

        while(row < board.length){
            if(board[col][row] == 0){
                placeQueen(col, row);
		        boolean workd = countSolutionsH(col + 1);
                if(!workd){
                    removeQueen(col, row);
                    System.out.println(this);
                    row++;
                }
                else{
                    return true;
                }
            }
            else{
                row++;
            }
        }

        return false;
    }

    public int getSolutionCount(){
        return solutionCount;
    }



    public String toString(){
        String toret = "";
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board.length; c++){
                toret += board[c][r] + "   ";
            }
            toret += "\n";
        }
        return toret;
    }

    public static void main(String[] args){
        QueenBoard test = new QueenBoard(8);

        //test.solve();
        test.countSolutions();
        //test.placeQueen(4,4);
        System.out.println(test.getSolutionCount());
    }
}
>>>>>>> d717baed764d1db11eea3740aee8367d165b4fbc
