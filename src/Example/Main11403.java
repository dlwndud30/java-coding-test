package Example;

import java.io.*;

public class Main11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int [][] map = new int[n][n];

        for(int i=0; i<n; i++){
            String [] strings = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j]=Integer.parseInt(strings[j]);
            }
        }
    }
}
