package interface_form.Graph;

public class ArrGraph {
    private int[][] graph;

    public ArrGraph(int initSize){
        this.graph = new int[initSize+1][initSize+1];
    }

    public int[][] getGraph(){
        return this.graph;
    }

    public void put(int x, int y){
        graph[x][y] = graph[y][x] = 1;
    }

    public void putSingle(int x, int y){
        graph[x][y] = 1;
    }

    public void printGraphToAdjArr(){
        for(int i=1; i<graph.length; i++){
            for(int j=1; j<graph[i].length; j++){
                System.out.print(" " +graph[i][j]);
            }
            System.out.println();
        }
    }
}
