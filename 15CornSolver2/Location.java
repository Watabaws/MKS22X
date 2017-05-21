public class Location implements Comparable<Location>{
    private int row, col;
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

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public int compareTo(Location other){
        if(aStar){
            return (other.distanceToStart + other.distanceToGoal) - (distanceToStart + distanceToGoal);
        }
        else{
            return other.distanceToGoal - distanceToGoal;
        }
    }

    public String toString(){
        return "[" + row + ", " + col + "]";
    }

    public boolean equals(Location other){
        return (getRow() == other.getRow()) && (getCol() == other.getCol());
    }
}
