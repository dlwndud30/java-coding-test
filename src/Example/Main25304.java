package Example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i=0; i<N; i++){
            String[] arr = br.readLine().split(" ");
            sum += (Integer.parseInt(arr[0]) * Integer.parseInt(arr[1]));
        }
        System.out.println(sum==X?"Yes":"No");
    }
}
