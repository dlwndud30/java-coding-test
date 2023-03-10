package bfsdfs.baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main1260 {
    static int n;
    static int m;
    static int v;

    static int map[][];
    static boolean[] visited;

    static Stack<Integer> stack = new Stack<>();
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] input = br.readLine().split(" ");
        n=Integer.parseInt(input[0]);
        m=Integer.parseInt(input[1]);
        v=Integer.parseInt(input[2]);

        visited= new boolean[n+1];
        map = new int[n+1][n+1];

        for(int i=1; i<=m; i++){
            String [] input2 = br.readLine().split(" ");
            int x = Integer.parseInt(input2[0]);
            int y = Integer.parseInt(input2[1]);

            map[x][y]=1;
            map[y][x]=1;
        }

        dfs(v);
        System.out.println();

        visited= new boolean[n+1];
        bfs(v);
    }

    private static void bfs(int v) {
        visited[v] = true;
        queue.add(v);

        while (!queue.isEmpty()){
            int num = queue.poll();
            System.out.print(num + " ");

            for(int i=1; i<=n; i++){
                if(!visited[i] && map[num][i]==1){
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }
    }

    private static void dfs(int v) {
        visited[v]=true;
        System.out.print(v + " ");
        for(int i=1; i<=n; i++){
            if(!visited[i] && map[v][i]==1){
                dfs(i);
            }
        }
    }

    private static void stackDfs(int v){
        stack.push(v);
        visited[v]=true;

        while (!stack.isEmpty()){
            int num = stack.pop();
            System.out.print(num+" ");

            for(int i=1; i<=n; i++){
                if(!visited[i] && map[num][i]==1){
                    stack.push(i);
                    visited[i]=true;
                    break;
                }
            }
        }
    }


}
