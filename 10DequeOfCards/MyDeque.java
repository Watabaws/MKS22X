import java.util.NoSuchElementException;

public class MyDeque{
    String[] Dequerray;
    int front, back, size;

    public MyDeque(){
        Dequerray = new String[0];
        front = 0;
        back = 0;
        size = 0;
    }

    private void resizeArray(){
        String[] temp = new String[size * 2 + 1];

        int ind = front;
        int ctr = 0;
        while(ind != back){
            temp[ctr] = Dequerray[ind];
            ind = (ind + 1) % size;
            ctr++;
        }
        temp[ctr] = Dequerray[ind];
        front = 0;
        back = ctr;
        Dequerray = temp;
    }

    public String getFirst(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        return Dequerray[front];
    }

    public String getLast(){
        if(size == 0){
            throw new NoSuchElementException();
        }
	       return Dequerray[back];
    }

    public void addFirst(String bleh){
    	if(bleh == null){
    	    throw new NullPointerException();
    	}

        if(Dequerray.length != 0){
            int potNF = (front - 1) % Dequerray.length;
            if(potNF < 0){
                potNF = Dequerray.length + potNF;
            }

            if(potNF == back){
                resizeArray();
                addFirst(bleh);
            }
            Dequerray[potNF] = bleh;
            front = potNF;
        }
        else{
            Dequerray = new String[]{bleh};
        }
        size++;
    }

    public void addLast(String bleh){
        if(bleh == null){
    	    throw new NullPointerException();
    	}
        if(Dequerray.length != 0){
            int potNE = (back + 1) % Dequerray.length;

            if(potNE == front){
                resizeArray();
                Dequerray[back + 1] = bleh;
                size++;
            }
            else{
                Dequerray[potNE] = bleh;
                back = potNE;
                size++;
            }
        }
        else{
            Dequerray = new String[]{bleh};
            size = 1;
        }
    }

    public void stringit(){
        String toret = "[";
        for(int i = 0; i < size; i++){
            toret += Dequerray[i];
        }
        toret += "]";
        System.out.println(toret);
    }

    public String removeFirst(){
        if(size == 0){
            throw new NoSuchElementException();
        }

        int potNFI = (front + 1) % Dequerray.length;

        String olval = Dequerray[front];
        front = potNFI;
        size--;
        return olval;
    }

    public String removeLast(){
        if(size == 0){
            throw new NoSuchElementException();
        }

        int potNEI = (back - 1) % Dequerray.length;
        if(potNEI < 0){
            potNEI = Dequerray.length - potNEI;
        }

        String olval = Dequerray[back];
        back = potNEI;
        size--;
        return olval;
    }

    public static void main(String[] args){
        MyDeque test = new MyDeque();

        for(int i = 0; i < 5; i++){
            test.addLast(i + "");
        }


        for(int i = 0; i < 5; i++){
            test.getFirst();
            test.removeFirst();
        }

    }
}
