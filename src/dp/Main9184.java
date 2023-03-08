package dp;

import java.io.*;

public class Main9184 {
    static int [][][] dp = new int[21][21][21];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            String [] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            if(a==-1 && b==-1 && c==-1){
                break;
            }

            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + method(a,b,c));

        }
    }
    public static int method(int a, int b, int c){
        if(0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20 && dp[a][b][c]!=0){
            return dp[a][b][c];
        }
        if(a<=0 || b<=0 || c <=0){
            return 1;
        }
        if (a>20 || b> 20|| c>20) {
            return dp[20][20][20] = method(20, 20, 20);
        }
        if(a<b && b<c){
            return dp[a][b][c] = method(a, b, c-1) + method(a, b-1, c-1) -method(a, b-1, c);
        }

        return dp[a][b][c] = method(a-1, b, c) + method(a-1, b-1, c) +method(a-1, b, c-1) -method(a-1, b-1, c-1);
    }
}
