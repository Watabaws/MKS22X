import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MazeSolver{
    char[][] maze;
    int startR, startC;
    boolean animate = true;

    public MazeSolver() throws FileNotFoundException{
        File infile = new File("Maze1.txt");// can be a path"/full/path/to/file.txt"
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
    }

    public void solve(){
        for(int r = 0; r < maze.length; r++){
            for(int c = 0; c < maze[0].length; c++){
                if(maze[r][c] == 'S'){
                    startR = r;
                    startC = c;
                }
            }
        }
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

        boolean dW1, dW2, dW3, dW4;

        dW1 = solveH(row+1,col);
        dW2 = solveH(row, col+1);
        dW3 = solveH(row-1, col);
        dW4 = solveH(row, col-1);

        if(dW1 || dW2 || dW3 || dW4){
            maze[row][col] = '@';
        }

        return dW1 || dW2 || dW3 || dW4;
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
                toRet += maze[i][j];
            }
            toRet += "\n";
        }
        return toRet;
    }

    public static void main(String[] args) throws FileNotFoundException{
        MazeSolver test = new MazeSolver();

	test.setAnimate(true);

        test.solve();

	System.out.println(test);
    }


}
