import java.util.*;

public class MyHeap{
    private int Constant = 1;
    private int size;
    private ArrayList<String> sheep;

    public MyHeap(){
        size = 0;
        sheep = new ArrayList<String>();
	sheep.add("");
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
	if(size > 1){
	    doAPullUP(size);
	}
    }

    public String remove(){
	String oldval = sheep.get(1);
        sheep.set(1, sheep.get(size--));
        doAPushUpButStayDownSoItsNotReallyAPushup(1);
	return oldval;
    }

    public String peek(){
	return sheep.get(0);
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

    public String toString(){
	String toret = "";
	int looptru = (int)Math.ceil((Math.log(size) / Math.log(2)));
	while(looptru != 0){
	    String tempret = "";
	    for(int i = looptru; i > 0; i--){
		tempret += "/t";
	    }
	    for(int i = (int) Math.pow(2, looptru - 1); i < Math.pow(2, looptru); i++){
		tempret += sheep.get(i) + " ";
	    }
	    toret = tempret + toret;
	}
	return toret;
    }

    public String toStringForNoobs(){	
	String toret = "  ";
	for(int i = 97; i <= 97 + 26; i++){
	    toret += i + " ";
	}
	toret += "\n";
	for(String topr : sheep){
	    if(topr != null){
		toret += topr + " ";
	    }
	}
	return toret;
    }


    public static void main(String[] args){
	MyHeap test = new MyHeap();
	for(int i = 0; i < 32; i++){
	    test.add("" + i);
	}
	System.out.println(test);
	System.out.println(test.toStringForNoobs());
    }
	
}
