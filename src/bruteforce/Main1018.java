package bruteforce;

import java.io.*;

public class Main1018 {
    static char[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        map = new char[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
            }
        }

        int min = getRepaintCount(0,0);
        for (int i=0; i<=N-8; i++){
            for(int j=0; j<=M-8; j++){
                min=Math.min(min, getRepaintCount(i,j));
            }
        }

        System.out.println(min);

    }

    static int getRepaintCount(int x, int y){
        int count = 0;
        for(int i=x; i<x+8; i++){
            for (int j=y; j<y+8; j++){
                if(i%2==0){
                    if(j%2==0){
                        if(map[i][j]!='W'){
                            count++;
                        }
                    }else{
                        if(map[i][j]!='B'){
                            count++;
                        }
                    }
                }else {
                    if(j%2==0){
                        if(map[i][j]!='B'){
                            count++;
                        }
                    }else{
                        if(map[i][j]!='W'){
                            count++;
                        }
                    }
                }
            }
        }

        return Math.min(64-count, count);
    }
}
