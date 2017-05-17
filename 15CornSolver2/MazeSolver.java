public class MazeSolver{
    private Maze board;
    private Frontier solva;
    private boolean star;

    public MazeSolver(String blah){
        board = new Maze(blah);
    }

    public void solve(){
        solva = new FrontierQueue();
    }

    public void solve(int method){
        star = false;

        switch(method){
            case 0: solva = new FrontierStack();
                    break;
            case 1: solva = new FrontierQueue();
                    break;
            case 2: solva = new FrontierPriorityQueue();
                    break;
            case 3: solva = new FrontierPriorityQueue();
                    star = true;
                    break;
        }

        Location start = board.start;

        Location firstStep = new Location(start.getRow(), start.getCol() )

        solva.add()



    }
}
