package Example;

import java.io.*;

public class Main10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int [] array = new int[n+1];

        for(int i=1; i<=n; i++){
            array[i]=i;
        }

        for(int i=0; i<m; i++){
            inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);

            int temp = array[x];
            array[x] = array[y];
            array[y] = temp;
        }

        for(int i=1; i<=n; i++){
            bw.write(array[i] + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
