import java.util.*;

public class Quick{

    public static void quicksort(int[] arr){
        qsh(arr, 0, arr.length-1);
    }

    public static void qsh(int[] data, int left, int right){
        //System.out.println("");
        //System.out.println("Left is: " + left + " and Right is: " + right);
        if(left < right){
            int partAround = getPartValue(data, left, right);
            int partAroundVal = data[partAround];
            //System.out.println("The partaround is: " + partAroundVal);
            int i = left;
            int gt = right;
            int lt = left;
            while(i <= gt){
                if(data[i] == partAroundVal){
                    i++;
                }
                else if (data[i] > partAroundVal){
                    swap(data, i, gt);
                    gt--;
                }
                else{
                    swap(data, i, lt);
                    lt++;
                    i++;
                }
            }
        //System.out.println(Arrays.toString(data));
        qsh(data, left, lt);
        qsh(data, i, right);
    }
    }

    public static int quickselect(int[] data, int k){
        int ind = -1, start = 0, end = data.length-1;
        int[] tempData = new int[data.length];
        while(ind != k){
            ind = part(tempData, start, end);
            if(ind < k){
                start = ind;
            }
            else{
                end = ind;
            }
        }
        return tempData[ind];
    }

    private static void swap(int[] arr, int ind1, int ind2){
        int temp = arr[ind2];
        arr[ind2] = arr[ind1];
        arr[ind1] = temp;
    }

    private static int getPartValue(int[] arr, int start, int end){
        int[] randVals = new int[3];
        for(int i = 0; i < 3; i++){
            randVals[i] = (int)(Math.random() * (end - start)) + start;
        }
        //System.out.println(Arrays.toString(arr));
        //System.out.println(Arrays.toString(randVals));
        int a = arr[randVals[0]], b = arr[randVals[1]], c = arr[randVals[2]];
        if(c != findMedian(a, b, c)){
            return randVals[b == findMedian(a, b, c) ? 1:0];
        }
        else{
            return randVals[2];
        }
    }

    private static int findMedian(int a, int b, int c){
        return Math.max(Math.min(a, b), Math.min(Math.max(a, b), c));
    }

    public static int part(int[] data, int start, int end){
        int partAround = getPartValue(data, start, end);
        int partAroundVal = data[partAround];
        //System.out.println("The partaround is: " + partAroundVal);
        int i = start;
        int gt = end;
        int lt = start;
        while(i <= gt){
            if(data[i] == partAroundVal){
                i++;
            }
            else if (data[i] > partAroundVal){
                swap(data, i, gt);
                gt--;
            }
            else{
                swap(data, i, lt);
                lt++;
                i++;
            }
        }
        //System.out.println(Arrays.toString(data));
        return gt;
    }

    public static void main(String[] args){
        //int[] test = new int[args.length-1];
        int[] test = new int[args.length];
        for(int i = 0; i < args.length; i++){
            test[i] = Integer.parseInt(args[i]);
        }
        //System.out.println(part(test, 1, 7));
        /*int[] test = new int[20001];
        for(int i = 0; i < 20000;i++){
            test[i] = (int)(Math.random() * 9000);
        }
        int[] c2 = test.clone();
        quicksort(test);
        Arrays.sort(c2);
        System.out.println(Arrays.equals(test, c2));*/
        System.out.println(Arrays.toString(test));
    }
}
