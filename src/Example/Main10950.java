package Example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            System.out.println(Integer.parseInt(input[0])+Integer.parseInt(input[1]));
        }
    }
}
