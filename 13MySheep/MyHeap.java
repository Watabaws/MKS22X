import java.util.*;

public class MyHeap{
    private int Constant = 1;
    private int size;
    private ArrayList<String> sheep;

    public MyHeap(){
        size = 1;
        sheep = new ArrayList<String>();
    }

    public MyHeap(boolean huh){
        Constant = huh ? 1 : -1;
        size = 0;
        sheep = new ArrayList<String>();
    }

    public void add(String s){
        sheep.set(size++, s);
        doAPullUP(size);
    }

    public String remove(){
        sheep.set(1, sheep.get(size--));
        doAPushUpButStayDownSoItsNotReallyAPushup(1);
    }

    public String peek(){

    }

    private boolean actuallySortaUsefulCompareTo(String a, String b){
        return a.compareTo(b) >= 0;
    }

    private void doAPullUP(int index){
        if(actuallySortaUsefulCompareTo(sheep.get(index), sheep.get(index/2))){
            String old = sheep.get(index/2);
            sheep.set(index/2, sheep.get(index));
            sheep.set(index, old);
            doAPullUP(index/2);
        }
    }

    private void doAPushUpButStayDownSoItsNotReallyAPushup(int index){
        String chil1 = sheep.get(index * 2);
        String chil2 = sheep.get(index * 2 + 1);
        String mwa = sheep.get(index);

        if(mwa.compareTo(chil1) < 1 || mwa.compareTo(chil2) < 1){
                if(actuallySortaUsefulCompareTo(chil1, chil2)){
                    sheep.set(index, chil1);
                    sheep.set(index * 2, mwa);
                    doAPushUpButStayDownSoItsNotReallyAPushup(index * 2);
                }
                else{
                    sheep.set(index, chil2);
                    sheep.set(index * 2 + 1, mwa);
                    doAPushUpButStayDownSoItsNotReallyAPushup(index * 2 + 1);
                }
        }
    }
}
