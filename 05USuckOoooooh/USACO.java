import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class USACO{
    private int row, col, elev, numStomps;
    private int[][] pasture, moves;

    public USACO(){}

    public int bronze(String filename){
        Scanner inf;
        try{
            inf = new Scanner(new File(filename));
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
                //printTwoDAr(pasture);
            }
            moves = new int[numStomps][3];
            for(int i = 0; inf.hasNextLine(); i++){
                moves[i][0] = inf.nextInt();
                moves[i][1] = inf.nextInt();
                moves[i][2] = inf.nextInt();
                inf.nextLine();
                //printTwoDAr(moves);
            }

            for(int[] ya: moves){
                int raow = ya[0] - 1;
                int caol = ya[1] - 1;
                int depf = ya[2];

                int lowestDepth = findMax(raow, caol) - depf;

                for(int r = raow; r < raow + 3 && r < row; r++){
                    for(int c = caol; c < caol + 3 && c < col; c++){
                        if(pasture[r][c] > lowestDepth){
                            pasture[r][c] = lowestDepth;
                        }
                    }
                }
            }
            //printTwoDAr(pasture);

            return calculateVol() * 5184;
        }
        catch(FileNotFoundException e){
            return 1;
        }

    }

    private int findMax(int trow, int tcol){
        int curMax = 0;
        for(int r = trow; r < trow + 3 && r < row; r++){
            for(int c = tcol; c < tcol + 3 && c < col; c++){
                if(pasture[r][c] > curMax){
                    curMax = pasture[r][c];
                }
            }
        }
        return curMax;
    }
    public int calculateVol(){
        int total = 0;
        for (int r = 0; r < pasture.length; r++){
            for (int c = 0; c < pasture[0].length; c++){
                if (pasture[r][c] >= elev){
                    pasture[r][c] = 0;
                }else{
                    pasture[r][c] = elev - pasture[r][c];
                }
                total += pasture[r][c];
            }
        }
        return total;
    }

    private void printTwoDAr(int[][] toPrint){
        String toRet = "";
        for(int r = 0; r < toPrint.length;r++){
            for(int c = 0; c < toPrint[r].length; c++){
                toRet += toPrint[r][c] + " ";
            }
            toRet += "\n";
        }
        System.out.println(toRet);
    }

    public static void main(String[] args){
        USACO x = new USACO();

        System.out.println(x.bronze(args[0]));
    }
}
