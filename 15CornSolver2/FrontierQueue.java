import java.util.*;
public class FrontierQueue implements Frontier{
    private LinkedList<Location> locations;
    private int size;

    public FrontierQueue(){
        locations = new LinkedList<Location>();
        size = 0;
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
}
