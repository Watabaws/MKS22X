import java.util.*;

public class MyHeap{
    private int Constant = 1;
    private int size;
    private ArrayList<String> sheep;

    public MyHeap(){
        size = 0;
        sheep = new ArrayList<String>();
        sheep.add(null);
    }

    public MyHeap(boolean huh){
        Constant = huh ? 1 : -1;
        size = 0;
        sheep = new ArrayList<String>();
        sheep.add(null);
    }

    public void add(String s){
        sheep.add(s);
        size++;
        doAPullUP(size);
    }

    public String remove(){
        String oldval = sheep.get(1);
        sheep.set(1, sheep.get(size));
        size-=1;
        doAPushUpButStayDownSoItsNotReallyAPushup(1);
        return oldval;
    }

    public String peek(){
        return sheep.get(1);
    }

    private boolean actuallySortaUsefulCompareTo(String a, String b){
        return (a.compareTo(b) * Constant) >= 0;
    }

    private void doAPullUP(int index){
        if(index != 1 && actuallySortaUsefulCompareTo(sheep.get(index), sheep.get(index/2))){
            String old = sheep.get(index/2);
            sheep.set(index/2, sheep.get(index));
            sheep.set(index, old);
            index /= 2;
        }
    }

    private void doAPushUpButStayDownSoItsNotReallyAPushup(int index){
        if(index * 2 <= size){
            String mwa = sheep.get(index);
            String chil1 = sheep.get(index * 2);
            if(index * 2 + 1 <= size){
                String chil2 = sheep.get(index * 2 + 1);
                if(actuallySortaUsefulCompareTo(chil2, chil1)){
                    if(actuallySortaUsefulCompareTo(chil2, mwa)){
                        sheep.set(index * 2 + 1, mwa);
                        sheep.set(index, chil2);
                        doAPushUpButStayDownSoItsNotReallyAPushup(index * 2 + 1);
                    }
                    else if(actuallySortaUsefulCompareTo(chil1, mwa)){
                        sheep.set(index * 2, mwa);
                        sheep.set(index, chil1);
                        doAPushUpButStayDownSoItsNotReallyAPushup(index * 2);
                    }
                }
            }
            else if(actuallySortaUsefulCompareTo(chil1, mwa)){
                sheep.set(index * 2, mwa);
                sheep.set(index, chil1);
                doAPushUpButStayDownSoItsNotReallyAPushup(index * 2);
            }

        }

    }

    public String toStringAttemptFailure(){
        String toret = "";
        int looptru = (int)Math.ceil((Math.log(size) / Math.log(2)));
        int og = looptru;
        int row = 1;
        while(looptru != 0){
            String tempret = "";
            for(int i = looptru; i <= og; i++){
                tempret += "   ";
            }
            for(int i = (int) Math.pow(2, row-1); i < Math.pow(2, row); i++){
                tempret +=  "    " + sheep.get(i);
            }
            tempret += "\n";
            toret += tempret ;
            looptru--;
            row++;
        }
        return toret;
    }

    public String toString(){
        String toret = "  ";
        for(int i = 0; i < size; i++){
            String topr = sheep.get(i+1);
            if(topr != null){
                toret += topr + " ";
            }
        }
        return toret;
    }


    public static void main(String[] args){
        //Thanks Inbar\\
	    MyHeap h = new MyHeap();
        String[] test = {"i","f","g","h","c","a","b","d","e"};\

        for (String s : test) {
            h.add(s);
            System.out.println(h);
	}
    System.out.println(" ");
	for (String s : test) {
	    h.remove();
	    System.out.println(h);
        System.out.println("");
    }
    }

}
