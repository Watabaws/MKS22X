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
        //System.out.println(Arrays.toString(data));
        while(start < end){
            //System.out.println("Start is: " + start + " End is: " + end);
            ind = part(data, start, end, k);
            //System.out.println(Arrays.toString(data));
            if(ind < k){
                start = ind + 1;
            }
            else if (ind > k){
                end = ind - 1;
            }
            else return data[ind];
        }
        return data[start];
    }

    public static int part(int[] data, int start, int end, int k){
        int partAround = getPartValue(data, start, end);
        int partAroundVal = data[partAround];
        //System.out.println("The partaround is: " + partAroundVal);
        int i = start;
        int gt = end;
        int lt = start;
        //System.out.println(partAroundVal);
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
        if(data[k] == data[gt]){
            return k;
        }
        return gt;
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


    public static int[] testList(int type){
        int lenList = (int)(Math.random() * 20000 + 100000);
        int[] toRet = new int[lenList];
        if(type == 0){
            for(int i = 0; i < lenList; i++){
                boolean isNeg = (int)(Math.random() * 2) % 2 == 0;
                int num = (int)(Math.random() * Integer.MAX_VALUE);
                if(isNeg){
                    num *= -1;
                }
                toRet[i] = num;
            }
        }
        else if(type == 1){
            for(int i = 0; i < lenList; i++){
                toRet[i] = (int)(Math.random() * 10);
            }
        }
        else if(type == 2){
            int num = (int)(Math.random() * Integer.MAX_VALUE);
            for(int i = 0; i < lenList; i++){
                toRet[i] = num;
            }
        }
        else if(type == 3){
            int[] srtd = testList(0);
            Arrays.sort(srtd);
            toRet = srtd;
        }
        else{
            Integer[] revsrtd = new Integer[lenList];
            for(int i = 0; i < lenList; i++){
                revsrtd[i] = (int)(Math.random() * Integer.MAX_VALUE);
            }
            Arrays.sort(revsrtd, Collections.reverseOrder());
            for(int i = 0; i < lenList; i++){
                toRet[i] = revsrtd[i];
            }
        }

        return toRet;

    }

    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("Please add a number to the end of java Merge to generate a list to be sorted. 0 will provide a completely randomized list, 1 will provide a random list with numbers ranging in value from 1 - 10, 2 will provide a list of the same number n times, 3 will provide a sorted list and anything else will provide a reverse sorted list. If you want to test each type of list 20 times, use this bash script: for i in {1..4}; do for j in {1..20}; do java Quick $i; done; done;");
        }
        else{
            int[] tbSrt = testList(Integer.parseInt(args[0]));
            int[] srtd = new int[tbSrt.length];
            System.arraycopy(tbSrt, 0, srtd, 0, tbSrt.length);
            Arrays.sort(srtd);
            //quicksort(tbSrt);
            //System.out.println(Arrays.toString(tbSrt));
            //System.out.println(Arrays.toString(srtd));
            int k = (int)(Math.random() * tbSrt.length);
            //System.out.println(Arrays.equals(srtd, tbSrt));
            System.out.println(srtd[k] == quickselect(tbSrt, k));
        }

        //System.out.println(quickselect(new int[]{1, 5, 4, 7, 2, 3, 9, 6, 8}, 1));

    }
}
