package bfsdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DfsBfs_LinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfNodes = scanner.nextInt();
        int numberOfEdges = scanner.nextInt();
        int start = scanner.nextInt();
        Graph graph = new Graph(numberOfNodes);

        for(int i=0; i<numberOfEdges; i++){
            graph.addEdge(scanner.nextInt(), scanner.nextInt());
        }
        graph.dfs(start);
        graph.dfs_recursion(graph.nodes[start]);
        graph.bfs(start);
    }
    static class Graph{
        Node[] nodes;

        Graph(int size){
            this.nodes = new Node[size];
            for(int i=0; i<size; i++){
                this.nodes[i] = new Node(i);
            }
        }

        void addEdge(int i1, int i2){
            Node n1 = nodes[i1];
            Node n2 = nodes[i2];

            if(!n1.adjacent.contains(n2)){
                n1.adjacent.add(n2);
            }

            if(!n2.adjacent.contains(n1)){
                n2.adjacent.add(n1);
            }
        }

        public void dfs(int index){
            Node root = nodes[index];
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            root.marked=true;

            while (!stack.isEmpty()){
                Node parent = stack.pop();
                for(Node child : parent.adjacent){
                    if(!child.marked){
                        child.marked = true;
                        stack.push(child);
                    }
                }
                System.out.print(parent.data + " ");
            }
        }

        void dfs_recursion(Node root){
            root.marked = true;
            System.out.print(root.data +" ");
            for(Node n : root.adjacent){
                if(!n.marked){
                    dfs_recursion(n);
                }
            }
        }

        public void bfs(int index){
            Node root = nodes[index];
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            root.marked = true;

            while (!queue.isEmpty()){
                Node parent = queue.poll();
                for(Node child : parent.adjacent){
                    if(!child.marked){
                        child.marked=true;
                        queue.add(child);
                    }
                    System.out.print(parent.data+" ");
                }
            }
        }

        class Node{
            int data;
            LinkedList<Node> adjacent;
            boolean marked;

            Node(int data){
                this.data = data;
                this.adjacent = new LinkedList<Node>();
                this.marked=false;
            }
        }
    }
}
