public QueueFrontier{
    Queue<Location> locations;


    public void add(Location blah){
	locations.enqueue(blah);
    }

    public Location next(){
	locations.dequeue(blah);
    }

}
