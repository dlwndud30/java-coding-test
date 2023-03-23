package bfsdfs.baekjoon;

import java.io.*;

public class Main10552 {
    static int n ;
    static int m ;
    static int count;

    static int [][] map ;
    static boolean[] visited ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        int root = Integer.parseInt(inputs[2]);
        map = new int[m+1][m+1];
        visited = new boolean[m+1];

        for(int i=1; i<=n; i++){
            inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);

            map[y][x] = 1;
        }
        dfs(root);
        System.out.println(count==m?-1:count);
    }

    private static void dfs(int root){

        for (int i = 1; i <= m; i++) {
            if(!visited[i] && map[root][i]==1){
                visited[i] = true;
                count++;
                dfs(i);
                break;
            }
        }
    }
}
