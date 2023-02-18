package interface_form.Graph;

import java.util.ArrayList;

public class AdjacencyList {

    public static void main(String[] args) {
        int initSize = 5;
        AdjacencyList graph = new AdjacencyList(initSize);

        graph.put(1, 2, 1);
        graph.put(1, 4, 1);
        graph.put(2, 3, 1);
        graph.put(2, 5, 1);
        graph.put(4, 5, 1);

        graph.printGraph(1);
    }

    private ArrayList<ArrayList<Node>> graph;
    private int size;

    public AdjacencyList(int initSize){
        this.graph = new ArrayList<ArrayList<Node>>();
        this.size = initSize;
        for(int i=0; i<initSize+1; i++){
            this.graph.add(new ArrayList<Node>());
        }
    }

    public void put(int vertex_x, int vertex_y, int weight){
        this.graph.get(vertex_x).add(new Node(vertex_y, weight));
        this.graph.get(vertex_y).add(new Node(vertex_x, weight));
    }

    public void putSingle(int vertex_x, int vertex_y, int weight){
        this.graph.get(vertex_x).add(new Node(vertex_y, weight));
    }

    public ArrayList<ArrayList<Node>> getGraph(){
        return this.graph;
    }

    public ArrayList<Node> getVertex(int idx){
        return this.graph.get(idx);
    }

    public int getWeight(int vertex_x, int vertex_y){
        return this.graph.get(vertex_x).get(vertex_y).getWeight();
    }

    public void printGraph(int startIdx){
        StringBuilder sb = new StringBuilder();
        for(int i=startIdx; i<=this.size; i++){
            sb.append("정점 ").append(i).append("의 인접 정점 리스트");
            for (int j=0; j<this.graph.get(i).size(); j++){
                sb.append(" -> ").append(this.graph.get(i).get(j).getVertex());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static class Node{
        private int vertex;
        private int weight;

        public Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }

        public int getVertex(){
            return this.vertex;
        }

        public int getWeight(){
            return this.weight;
        }
    }
}
