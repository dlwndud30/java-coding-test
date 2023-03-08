package dp;

import java.io.*;

public class Main9184 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a=0,b=0,c=0;

        int [][][] dp = new int[21][21][21];

        for(int i=0; i<=20; i++){
            for(int j=0; j<=20; j++){
                for(int k=0; k<=20; k++){
                    if(i ==0 || j ==0 || k ==0){
                        dp[i][j][k]=1;
                        continue;
                    }
                    if(i==1){
                        dp[i][j][k]=2;
                    }else{
                        if(i<j && j<k){
                            dp[i][j][k] = dp[i][j][k-1] + dp[i][j-1][k-1]-dp[i][j-1][k];
                            continue;
                        }
                        dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-1][k] + dp[i-1][j][k-1] -dp[i-1][j-1][k-1];
                    }
                }
            }
        }
        while (true){
            String [] input = br.readLine().split(" ");
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            c = Integer.parseInt(input[2]);

            if(a==-1 && b==-1 && c==-1){
                break;
            }
            if(a<=-1 || b<=-1 ||c<=-1){
                System.out.println("w(" + a + ", " + b + ", " + c + ") = " + 1);
            }
            else if (a>20 || b> 20|| c>20) {
                System.out.println("w(" + a + ", " + b + ", " + c + ") = " + dp[20][20][20]);
            }else {
                System.out.println("w(" + a + ", " + b + ", " + c + ") = " + dp[a][b][c]);
            }
        }
    }
    public static int method(int a, int b, int c){
        System.out.println(a+" "+b +" "+c);
        if(a<=0 || b<=0 || c <=0){
            return 1;
        }
        if (a>20 || b> 20|| c>20) {
            return method(20, 20, 20);
        }
        if(a<b && b<c){
            return method(a, b, c-1) + method(a, b-1, c-1) -method(a, b-1, c);
        }

        return method(a-1, b, c) + method(a-1, b-1, c) +method(a-1, b, c-1) -method(a-1, b-1, c-1);
    }
}
