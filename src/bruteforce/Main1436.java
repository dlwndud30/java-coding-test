package bruteforce;

import java.io.*;
import java.util.*;

public class Main1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num =666;
        int count666 = 1;

        while(count666 != n){
            num++;
            if(String.valueOf(num).contains("666")){
                count666++;
            }
        }
        System.out.println(num);
    }
}
