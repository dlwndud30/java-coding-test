package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17485 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] space = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 이차원 배열의 각각 위치에 이전에 온 방향을 설명하는 배열 추가
        // ( 0: 왼쪽에서 내려옴, 1 : 바로 아래로, 2: 오른쪽에서 내려옴 )

        int [][][] dp = new int[N+1][M][3]; // N번째는 달

        for(int i=0;i<=N;i++) {
            for(int j=0;j<M;j++) {
                for(int k=0;k<3;k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        for(int j=0;j<M;j++) {
            for(int k=0;k<3;k++) {
                dp[0][j][k] = space[0][j];
            }
        }

        for(int i=1;i<=N;i++) {
            for(int j=0;j<M;j++) {
                int min;
                // 이전 행에서 현재 행으로 가능한 경로 중 가장 연료소모가 적은 경로 선택

                min = Integer.MAX_VALUE;
                // 왼쪽에서 오는 경우
                if(j > 0) {
                    for(int pre=0;pre<3;pre++) {
                        if(pre!= 0) {
                            min = Math.min(min, dp[i-1][j-1][pre]);
                        }
                    }
                    if(i==N) dp[i][j][0] = min;
                    else dp[i][j][0] = min + space[i][j];
                }


                min = Integer.MAX_VALUE;
                // 오른쪽에서 오는 경우
                if(j<M-1) {
                    for(int pre=0;pre<3;pre++) {
                        if(pre!=2) {
                            min = Math.min(min,dp[i-1][j+1][pre]);
                        }
                    }
                    if(i==N) dp[i][j][2] = min;
                    else dp[i][j][2] = min + space[i][j];
                }


                min = Integer.MAX_VALUE;
                // 가운데에서 오는 경우
                for(int pre=0;pre<3;pre++) {
                    if(pre != 1) {
                        min = Math.min(min, dp[i-1][j][pre]);
                    }
                }
                if(i==N) dp[i][j][1] = min;
                else dp[i][j][1] = min +  space[i][j];
            }
        }

        int energy = Integer.MAX_VALUE;
        for(int j=0;j<M;j++) {
            for(int k=0;k<3;k++) {
                if(dp[N][j][k] != 0 ) energy = Math.min(dp[N][j][k],energy);
            }
        }

        System.out.println(energy);

    }

}