import java.util.*;

public class FrontierStack implements Frontier{
    private Stack<Location> locations;
    private int size;

    public FrontierStack(){
        locations = new Stack<Location>();
        size = 0;
    }

    public void add(Location blah){
        locations.push(blah);
        size++;
    }

    public Location next(){
        size--;
        return locations.pop();
    }

    public int size(){
        return size;
    }
}
