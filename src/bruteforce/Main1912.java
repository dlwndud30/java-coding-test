package bruteforce;

import java.io.*;

public class Main1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String [] inputs = br.readLine().split(" ");
        int [] nums = new int[n];
        int [] sums = new int[n];

        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(inputs[i]);
        }

        int max = nums[0];
        sums[0] = nums[0];

        for(int i=1; i<n; i++){
            sums[i] = Math.max(sums[i-1] + nums[i], nums[i]);
            max = Math.max(max, sums[i]);
        }

        bw.write(max + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
