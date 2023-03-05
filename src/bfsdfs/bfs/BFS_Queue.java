package bfsdfs.bfs;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Queue {
    public static void main(String[] args) {
        boolean [] visited = new boolean[9];
        int [][] graph={{},
                {2,3,8},
                {1,7},
                {1,4,5},
                {3,5},
                {3,4},
                {7},
                {2,6,8},
                {1,7}
        };
        int start = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        visited[start] = true;

        while (!queue.isEmpty()){
            int v = queue.poll();
            System.out.print(v + " ");
            for (int i : graph[v]){
                if(visited[i] == false){
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }
    }
}
