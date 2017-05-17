import java.util.*;

public class MazeSolver{
    private Maze board;
    private Frontier frontear;
    private boolean star;
    private boolean finishded;

    public MazeSolver(String blah){
        board = new Maze(blah);
    }

    public void solve(){
        frontear = new FrontierQueue();
    }

    public void solve(int method){
        finishded = false;
        star = false;

        switch(method){
            case 0: frontear = new FrontierStack();
                    break;
            case 1: frontear = new FrontierQueue();
                    break;
            case 2: frontear = new FrontierPriorityQueue();
                    break;
            case 3: frontear = new FrontierPriorityQueue();
                    star = true;
                    break;
        }

        Location startLoc = board.getStart();
        Location endLoc = board.getEnd();
        Coordinate start = new Coordinate(startLoc.getRow(), startLoc.getCol());
        Coordinate end = new Coordinate(endLoc.getRow(), endLoc.getCol());

        ArrayList<Location> neighbors = getNeighbors(startLoc, start, end);
        do{
            for(Location dadaradun: neighbors){
                frontear.add(dadaradun);
            }
            Location lumberjack = frontear.next();
            if(lumberjack.equals(endLoc)){
                finishHim(lumberjack);
            }
            else{
                board.set(lumberjack.getRow(), lumberjack.getCol(), '.');
            }
        }
        while(!finishded && frontear.size() > 0);
    }

    private void finishHim(Location end){
        board.set(end.getRow(), end.getCol(), 'E');
        while(end.previous != null){
            end = end.previous;
            board.set(end.getRow(), end.getCol(), '@');
        }
        finishded = true;
    }

    private ArrayList<Location> getNeighbors(Location neigh2get, Coordinate start, Coordinate end){
        ArrayList<Location> toret = new ArrayList<Location>();

        int nowRow = neigh2get.getRow();
        int nowCol = neigh2get.getCol();

        char top = board.get(nowRow - 1, nowCol);
        char bottom = board.get(nowRow + 1, nowCol);
        char left = board.get(nowRow, nowCol - 1);
        char right = board.get(nowRow, nowCol + 1);

        if(top == ' '){
            toret.add(new Location(nowRow - 1, nowCol, neigh2get, dist(start, new Coordinate(nowRow - 1, nowCol)), dist(end, new Coordinate(nowRow - 1, nowCol)), star));
        }
        if(bottom == ' '){
            toret.add(new Location(nowRow + 1, nowCol, neigh2get, dist(start, new Coordinate(nowRow + 1, nowCol)), dist(end, new Coordinate(nowRow + 1, nowCol)), star));
        }
        if(left == ' '){
            toret.add(new Location(nowRow, nowCol - 1, neigh2get, dist(start, new Coordinate(nowRow, nowCol - 1)), dist(end, new Coordinate(nowRow, nowCol - 1)), star));
        }
        if(right == ' '){
            toret.add(new Location(nowRow, nowCol + 1, neigh2get, dist(start, new Coordinate(nowRow, nowCol + 1)), dist(end, new Coordinate(nowRow, nowCol + 1)), star));
        }
        return toret;
    }

    public int dist(Coordinate a, Coordinate b){
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}
