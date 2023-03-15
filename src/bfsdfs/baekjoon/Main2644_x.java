package bfsdfs.baekjoon;

import java.io.*;

public class Main2644_x {
    static boolean [] visited;
    static int [][] map;
    static int n;
    static int a;
    static int b;
    static int result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        String [] input = br.readLine().split(" ");
        a = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);
        int m = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        map = new int[n+1][n+1];

        for(int i=0; i<m; i++){
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            map[x][y] = 1;
            map[y][x] = 1;
        }

        dfs(a,0);
        System.out.println(visited[b]?result:-1);
    }

    private static void dfs(int now, int count) {
        visited[now] = true;

        for(int i=1; i<=n; i++){
            if(!visited[i] && map[now][i]==1){
                visited[i]=true;

                if(i==b){
                    result = count+1;
                    return;
                }

                dfs(i, count+1);
            }
        }
    }
}
