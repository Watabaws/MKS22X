import java.util.*;

public class MyLinkedList implements Iterable<Integer>{
    private LNode start, end;
    private int size;
    private LNode current;

    public MyLinkedList(){
        start = null;
        size = 0;
    }

    public LLIterator iterator(){
        return new LLIterator(this);
    }

    public int size(){
        return size;
    }

    private LNode getNthNode(int n){
    	if(n < 0 || n >= size){
    	    throw new IndexOutOfBoundsException();
    	}
    	current = start;
    	while(n != 0){
    	    current = current.next;
            n--;
    	}
    	return current;
    }

    private void addAfter(LNode location, LNode toBeAdded){
        toBeAdded.next = location.next;
        location.next.prev = toBeAdded;
        location.next = toBeAdded;
        toBeAdded.prev = location;
    }

    private void remove(LNode target){
        if(target == start){
            start = start.next;
            start.prev = null;
        }
        else if(target == end){
            end = end.prev;
            end.next = null;
        }
        else{
            target.prev.next = target.next;
            target.next.prev = target.prev;
        }
    }

    public boolean add(int value){
    	if(size == 0){
    	    start = new LNode(value);
            end = start;
    	    size = 1;
    	    return true;
    	}
    	LNode tba = new LNode(value);
        end.next = tba;
        tba.prev = end;
        end = tba;
        tba.next = null;
    	return true;
    }

    public int get(int index){
    	return indexOf(getNthNode(index).value);
    }

    public int set(int index, int value){
    	int toRet = getNthNode(index).value;
    	getNthNode(index).value = value;
    	return toRet;
    }

    public int indexOf(int val){
    	if(val < size/2){
    	    current = start;
    	    int ctr = 0;
    	    while(current != null){
        		if(current.value == val){
        		    return ctr;
        		}
        		current = current.next;
        		ctr++;
    	    }
    	    return -1;
    	}
    	else{
    	    current = end;
    	    int ctr = 0;
    	    while(current != null){
        		if(current.value == val){
        		    return ctr;
        		}
        		current = current.prev;
        		ctr++;
    	    }
    	    return -1;
    	}
    }

    public int remove(int index){
        LNode weedle = getNthNode(index);
        int caterpie = weedle.value;
        remove(weedle);
        return caterpie;
    }

    public void add(int index, int value){
        LNode location = getNthNode(index);
        LNode tBA = new LNode(value);
        if(location == end){
            add(value);
        }
        else{
            addAfter(location, tBA);
        }
    }

    public String toString(){
        LNode current = start;
        //System.out.println("Started");
        String toRet = "[";
        if(size != 0){
            toRet += current.value;
            //System.out.println("Valued");
            while(current.next != null){
                current = current.next;
                toRet += ", " + current.value;
            }
        }
        toRet += "]";
        return toRet;
    }

    private String deBugToString(){
	String toRet = "";
	current = start;
	while(current != null){
	    toRet += current.toString();
	    current = current.next;
	}
	return toRet;

    }


    public static void main(String[] args){
    }

private class LNode{
    private int value;
    private LNode next;
    private LNode prev;

    public LNode(int val){
        next = null;
	prev = null;
        value = val;
    }

    public LNode(int val, LNode point, LNode noint){
        value = val;
        prev = point;
	next = noint;
    }

    public String toString(){
        return ("(" + prev.value + ")" + value + "(" + next.value + ")" + " ");
    }
}

private class LLIterator implements Iterator<Integer>{
    LNode curr;

    public LLIterator(MyLinkedList inp){
        curr = inp.start;
    }

    public Integer next(){
        if(hasNext()){
            int blah = curr.value;
            curr = curr.next;
            return blah;
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean hasNext(){
        return curr.next != null;
    }

    public void remove(){
        throw new UnsupportedOperationException();
    }
}
}
