package materialization;

import java.io.*;

public class Main10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String [] inputs = br.readLine().split(" ");
            int [] arr = new int[20];

            int count = 0;
            for(int j=1; j<=20; j++){
                int num = Integer.parseInt(inputs[j]);
                arr[j-1]=num;
                for(int k=j-1; k>=1; k--){
                    if(arr[k]<arr[k-1]){
                        count++;
                        int temp = arr[k];
                        arr[k]=arr[k-1];
                        arr[k-1]=temp;
                    }
                }
            }
            bw.write(inputs[0]+" " + count+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
