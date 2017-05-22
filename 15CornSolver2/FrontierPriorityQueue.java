import java.util.*;
public class FrontierPriorityQueue implements Frontier{
    private MyHeap locations;
    private int size;

    public FrontierPriorityQueue(){
        locations = new MyHeap(false);
    }

    public void add(Location blah){
        size++;
        locations.add(blah);
    }

    public Location next(){
        size--;
        return locations.remove();
    }

    public int size(){
        return size;
    }

    public String toString(){
        return locations.toString();
    }
}
