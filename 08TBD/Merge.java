import java.util.Arrays;
import java.util.Collections;

public class Merge{

    public static void mergesort(int[] arr){
        int[] sorted = mergeSortH(arr);
        //System.out.println(Arrays.toString(sorted));
        //System.out.println(Arrays.toString(arr));
        for(int i = 0; i < arr.length;i++){
            arr[i] = sorted[i];
        }
    }

    public static int[] mergeSortH(int[] arr){
        //System.out.println("Currarr is: " + Arrays.toString(arr));
        if(arr.length == 1){
            return arr;
        }


        int[] leftHalf = partitArray(arr, 0, arr.length/2 - 1);
        int lowBou = arr.length - arr.length/2;
        if(arr.length % 2 == 1){
            lowBou--;
        }
        int[] rightHalf = partitArray(arr, lowBou, arr.length - 1 );
        //System.out.println("Left is: " + Arrays.toString(leftHalf));
        //System.out.println("Right is: " + Arrays.toString(rightHalf));

        return merge(mergeSortH(leftHalf), mergeSortH(rightHalf));

    }

    private static int[] partitArray(int[]arr, int start, int end){
        int[] toRet = new int[end - start + 1];
        for(int i = start; i <= end; i++){
            toRet[i-start] = arr[i];
        }
        return toRet;
    }

    private static int[] merge(int[] first, int[] sec){
        //System.out.println(Arrays.toString(first));
        //System.out.println(Arrays.toString(sec));
        //System.out.println("first" + Arrays.toString(first));
        //System.out.println("sec" + Arrays.toString(sec));
        int ctr1 = 0, ctr2 = 0, ctr = 0;
        int[] tBR = new int[first.length + sec.length];

        while(ctr1 < first.length && ctr2 < sec.length){
            if(first[ctr1] < sec[ctr2]){
                tBR[ctr] = first[ctr1];
                ctr1++;
            }
            else{
                tBR[ctr] = sec[ctr2];
                ctr2++;
            }
            ctr++;
        }

        //System.out.println(Arrays.toString(tBR));
        if(ctr2 < sec.length){
            for(;ctr2 < sec.length;ctr2++,ctr++){
                tBR[ctr] = sec[ctr2];
            }
        }
        else{
            for(;ctr1 < first.length;ctr1++,ctr++){
                //System.out.println(ctr);
                //System.out.println(ctr1);
                tBR[ctr] = first[ctr1];
            }
        }

        //System.out.println(Arrays.toString(tBR));
        return tBR;

    }


    private static int[] unSortedMerge(int[] first, int[] second){
        int[] retoyn = new int[first.length + second.length];

        int ctr = 0;
        for(int i = 0; i< first.length;i++, ctr++){
            retoyn[ctr] = first[i];
        }
        for(int i = 0; i < second.length;i++, ctr++){
            retoyn[ctr] = second[i];
        }

        return retoyn;
    }

    public static int[] testList(int type){
        int lenList = (int)(Math.random() * 20000 + 1000000);
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
            System.out.println("Please add a number to the end of java Merge to generate a list to be sorted. 0 will provide a completely randomized list, 1 will provide a random list with numbers ranging in value from 1 - 10, 2 will provide a list of the same number n times, 3 will provide a sorted list and anything else will provide a reverse sorted list. If you want to test each type of list 20 times, use this bash script: for i in {1..4}; do for j in {1..20}; do java Merge $i; done; echo ""; done;");
        }
        else{
            int[] tbSrt = testList(Integer.parseInt(args[0]));
            int[] srtd = new int[tbSrt.length];
            System.arraycopy(tbSrt, 0, srtd, 0, tbSrt.length);
            Arrays.sort(srtd);
            mergesort(tbSrt);
            //System.out.println(Arrays.toString(tbSrt));
            //System.out.println(Arrays.toString(srtd));
            System.out.println(Arrays.equals(srtd, tbSrt));
        }

    }
}
