import java.util.*;
public class FrontierPriorityQueue implements Frontier{
    //private MyHeap locations;
    private PriorityQueue<Location> locations;
    private int size;

    public FrontierPriorityQueue(){
        //locations = new MyHeap(false);
        locations = new PriorityQueue<Location>();
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
