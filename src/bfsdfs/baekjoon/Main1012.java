package bfsdfs.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1012 {
    static int m, n;
    static int [][] map;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            String[] strings = br.readLine().split(" ");
            m = Integer.parseInt(strings[0]);
            n = Integer.parseInt(strings[1]);
            int k = Integer.parseInt(strings[2]);

            count =0;

            map = new int[n][m];
            for(int j=0; j<k; j++){
                strings = br.readLine().split(" ");
                int x = Integer.parseInt(strings[0]);
                int y = Integer.parseInt(strings[1]);
                map[y][x]=1;
            }

            for(int a=0; a<n; a++){
                for(int b=0; b<m; b++){
                    System.out.print(map[a][b]);
                }
                System.out.println();
            }

            dfs(0);
            System.out.println(count);
        }
    }

    private static void dfs(int now) {
        for(int i=0; i<n; i++){
            if(map[now][i]==1){
                dfs(i);
            }else {
                count++;
                return;
            }
        }
    }
}
