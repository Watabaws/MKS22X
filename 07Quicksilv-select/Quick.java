import java.util.*;

public class Quick{

    public static void quicksort(int[] arr){
        qsh(arr, 0, arr.length-1);
    }

    public static void qsh(int[] arr, int left, int right){
        System.out.println(Arrays.toString(arr));
        if(left < right){
            System.out.println("Left is: " + left);
            System.out.println("Right is: " + right);
            int p = part(arr, left, right);
            qsh(arr, left, p-1);
            qsh(arr, p+1, right);
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

        /*int partAroundInd1 = (int)(Math.random() * (end-start));
        int partAroundInd2 = (int)(Math.random() * (end-start));
        int partAroundInd3 = (int)(Math.random() * (end-start));

        int[] values = new int[]{partAroundInd1, partAroundInd2, partAroundInd3};
        for(int i: values){
            if(i != Math.MAX(values) && i != Math.MIN(values)){
                int partAroundInd = i;

            }
        }*/

        int partAroundInd = (int)(Math.random() * (end-start) + start);
        int partAround = data[partAroundInd];



        int startPart = 0, endPart = end-start;
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
        for(int i = 0; i < temp.length;i++){
            data[i+start] = temp[i];
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
        System.out.println(Arrays.toString(test));
        //System.out.println(quickselect(test,Integer.parseInt(args[i])));
    }
}
