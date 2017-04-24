import java.util.NoSuchElementException;

public class testDeque{
    String[] Dequerray;
    int front, back, size;

    public testDeque(){
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

    public String pull(){
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

    public void push(String bleh){
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
                push(bleh);
            }
            Dequerray[potNF] = bleh;
            front = potNF;
        }
        else{
            Dequerray = new String[]{bleh};
            size = 1;
        }
        size++;
    }

    public void addLast(String bleh){
        if(bleh == null){
    	    throw new NullPointerException();
    	}

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
        testDeque test = new testDeque();

        for(int i = 0; i < 5; i++){
            test.push(i + "");
        }


        for(int i = 0; i < 5; i++){
            test.removeFirst();
        }
    }
}
