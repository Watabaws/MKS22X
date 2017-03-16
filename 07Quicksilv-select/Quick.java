import java.util.*;

public class Quick{

    public static int quickselect(int[] data, int k){
        int ind = -1, start = 0, end = data.length-1;
        int[][] aRay;
        while(ind != k){
            //System.out.println("");
            //System.out.println("Start is: " + start + " End is: " + end);
            aRay = part(data, start, end);
            ind = aRay[0][0];
            if(ind > k){
                end = ind;
            }
            if(ind < k){
                start = ind;
            }
            data = aRay[1];
        }
        return data[ind];
    }

    public static int[][] part (int[] data, int start, int end){
        int[] temp = new int[end-start];

        int partAroundInd = (int)(Math.random() * (end-start));
        int partAround = data[partAroundInd + start];

        int startPart = 0, endPart = temp.length-1;

        for(int i = start; i < end; i++){
            if(i != partAroundInd){
                if(data[i] < partAround){
                    temp[startPart] = data[i];
                    startPart++;
                }
                else{
                    temp[endPart] = data[i];
                    endPart--;
                }
            }
        }
        System.out.println(partAround);
        temp[startPart] = partAround;
        data = temp;
        //data[startPart] = partAround;
        //System.out.println(Arrays.toString(temp));
        return new int[][]{{startPart}, temp};
    }

    public static void main(String[] args){
        int[] test = new int[args.length-1];
        int i;
        for(i = 0; i < args.length - 1; i++){
            test[i] = Integer.parseInt(args[i]);
        }
        System.out.println(Arrays.toString(test));
        //part(test, 0, test.length);
        //System.out.println(Arrays.toString(test));

        System.out.println(quickselect(test,Integer.parseInt(args[i])));
    }
}
