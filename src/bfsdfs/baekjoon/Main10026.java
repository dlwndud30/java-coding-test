package bfsdfs.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String map [][] = new String[n][n];
        for(int i=0; i<n; i++){
            String string = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = String.valueOf(string.charAt(j));
            }
        }

    }
}
