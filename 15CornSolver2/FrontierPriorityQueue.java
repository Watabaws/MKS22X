import java.util.*;
public class FrontierPriorityQueue implements Frontier{
    private MyHeap locations;
    private int size;

    public FrontierPriorityQueue(){
        locations = new MyHeap();
    }

    public void add(Location blah){
        locations.add(blah);
        size++;
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
