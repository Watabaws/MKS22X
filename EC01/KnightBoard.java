import java.util.*;
import java.io.*;

public class KnightBoard{
    int[][] board, combos, moveOrder;
    int[] potMoves;

    public KnightBoard(int startingRows, int startingCols){
	       board = new int[startingRows][startingCols];
           combos = new int[][]{ {2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2} };
           potMoves = new int[combos.length];
           moveOrder = new int[combos.length][2];
    }

    public String twoDString(int[][] toPrint){
        String toRet = "";
        for(int r = 0; r < toPrint.length; r++){
            for(int c = 0; c < toPrint[0].length; c++){
                toRet += toPrint[r][c] + " ";
            }
            toRet += "\n";
        }
        return toRet;
    }

    public void solveFast(){
        solveFastH(0, 0, 1);
    }

    public boolean solveFastH(int row, int col, int level){
        //System.out.println(this);
        if(level == board.length * board[0].length + 1){
            //System.out.println(this);
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
        potMoves = new int[combos.length];

        for(int i = 0; i < combos.length; i++){
            //System.out.println((row+combos[i][0]) + ", " + (row + combos[i][1]));
            checkMoves(row + combos[i][0], col + combos[i][1], i);
        }

        boolean didWork;

        level++;

        for(int i = 0; i < potMoves.length; i++){
            moveOrder[i] = new int[]{potMoves[i], i};
        }

        //System.out.println(twoDString(moveOrder));

        //Thank you StackOverflow :~)
        Arrays.sort(moveOrder, new Comparator<int[]>() {
          @Override
          public int compare(int[] o1, int[] o2) {
            Integer i1 = (Integer)(o1[0]);
            Integer i2 = (Integer)(o2[0]);
            return i1.compareTo(i2);
          }
        });

        //System.out.println(twoDString(moveOrder));

        for(int i = 0; i < moveOrder.length; i++){
            didWork = solveFastH(row + combos[moveOrder[i][1]][0], col + combos[moveOrder[i][1]][1], level);
            if(didWork){
                return true;
            }
        }

        for(int i = 0; i < potMoves.length; i++){
        //    System.out.println(this);
        //    System.out.println(i);
        //    System.out.println(Arrays.toString(potMoves));
        //    System.out.println();
            if(potMoves[i] == 0){
                potMoves[i] = 9;
            }
            if(potMoves[i] <= 2){
                didWork = solveFastH(row + combos[i][0], col + combos[i][1], level);
                if(didWork){
                    return true;
                }
                potMoves[i] = 9;
                i = 0;
            }
            else if(potMoves[i] == 3){
                didWork = solveFastH(row + combos[i][0], col + combos[i][1], level);
                if(didWork){
                    return true;
                }
                potMoves[i] = 9;
                i = 0;
            }
            else if(potMoves[i] == 4){
                didWork = solveFastH(row + combos[i][0], col + combos[i][1], level);
                if(didWork){
                    return true;
                }
                potMoves[i] = 9;
                i = 0;
            }
            else if(potMoves[i] == 5){
                didWork = solveFastH(row + combos[i][0], col + combos[i][1], level);
                if(didWork){
                    return true;
                }
                potMoves[i] = 9;
                i = 0;
            }
            else if(potMoves[i] == 6){
                didWork = solveFastH(row + combos[i][0], col + combos[i][1], level);
                if(didWork){
                    return true;
                }
                potMoves[i] = 9;
                i = 0;
            }
            else if(potMoves[i] == 7){
                didWork = solveFastH(row + combos[i][0], col + combos[i][1],level);
                if(didWork){
                    return true;
                }
                potMoves[i] = 9;
                i = 0;
            }
            else if(potMoves[i] == 8){
                didWork = solveFastH(row + combos[i][0], col + combos[i][1],level);
                if(didWork){
                    return true;
                }
                potMoves[i] = 9;
                i = 0;
            }
        }

        board[row][col] = 0;
        return false;


    }

    public void checkMoves(int row, int col, int moveNum){
        for(int i = 0; i < combos.length; i++){
            if(row < 0 || col < 0 || row > board[0].length || col > board.length){
                i = 9;
            }
            try{
                //System.out.println(board[row + combos[i][0]][col + combos[i][1]] == 0);
                if(board[row + combos[i][0]][col + combos[i][1]] == 0){
                    potMoves[moveNum] +=1 ;
                }
            }
            catch(IndexOutOfBoundsException e){
                //System.out.println(false);
            }
        }
    }

    public void solve(){
	       solveH(0, 0, 1);
    }

    public boolean solveH(int row, int col, int level){

    	if(level == board.length * board[0].length + 1){
            //System.out.println(this);
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
        		    toRet += "   " + board[r][c];
        		}
        		else if(board[r][c] < 100){
        		    toRet += "  " + board[r][c];
        		}
                else if(board[r][c] < 1000){
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
	KnightBoard test = new KnightBoard(64, 64);

	test.solveFast();

	System.out.println(test);
    }

}
