package bfsdfs.baekjoon;

import java.io.*;

public class Main1012 {
    static int m, n;
    static int [][] map;
    static int [][] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            String[] strings = br.readLine().split(" ");
            m = Integer.parseInt(strings[0]);
            n = Integer.parseInt(strings[1]);
            int k = Integer.parseInt(strings[2]);

            count =0;

            map = new int[n][m];
            visited = new int[n][m];

            for(int j=0; j<k; j++){
                strings = br.readLine().split(" ");
                int x = Integer.parseInt(strings[0]);
                int y = Integer.parseInt(strings[1]);
                map[y][x]=1;
            }

            for(int x=0; x<n; x++){
                for(int y=0; y<m; y++){
                    if(map[x][y]==1 && visited[x][y]==0){
                        count += dfs(x,y);
                    }
                }
            }
            bw.write(count+"\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static int dfs(int x, int y) {
        int [] add_x ={-1, 0, 1, 0};
        int [] add_y ={0, 1, 0, -1};

        visited[x][y] = 1;

        for(int i=0; i<4; i++){
            int xx = x+add_x[i];
            int yy = y+add_y[i];
            if(xx>=0 && xx<n && yy>=0 && yy<m){
                if(map[xx][yy]==1 && visited[xx][yy]==0){
                    dfs(xx,yy);
                }
            }
        }
        return 1;
    }
}
