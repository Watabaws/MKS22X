import java.util.*;

public class Quick{

    public static int quickselect(int[] data, int k){
        int ind = -1, start = 0, end = data.length-1;
        int[] tempData = new int[data.length];
        while(ind != k){
            //System.out.println("");
            //System.out.println("Start is: " + start + " End is: " + end);
            tempData = Arrays.copyOf(data, data.length);
            //System.out.println("1" + Arrays.toString(tempData));
            ind = part(tempData, start, end);
            //System.out.println(2 + Arrays.toString(tempData));
            //System.out.println();
            /*if(ind > k){
                end = ind;
            }
            if(ind < k){
                start = ind;
            }*/
        }
        return tempData[ind];
    }

    public static int part (int[] data, int start, int end){
        int[] temp = new int[end-start+1];

        int partAroundInd = (int)(Math.random() * (end-start));
        int partAround = data[partAroundInd + start];

        int startPart = 0, endPart = temp.length-1;

        for(int i = start; i <= end; i++){
            if(i != partAroundInd){
                if(data[i] > partAround){
                    temp[endPart] = data[i];
                    endPart--;
                }
                else{
                    temp[startPart] = data[i];
                    startPart++;
                }
            }
        }
        //System.out.println("The partaround is: " + partAround);
        temp[startPart] = partAround;
        for(int i = 0; i < temp.length; i++){
            data[i] = temp[i];
        }
        for(int i = 0; i < temp.length;i++){
            data[i] = temp[i];
        }
        //System.out.println(Arrays.toString(data));
        return startPart;
    }

    public static void main(String[] args){
        int[] test = new int[args.length-1];
        int i;
        for(i = 0; i < args.length - 1; i++){
            test[i] = Integer.parseInt(args[i]);
        }
        //System.out.println(Arrays.toString(test));
        //System.out.println("");
        //part(test, 0, test.length);
        //System.out.println("");
        //System.out.println(Arrays.toString(test));

        System.out.println(quickselect(test,Integer.parseInt(args[i])));
    }
}
