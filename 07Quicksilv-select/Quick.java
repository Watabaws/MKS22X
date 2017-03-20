import java.util.*;

public class Quick{

    public static void quicksort(int[] arr){
        qsh(arr, 0, arr.length-1);
    }

    public static void qsh(int[] arr, int left, int right){
        System.out.println(Arrays.toString(arr));
        if(left < right){
            int p = part(arr, left, right);
            qsh(arr, left, p-1);
            qsh(arr, p, right);
        }
    }

    public static int quickselect(int[] data, int k){
        int ind = -1, start = 0, end = data.length-1;
        int[] tempData = new int[data.length];
        while(ind != k){
            tempData = Arrays.copyOf(data, data.length);
            ind = part(tempData, start, end);
        }
        return tempData[ind];
    }

    public static int part (int[] data, int start, int end){
        int[] temp = new int[end-start+1];

        int partAroundInd = (int)(Math.random() * (end-start));
        int partAround = data[partAroundInd + start];

        int startPart = start, endPart = end;

        System.out.println("The partaround is: " + partAround);
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
        temp[startPart] = partAround;
        for(int i = 0; i < temp.length; i++){
            data[i] = temp[i];
        }
        for(int i = 0; i < temp.length;i++){
            data[i] = temp[i];
        }
        return startPart;
    }

    public static void main(String[] args){
        //int[] test = new int[args.length-1];
        int[] test = new int[args.length];
        //int i;
        for(int i = 0; i < args.length; i++){
            test[i] = Integer.parseInt(args[i]);
        }
        quicksort(test);
        System.out.println(test);
        //System.out.println(quickselect(test,Integer.parseInt(args[i])));
    }
}
