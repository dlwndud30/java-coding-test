package bruteforce;

import java.io.*;

public class Main2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Number[] numbers = new Number[n];

        for(int i=0; i<n; i++){
            String[] inputs = br.readLine().split(" ");
            Number number = new Number(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]));
            numbers[i] = number;
        }

        int count = 0;

        for(int i=123; i<=987; i++){
            String a = Integer.toString(i);
            boolean allTrue = true;

            if(a.charAt(0)==a.charAt(1) || a.charAt(1)==a.charAt(2) || a.charAt(0)==a.charAt(2)){
                continue;
            }
            if(a.charAt(0)=='0' || a.charAt(1)=='0' || a.charAt(2)=='0'){
                continue;
            }

            for(int j =0; j<n; j++){
                Number current = numbers[j];
                String b = Integer.toString(current.num);

                int sCount = 0;
                int bCount = 0;

                for(int k=0; k<3; k++){
                    if(a.charAt(k) == b.charAt(k)){
                        sCount++;
                    }
                }

                for(int k=0; k<3; k++){
                    for(int l=0; l<3; l++){
                        if(k!=l && a.charAt(k)==b.charAt(l)){
                            bCount++;
                        }
                    }
                }

                if(sCount !=current.strike || bCount != current.ball){
                    allTrue = false;
                }
            }
            if(allTrue){
                count++;
            }
        }
        bw.write(count +"\n");

        br.close();
        bw.flush();
        bw.close();

    }
    private static class Number{
        int num;
        int strike;
        int ball;

        public Number(int num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }

}
