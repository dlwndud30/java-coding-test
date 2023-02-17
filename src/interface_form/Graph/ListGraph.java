package interface_form.Graph;

import java.util.ArrayList;

public class ListGraph {
    private ArrayList<ArrayList<Integer>> graph;

    public ListGraph(int initSize){
        this.graph = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<initSize+1; i++){
            graph.add(new ArrayList<Integer>());
        }
    }

    public ArrayList<ArrayList<Integer>> getGraph(){
        return this.graph;
    }

    public ArrayList<Integer> getNode(int i){
        return graph.get(i);
    }

    public void put(int x, int y){
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    public void putSingle(int x, int y){
        graph.get(x).add(y);
    }

    public void printGraphToAdjList(){
        for(int i=1; i<graph.size(); i++){
            System.out.print("정점 " + i + "의 인접리스트");
            for(int j=0; j<graph.get(i).size(); j++){
                System.out.print(" -> " + graph.get(i).get(j));
            }
            System.out.println();
        }
    }
}
