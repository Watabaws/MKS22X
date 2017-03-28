public class MyLinkedList{
    private LNode start;
    private int size;


    public MyLinkedList(){
        start = new LNode();
        size = 1;
    }

    public int size(){
        return size;
    }

    private boolean addBeginning(LNode tba){
        tba.next = start;
        start = tba;
        size++;
        return true;
    }

    public boolean add(int tba){
        current = start;
        while(current.next != void){
            current = current.next;
        }
        current.next = new LNode(tba);
    }

    public int get(int index){
        current = start;
        while(index == 0){
            current = current.next;
            index--;
        }
        return current.value;
    }

    public int set(int index, int newValue){
        current = start;
        while(index == 0){
            current = current.next;
            index--;
        }
        int oldVal = current.value;
        current.value = newValue;
        return oldVal;
    }

    public int indexOf(int val){
        current = start;
        ctr = 0;
        while(current.value != val){
            current = current.next;
            ctr++;
        }
        return ctr;
    }

    public boolean add(int index, int value){
        current = start;
        for(int i = 0; i < index - 1; i++){
            current = current.next;
        }

    }


    public String toString(){
        LNode current = start;
        String toRet = "[";
        toRet += current.value;
        current = current.next;
        while(current.next != null){
            toRet += ", " + current.value;
            current = current.next;
        }
        return toRet;
    }

private class LNode{
    private int value;
    private LNode next;

    public LNode(){
        value = 0;
        next = null;
    }

    public LNode(int val){
        value = val;
    }

    public LNode(int val, LNode point){
        value = val;
        next = point;
    }
}

}
