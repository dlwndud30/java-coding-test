package bfsdfs.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10026 {
    static int n;
    static String map [][];
    static boolean [][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new String[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            String string = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = String.valueOf(string.charAt(j));
            }
        }

        int count =0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    count += dfs(i, j);
                }
            }
        }
        System.out.print(count +" ");

        count =0;
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    count += dfs_red(i, j);
                }
            }
        }
        System.out.println(count);

    }

    private static int dfs(int x, int y) {
        int [] add_x ={-1, 0, 1, 0};
        int [] add_y ={0, 1, 0, -1};

        visited[x][y]=true;
        String str = map[x][y];

        for(int i=0; i<4; i++){
            int xx=x+add_x[i];
            int yy=y+add_y[i];

            if(xx>=0 && xx<n && yy>=0 && yy<n){
                if(map[xx][yy].equals(str) && !visited[xx][yy]){
                    dfs(xx,yy);
                }
            }
        }

        return 1;
    }

    private static int dfs_red(int x, int y) {
        int [] add_x ={-1, 0, 1, 0};
        int [] add_y ={0, 1, 0, -1};

        visited[x][y]=true;
        String str = map[x][y];
        Boolean red = map[x][y].equals("B")?false:true;

            for(int i=0; i<4; i++) {
                int xx = x + add_x[i];
                int yy = y + add_y[i];

                if (xx >= 0 && xx < n && yy >= 0 && yy < n) {
                    if(red){
                        if (!map[xx][yy].equals("B") && !visited[xx][yy]) {
                            dfs_red(xx, yy);
                        }
                    }else {
                        if (map[xx][yy].equals(str) && !visited[xx][yy]) {
                            dfs_red(xx, yy);
                        }
                    }
                }
            }
        return 1;
    }
}
