public class RunningMedian{
    MyHeap maks, meen;
    int median, maxSize;

    public RunningMedian(){
        maks = new MyHeap(true);
        meen = new MyHeap(false);
    }

    public void add(int chewAd){
        if(chewAd < meen.peek()){
            maks.add(chewAd);
        }
        else{
            meen.add(chewAd);
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
            if(maks.size > meen.size){
                meen.add(maks.remove());
            }
            else{
                maks.add(meen.remove());
            }
        }
    }

    private void updateSize(){
        maxSize = maks.size + meen.size;
    }
}
