package bruteforce;

import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        System.out.println(Long.parseLong(input[0])+Long.parseLong(input[1])+Long.parseLong(input[2]));
    }
}