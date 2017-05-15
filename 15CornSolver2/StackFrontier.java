public class StackFrontier{
    Stack<Location> locations;


    public void add(Location blah){
	locations.push(blah);
    }

    public Location next(){
	locations.pop();
    }


}
