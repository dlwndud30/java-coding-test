package materialization;

import java.io.*;
import java.util.Arrays;

public class Main2979 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] input = br.readLine().split(" ");
        int one = Integer.parseInt(input[0]);
        int two = Integer.parseInt(input[1]);
        int three = Integer.parseInt(input[2]);

        int length = 0;
        int [] arr = new int[length];

        for(int i=0; i<3; i++){
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            if(length<end+1){
                length=end+1;
                arr = Arrays.copyOf(arr, length);
            }

            for(int t=start; t<end; t++){
                arr[t]=arr[t]+1;
            }
        }


        int money = 0;
        for(int i=1; i<arr.length; i++){
            if(arr[i]==1){
                money+=one;
            }else if(arr[i]==2){
                money+=two*2;
            } else if (arr[i] == 3) {
                money+=three*3;
            }

        }
        System.out.println(money);
    }
}
