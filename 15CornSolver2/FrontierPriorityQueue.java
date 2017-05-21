import java.util.*;
public class FrontierPriorityQueue implements Frontier{
    private MyHeap locations;
    private int size;

    public FrontierPriorityQueue(){
        locations = new MyHeap();
    }

    public void add(Location blah){
        locations.add(blah);
    }

    public Location next(){
        return locations.remove();
    }

    public int size(){
        return locations.size();
    }

    public String toString(){
        return locations.toString();
    }
}
