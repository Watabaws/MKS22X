import java.util.*;

public class MyHeap{
    private int Constant = 1;
    public int size;
    private ArrayList<Integer> sheep;

    public MyHeap(){
        size = 0;
        sheep = new ArrayList<Integer>();
        sheep.add(0);
    }

    public MyHeap(boolean huh){
        Constant = huh ? 1 : -1;
        size = 0;
        sheep = new ArrayList<Integer>();
        sheep.add(null);
    }

    public void add(Integer s){
        sheep.add(s);
        size++;
        if(size > 1){
            doAPullUP(size);
        }
    }

    public Integer remove(){
        Integer oldval = sheep.get(1);
        sheep.set(1, sheep.get(size--));
        doAPushUpButStayDownSoItsNotReallyAPushup(1);
        return oldval;
    }

    public Integer peek(){
        return sheep.get(0);
    }

    private boolean actuallySortaUsefulCompareTo(Integer a, Integer b){
        return a.compareTo(b) * Constant >= 0;
    }

    private void doAPullUP(int index){
        while(index != 1 && actuallySortaUsefulCompareTo(sheep.get(index), sheep.get(index/2))){
            Integer old = sheep.get(index/2);
            sheep.set(index/2, sheep.get(index));
            sheep.set(index, old);
            index /= 2;
        }
    }

    private void doAPushUpButStayDownSoItsNotReallyAPushup(int index){
        Integer mwa = sheep.get(index);
        System.out.println("Size" + size);
        if(index * 2 <= size){
            Integer chil1 = sheep.get(index * 2);
            if(index * 2 + 1 <= size){
                Integer chil2 = sheep.get(index * 2 + 1);
                if(actuallySortaUsefulCompareTo(chil1, chil2)){
                    shwitch(index, index * 2);
                    doAPushUpButStayDownSoItsNotReallyAPushup(index * 2);
                }
                else{
                    shwitch(index, index * 2 + 1);
                    doAPushUpButStayDownSoItsNotReallyAPushup(index * 2 + 1);
                }
            }
            if(actuallySortaUsefulCompareTo(chil1, mwa)){
                shwitch(index * 2, index);
            }
        }
    }

    private void shwitch(int in, int ol){
        Integer old = sheep.get(ol);
        sheep.set(in, sheep.get(ol));
        sheep.set(ol, old);
    }

    public String toString(){
        String toret = "";
        int looptru = (int)Math.ceil((Math.log(size) / Math.log(2)));
        int og = looptru;
        int row = 0;
        while(looptru != 0){
            row++;
            String tempret = "";
            for(int i = looptru; i <= og; i++){
                tempret += "   ";
            }
            for(int i = (int) Math.pow(2, looptru - 1); i < Math.pow(2, looptru); i++){
                tempret += sheep.get(i) + "    ";
            }
            tempret += "\n";
            toret = tempret + toret;
            looptru--;
        }
        return toret;
    }

    public String loserToString(){
        String toret = "  ";
        for(int i = 0; i < size; i++){
            Integer topr = sheep.get(i+1);
            if(topr != null){
                toret += topr + " ";
            }
        }
        return toret;
    }

}
