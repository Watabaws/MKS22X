import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class USACO{
    private int row, col, elev, numStomps, time, R1, R2, C1, C2;
    private int[][] pasture, moves;
    private int[][][] pastur;

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

    public int silver(String filename){
        Scanner inf = null;
        try{
            inf = new Scanner(new File(filename));
        }
        catch(FileNotFoundException e){
            System.exit(0);
        }
        row = inf.nextInt();
        col = inf.nextInt();
        time = inf.nextInt();
        inf.nextLine();
        pastur = new int[row][col][2];
        for(int i = 0; i < row; i++){
            int[] valus = converCI(inf.nextLine().toCharArray());
            for(int j = 0; j < valus.length; j++){
                pastur[i][j] = new int[]{valus[j], valus[j]};
            }
        }
        R1 = inf.nextInt() - 1;
        C1 = inf.nextInt() - 1;
        R2 = inf.nextInt() - 1;
        C2 = inf.nextInt() - 1;
        //printThreeDAr(pastur);
        return calcPaths(R1, C1, R2, C2);
    }

    private int calcPaths(int startRow, int startCol, int endRow, int endCol){
        pastur[startRow][startCol] = new int[]{1,1};
        while(time > 0){
            for(int r = 0; r < pastur.length; r++){
                for(int c = 0; c < pastur[r].length; c++){
                    if(pastur[r][c][0] != -1){
                        pastur[r][c][1] = 0;
                        try{
                            if(pastur[r+1][c][0] != -1){
                                pastur[r][c][1] += pastur[r+1][c][0];
                            }
                        }
                        catch(IndexOutOfBoundsException e){}
                        try{
                            if(pastur[r-1][c][0] != -1){
                                pastur[r][c][1] += pastur[r-1][c][0];
                            }
                        }
                        catch(IndexOutOfBoundsException e){}
                        try{
                            if(pastur[r][c+1][0] != -1){
                                pastur[r][c][1] += pastur[r][c+1][0];
                            }
                        }
                        catch(IndexOutOfBoundsException e){}
                        try{
                            if(pastur[r][c-1][0] != -1){
                                pastur[r][c][1] += pastur[r][c-1][0];
                            }
                        }
                        catch(IndexOutOfBoundsException e){}
                    }
                }
            }
            for(int r = 0; r < pastur.length; r++){
                for(int c = 0; c < pastur[r].length; c++){
                    pastur[r][c][0] = pastur[r][c][1];
                }
            }
            //printThreeDAr(pastur);
            //System.out.println("");
            time--;
        }

        return pastur[endRow][endCol][0];
    }


    private static int[] converCI(char[] toConv){
        int[] toRet = new int[toConv.length];
        for(int i = 0; i < toConv.length; i++){
            if(toConv[i] == '.'){
                toRet[i] = 0;
            }
            if(toConv[i] == '*'){
                toRet[i] = -1;
            }
        }
        return toRet;
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

    private void printThreeDAr(int[][][] toPrint){
        String toRet = "";
        for(int r = 0; r < toPrint.length; r++){
            for(int c = 0; c < toPrint[r].length; c++){
                for(int z = 0; z < toPrint[r][c].length; z++){
                    toRet += toPrint[r][c][z];
                    toRet += " ";
                }
                toRet += "   ";
            }
            toRet += "\n";
        }
        System.out.println(toRet);
    }

    public static void main(String[] args){
        USACO x = new USACO();

        System.out.println(x.silver(args[0]));
        //System.out.println(x.bronze(args[0]));
    }
}
