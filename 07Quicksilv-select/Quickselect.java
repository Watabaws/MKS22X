import java.util.*;

public class Quickselect{

    public static int part (int[] data, int start, int end){
        int[] temp = new int[end-start];

        int partAroundInd = (int)(Math.random() * end);
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
        System.out.println(Arrays.toString(temp));
        return startPart;
    }

    public static void main(String[] args){
        int[] test = new int[args.length];
        for(int i = 0; i < args.length; i++){
            test[i] = Integer.parseInt(args[i]);
        }


        System.out.println(part(test, 0, test.length));
    }
}
