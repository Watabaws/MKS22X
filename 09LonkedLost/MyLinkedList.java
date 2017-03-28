public class MyLinkedList{
    private LNode start;
    private int size;

    public MyLinkedList(){
        start = new LNode();
        size = 1;
    }

    private void add(LNode tba){
        tba.next = start;
        start = tba;
        size++;
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
