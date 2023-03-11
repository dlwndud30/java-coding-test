package Example;

import java.io.*;

public class Main11659_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n= Integer.parseInt(input[0]);
        int m= Integer.parseInt(input[1]);

        int[] arr = new int[n+1];

        input = br.readLine().split(" ");

        arr[1] = Integer.parseInt(input[0]);

        for(int i=2; i<=n; i++){
            arr[i]= Integer.parseInt(input[i-1])+arr[i-1];
        }

        for(int i=0; i<m; i++){
            input = br.readLine().split(" ");
            int startN = Integer.parseInt(input[0]);
            int endN = Integer.parseInt(input[1]);

            int sum = 0;

            bw.write(arr[endN]-arr[startN-1] + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
