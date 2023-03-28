package materialization;

import java.io.*;

public class Main2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i=0; i<3; i++){
            String [] inputs = br.readLine().split(" ");
            int count_0 = 0;
            for(int j=0; j<4; j++){
                if(inputs[j].equals("0")){
                    count_0++;
                }
            }
            switch (count_0){
                case 0:
                    bw.write("E\n");
                    break;
                case 1:
                    bw.write("A\n");
                    break;
                case 2:
                    bw.write("B\n");
                    break;
                case 3:
                    bw.write("C\n");
                    break;
                case 4:
                    bw.write("D\n");
                    break;
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
