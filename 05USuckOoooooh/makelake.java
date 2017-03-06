import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class makelake{
    private int row, col, elev, numStomps;
    private int[][] pasture;
    private int[] moves;

    public makelake(){
        Scanner inf = new Scanner(new File(makelake.in));
        row = inf.nextInt();
        col = inf.nextInt();
        elev = inf.nextInt();
        inf.nextLine();
        numStomps = inf.nextInt();
        int counter = 0;
        pasture = new int[row][col];
        while (counter < row){
            String[] temp = inf.nextLine().split(" ");
            for (int i = 0; i < temp.length; i++){
                pasture[counter][i] = (int)temp[i];
            }
            counter++;
        }
        moves = int[numStomps][3];
        for(int i = 0; inf.hasNextLine(); i++){
            moves[i][0] = inf.nextInt();
            moves[i][1] = inf.nextInt();
            moves[i][2] = inf.nextInt();
            inf.nextLine();
        }
        makeLake
    }
}
