public Location implements Comparable<Location>{
    int row, col;
    Location previous;
    int distanceToStart;
    int distanceToGoal;
    boolean aStar;

    public Location(int r, int c , Location previous, int startDist, int goalDist){
	row = r;
	col = c;
	this.previous = previous;
	distanceToStart = startDist;
	distanceToGoal = goalDist;
    }

    public Location(int r, int c , Location previous, int startDist, int goalDist, boolean AyStur){
	row = r;
	col = c;
	this.previous = previous;
	distanceToStart = startDist;
	distanceToGoal = goalDist;
	aStar = AyStur;
    }
    

    public int CompareTo(Location other){
	if(aStar){
	    return (other.distanceToStart + other.distanceToGoal) - (distanceToStart + distanceToGoal);
	}
	else{
	    return other.distanceToGoal - distanceToGoal;
	}
    }

