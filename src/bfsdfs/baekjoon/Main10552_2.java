package bfsdfs.baekjoon;

import java.io.*;

public class Main10552_2 {
    static int n ;
    static int m ;
    static int count;

    static int [] map ;
    static boolean[] visited ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        int root = Integer.parseInt(inputs[2]);
        map = new int[m+1];
        visited = new boolean[m+1];

        for(int i=1; i<=n; i++){
            inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            if(map[y]==0){
                map[y] = x;
            }
        }
        dfs(root);
        System.out.println(count);
    }

    private static void dfs(int root){
        int like = map[root];
        if (visited[root]){
            count = -1;
            return;
        }
        if(!visited[root] && like!=0){
            visited[root] = true;
            count++;
            dfs(like);
        }
    }
}
