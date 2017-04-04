public class MyLinkedList{
    private LNode start, end;
    private int size;
    private LNode current;

    public MyLinkedList(){
        start = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    private LNode getNthNode(int n){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	current = start;
	while(n != 0){
	    current = current.next;
	}
	return current;
    }

    private void addAfter(LNode location, LNode toBeAdded){
	
    }

    private void remove(LNode target){
	if(target == start){
	    
	    
	target.prev.next = target.next;
	target.next.prev = target.prev;
	//ByeBye.
    }

    public boolean add(int value){
	if(size == 0){
	    start = new LNode(value);
	    size = 1;
	    return true;
	}
	addAfter(end, new LNode(value));
	return true;
    }

    public int get(int index){
	return indexOf(getNthNode(index));
    }

    public int set(int index, int value){
	int toRet = getNthNode(index).value;
	getNthNode(index).value = value;
	return toRet;
    }

    public int indexOf(int val){
	if(value < size/2){
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
        remove(getNthNode(index));
    }
    
    public void add(int index, int value){

    }
 
    public boolean add(int tba){
        current = start;
        if(size == 0){
            start = new LNode(tba);
            size = 1;
            return true;
        }
        size++;
        while(current.next != null){
            current = current.next;
        }
        current.next = new LNode(tba);
        return true;
    }

    public int get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        current = start;
        while(index != 0){
            current = current.next;
            index--;
        }
        return current.value;
    }

    public int set(int index, int newValue){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        current = start;
        while(index != 0){
            current = current.next;
            index--;
        }
        int oldVal = current.value;
        current.value = newValue;
        return oldVal;
    }

    public int indexOf(int val){
        current = start;
        int ctr = 0;
        while(current.next != null){
            current = current.next;
            if(current.value == val){
                return ctr;
            }
            ctr++;
        }
        if(current.value == val){
            return ctr;
        }
        return -1;
    }

    public boolean add(int index, int value){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        size++;
        if(index == 0){
            return addBeginning(value);
        }
        current = start;
        for(int i = 0; i < index - 1; i++){
            current = current.next;
        }
        LNode toBeAdded = new LNode(value, current,  current.next);
        current.next = toBeAdded;
        return true;
    }

    public int remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        //System.out.println(size);
        if(size == 1){
            int valyu = start.value;
            start = null;
            size = 0;
            return valyu;
        }
        if(index == 0){
            //System.out.println("ADGDSGSDGSDHSD");
            int valyu = start.value;
            start = start.next;
            size--;
            return valyu;
        }
        current = start;
        for(int i = 0; i < index-1; i++){
            current = current.next;
        }
        LNode bobbitybooped = current.next;
        int value = bobbitybooped.value;
        current.next = bobbitybooped.next;
        //And now bobbitybooped gets boobity booped.
        size--;
        return value;

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
        MyLinkedList test = new MyLinkedList();
        System.out.println(test);

        for(int i = 0; i < 10; i++){
            test.add(i);
            System.out.println(test.size);
            System.out.println(test);
        }

        System.out.println(test);


        for(int i = 0; i < 10; i++){
            System.out.println(test.set(i, i + 15));
        }

        System.out.println(test);

        for(int i = 0; i < 10; i++){
            test.remove(0);
            //System.out.println("Removed");
            System.out.println(test);
            System.out.println("");
        }
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
}
