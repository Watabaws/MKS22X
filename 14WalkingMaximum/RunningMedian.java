public class RunningMedian{
    MyHeap maks, meen;
    int median, maxSize;

    public RunningMedian(){
        maks = new MyHeap(true);
        meen = new MyHeap(false);
        maxSize = 0;
    }

    public void add(int chewAd){
        if(maks.size != 0 && meen.size != 0){
            System.out.println(maks.sheep);
            System.out.println(meen.sheep);
            if(chewAd < meen.peek()){
                maks.add(chewAd);
            }
            else{
                meen.add(chewAd);
            }
        }
        else{
            if(maks.size == 0){
                maks.add(chewAd);
            }
            else{
                meen.add(chewAd);
            }
        }
        balance();
        updateSize();
    }

    public Integer getMedian(){
        if(maxSize % 2 == 0){
            return (maks.peek() + meen.peek()) / 2;
        }
        else{
            if(maks.size > meen.size){
                return maks.peek();
            }
            else{
                return meen.peek();
            }
        }
    }

    private void balance(){
        if(Math.abs(maks.size - meen.size) > 1){
            System.out.println("before balance: ");
            System.out.println(maks.sheep);
            System.out.println(meen.sheep);
            if(maks.size > meen.size){
                int topMaks = maks.remove();
                meen.add(topMaks);
            }
            else{
                int topMeen = meen.remove();
                System.out.println("tm is: " + topMeen);
                maks.add(topMeen);
            }
            System.out.println("after balance: ");
            System.out.println(maks.sheep);
            System.out.println(meen.sheep);
        }

    }

    private void updateSize(){
        maxSize = maks.size + meen.size;
    }

    public static void main(String[] args){
        RunningMedian test = new RunningMedian();
        int[] testnum = {0, 2, 5, 6, 7, 234, 342, 12, 567, 40, 25, 189, 9};
        for(int i : testnum){
        System.out.println(test.maks);
        System.out.println(test.meen);
            test.add(i);
            System.out.println("");
        }
        System.out.println(test.getMedian());
    }
}
