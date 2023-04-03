package materialization;

import java.io.*;

public class Main9017 {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            String[] inputs = br.readLine().split(" ");

            int [] counts = new int [201];
            int [] arr = new int [201];

            for(int j=0; j<k; j++){
                int index = Integer.parseInt(inputs[j]);

                if(counts[index]<4){
                    counts[index]++;
                    arr[index] += j+1;
                }
            }

            int min = Integer.MIN_VALUE;
            int min_idx = 0;
            for(int j=1; j<201; j++){
                if(arr[j]!=0 && counts[j]>=4){
                    min = Math.min(min, arr[j]);
                    min_idx = j;
                }
            }
            bw.write(min_idx + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
