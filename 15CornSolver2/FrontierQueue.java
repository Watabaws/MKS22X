import java.util.*;
public class FrontierQueue implements Frontier{
    private LinkedList<Location> locations;

    public FrontierQueue(){
        locations = new LinkedList<Location>();
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
