package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main17484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int [][] map = new int[N][M];

        for(int i=0; i<N; i++){
            String [] strings = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(strings[j]);
            }
        }

        int min = N*100;

        for(int i=0; i<M; i++){
            int sum = map[0][i];
            int status = 1;
            int x = i;
            int y = 0;
            System.out.println("-------------------------");
            System.out.println("x = " + x + ", y = "+y);
            while(y<N-1){
                int[] mins = new int[3];
                if(x-1>=0 && status != 0){
                    mins[0]=map[y+1][x-1];
                }
                if(status != 1){
                    mins[1]=map[y+1][x];
                }
                if(x+1<M && status != 2){
                    mins[2]=map[y+1][x+1];
                }

                int result = Integer.MAX_VALUE;
                int index = 0;
                for(int k=0; k<mins.length; k++){
                    if(mins[k]>0 && result>mins[k]){
                        result=mins[k];
                        index=k;
                    }
                }
                sum+=result;
                status=index;

                System.out.println("mins = " + Arrays.toString(mins));
                System.out.println("sum = " + sum+", index" +status);

                if(status==0){
                    x--;
                } else if (status==2) {
                    x++;
                }
                y++;
            }

            System.out.println("sum = " + sum);
            if(sum<min){
                min=sum;
            }
        }
        System.out.println(min);
    }
}
