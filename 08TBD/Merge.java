import java.util.Arrays;

public class Merge{

    public static void mergesort(int[] arr){
        int[] sorted = mergeSortH(arr);
        System.out.println(Arrays.toString(sorted));
        System.out.println(Arrays.toString(arr));
        for(int i = 0; i < sorted.length;i++){
            arr[i] = sorted[i];
        }
    }

    public static int[] mergeSortH(int[] arr){
        System.out.println("Currarr is: " + Arrays.toString(arr));
        if(arr.length == 1){
            return arr;
        }


        int[] leftHalf = partitArray(arr, 0, arr.length/2 - 1   );
        int[] rightHalf = partitArray(arr, arr.length - (arr.length/2 + 1) , arr.length - 1 );
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

    public static void main(String[] args){
        /*int[] testmerge1 = new int[args.length/2], testmerge2 = new int[args.length - args.length/2];
        for(int i = 0; i < args.length/2; i++){
            testmerge1[i] = Integer.parseInt(args[i]);
        }
        for(int i = args.length/2; i < args.length; i++){
            testmerge2[i - args.length/2] = Integer.parseInt(args[i]);
        }

        Arrays.sort(testmerge1);
        Arrays.sort(testmerge2);

        int[] merged = merge(testmerge1, testmerge2);

        System.out.println(Arrays.toString(merged));*/

        int[] test = new int[args.length];
        for(int i = 0; i < args.length; i++){
            test[i] = Integer.parseInt(args[i]);
        }

        /*System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(partitArray(test, 0, test.length/2 - 1)));
        System.out.println(Arrays.toString(partitArray(test, test.length - test.length/2, test.length - 1)));*/

        System.out.println("");
        mergesort(test);

    //    System.out.println(Arrays.toString(test));
    //    System.out.println(args.length);
    //    System.out.println(test.length);
    }
}
