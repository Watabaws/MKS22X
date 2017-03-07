import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class makelake{
    private int row, col, elev, numStomps;
    private int[][] pasture, moves;

    public makelake(){
        Scanner inf;
        try{
            inf = new Scanner(new File("makelake.in"));
        }
        catch(FileNotFoundException e){
            return;
        }
        row = inf.nextInt();
        col = inf.nextInt();
        elev = inf.nextInt();
        numStomps = inf.nextInt();
        inf.nextLine();
        int counter = 0;
        pasture = new int[row][col];
        while (counter < row){
            String line = inf.nextLine();
            //System.out.println(test);
            String[] temp = line.split(" ");
            //System.out.println(Arrays.toString(temp));
            for (int i = 0; i < temp.length; i++){
                pasture[counter][i] = Integer.parseInt(temp[i]);
            }
            counter++;
            printTwoDAr(pasture);
        }
        moves = new int[numStomps][3];
        for(int i = 0; inf.hasNextLine(); i++){
            moves[i][0] = inf.nextInt();
            moves[i][1] = inf.nextInt();
            moves[i][2] = inf.nextInt();
            inf.nextLine();
            printTwoDAr(moves);
        }
    }

    private void printTwoDAr(int[][] toPrint){
        String toRet = "";
        for(int r = 0; r < toPrint.length;r++){
            for(int c = 0; c < toPrint[r].length; c++){
                toRet += toPrint[r][c] + ", ";
            }
            toRet += "\n";
        }
        System.out.println(toRet);
    }

    public static void main(String[] args){
        makelake test = new makelake();
    }
}
