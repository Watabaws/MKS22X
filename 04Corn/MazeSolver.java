import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MazeSolver{
    private char[][] maze;
    private int startR = -1, startC = -1;
    private boolean animate, isEnd = false;

    public MazeSolver(String file) throws FileNotFoundException{
        File infile = new File(file);
        Scanner inf = new Scanner(infile);
        int lineNumber = 1;
        String line = "";
        while(inf.hasNextLine()){
            line += inf.nextLine();
            lineNumber++;
        }

        inf = new Scanner(infile);

        int lineLen = inf.nextLine().length();
        maze = new char[lineNumber][lineLen];

        for(int i = 0; i < lineNumber-1; i++){
            maze[i] = line.substring(0, lineLen).toCharArray();
            line = line.substring(lineLen);
        }

        for(int r = 0; r < maze.length; r++){
            for(int c = 0; c < maze[0].length; c++){
                if(maze[r][c] == 'S'){
                    startR = r;
                    startC = c;
                }
                if(maze[r][c] == 'E'){
                    isEnd = true;
                }
            }
        }

        if((startR == -1 && startC == -1) || !isEnd){
            throw new FileNotFoundException("You are missing a start or end!");
        }

    }

    public void solve(){
        solveH(startR, startC);
        System.out.println(this);
    }


    private boolean solveH(int row, int col){
	if(animate){
	    System.out.println("\033[2J\033[1;1H"+this);
	    try{
		//wait(20);
		TimeUnit.MILLISECONDS.sleep(20);
	    }
	    catch(InterruptedException e){}

	 }
        if(maze[row][col] == 'E'){
            return true;
        }

        if(maze[row][col] == '#' || maze[row][col] == '.'){
            return false;
        }
        else{
            maze[row][col] = '.';
        }


        boolean dW = solveH(row+1,col) || solveH(row, col+1) || solveH(row-1, col) || solveH(row, col-1);

        if(dW){
            maze[row][col] = '@';
        }

        return dW;
    }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        System.out.println("\033[2J\033[1;1H");
    }

    public String toString(){
        String toRet = "";
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[i].length; j++){
		if(maze[i][j] == '#'){
		    toRet += "\u001B[35m";
		}
		if(maze[i][j] == '@'){
		    toRet += "\u001B[37m";
		}
		if(maze[i][j] == '.'){
		    toRet += "\u001B[36m";
		}
                toRet += maze[i][j];
            }
            toRet += "\n";
        }
        return toRet;
    }

    public static void main(String[] args) throws FileNotFoundException{
        MazeSolver test = new MazeSolver(args[0]);

	    test.setAnimate(true);

        test.solve();

	    System.out.println(test);
	    System.out.println("\u001B[0m");
	
    }


}
