package bfsdfs.baekjoon;

import java.io.*;

public class Main11724 {
    static int n ;
    static int m ;

    static int [][] map ;
    static boolean[] visited ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);

        map = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=m; i++){
            strs = br.readLine().split(" ");
            int x = Integer.parseInt(strs[0]);
            int y = Integer.parseInt(strs[1]);
            map[x][y] = 1;
            map[y][x] = 1;
        }
        int count = 0;
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                count += dfs(i);
            }
        }
        System.out.println(count);
    }

    private static int dfs(int root){
        visited[root] = true;
        for(int i=1; i<=n; i++){
            if(map[root][i]==1 && !visited[i]){
                dfs(i);
            }
        }
        return 1;
    }
}
