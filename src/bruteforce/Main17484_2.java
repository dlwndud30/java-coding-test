package bruteforce;

import java.io.*;
import java.util.*;

public class Main17484_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][][] dp;
    static int[][] arr;
    static int minV = Integer.MAX_VALUE;
    static int n,m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n+1][m][3];
        arr = new int[n][m];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<=n;i++) {
            for(int j=0;j<m;j++) {
                for(int k=0;k<3;k++) {
                    dp[i][j][k] = i==0 ? 0 : Integer.MAX_VALUE;
                }
            }
        }
        for(int i=1;i<=n;i++) {
            for(int j=0;j<m;j++) {
                if(j!=0) {
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + arr[i-1][j-1];
                }
                if(j!=m-1) {
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0],dp[i-1][j+1][1]) + arr[i-1][j+1];
                }
                dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i-1][j];
                if(i==n) {
                    minV = Math.min(Math.min(Math.min(dp[i][j][0], dp[i][j][1]), dp[i][j][2]), minV);
                }
            }
        }
        System.out.println(minV);
    }
}