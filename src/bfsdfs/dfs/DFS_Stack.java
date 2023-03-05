package bfsdfs.dfs;

import java.util.Deque;
import java.util.LinkedList;

public class DFS_Stack {
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
        dfs(graph, 1, visited);

    }
    static void dfs (int [][] graph, int start, boolean [] visited){
        visited[start]=true;
        System.out.print(start + " ");

        Deque<Integer> stack = new LinkedList<>();
        stack.push(start);

        while (!stack.isEmpty()){
            int now = stack.peek();
            boolean hasNearNode = false;
            for(int i : graph[now]){
                if(!visited[i]){
                    hasNearNode=true;
                    stack.push(i);
                    visited[i]=true;
                    System.out.print(i+" ");
                    break;
                }
            }
            if(hasNearNode==false){
                stack.pop();
            }
        }
    }
}
