import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MazeSolver{
    char[][] maze;

    public MazeSolver() throws FileNotFoundException{
        File infile = new File("Maze1.txt");// can be a path"/full/path/to/file.txt"
        Scanner inf = new Scanner(infile);
        int lineNumber = 1;
        String line = "";
        while(inf.hasNextLine()){
            line += inf.nextLine() + "/n";
            lineNumber++;
        }

        inf = new Scanner(infile);

        int lineLen = inf.nextLine().length();
        maze = new char[lineNumber][lineLen];

        for(int i = 0; i < lineNumber; i++){
            maze[i] = line.substring(0, lineLen).toCharArray();
            line = line.substring(lineLen++);
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        MazeSolver test = new MazeSolver();
    }


}
