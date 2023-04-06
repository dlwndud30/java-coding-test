package Example;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<10; i++){
            int num = Integer.parseInt(br.readLine());
            int rest = num%42;
            set.add(rest);
        }

        bw.write(set.size() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
