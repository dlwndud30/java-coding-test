package bruteforce;

import java.io.*;

public class Main3085 {
    static String [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        map = new String[n][n];

        for(int i=0; i<n; i++){
            String input = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j]= String.valueOf(input.charAt(j));
            }
        }

        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(j+1<n && !map[i][j].equals(map[i][j+1])){
                    max = Math.max(max, swap(n, i, j));
                }
                if(i+1<n && !map[i][j].equals(map[i+1][j])){
                    max = Math.max(max, swap2(n, i, j));
                }
            }
        }
        System.out.println(max);
    }

    private static int swap(int n, int i, int j) {

        String[][] map2 = new String[n][n]; // C 선언
        for(int c = 0; c <n; c++){
            System.arraycopy(map[c], 0, map2[c], 0, n);
        }

        String temp =map2[i][j];
        map2[i][j] = map2[i][j+1];
        map2[i][j+1] = temp;

        int max = 0;

        for(int x=0; x<n; x++){
            int count = 1;
            for(int y=0; y<n-1; y++){
                if(map2[x][y].equals(map2[x][y+1])){
                    count++;
                    max=Math.max(max, count);
                }
                else {
                    count=1;
                }
            }
        }

        for(int x=0; x<n; x++){
            int count = 1;
            for(int y=0; y<n-1; y++){
                if(map2[y][x].equals(map2[y+1][x])){
                    count++;
                    max=Math.max(max, count);
                }
                else {
                    count=1;
                }
            }
        }
        return max;
    }

    private static int swap2(int n, int i, int j) {

        String[][] map2 = new String[n][n]; // C 선언
        for(int c = 0; c <n; c++){
            System.arraycopy(map[c], 0, map2[c], 0, n);
        }

        String temp =map2[i][j];
        map2[i][j] = map2[i+1][j];
        map2[i+1][j] = temp;

        int max = 0;

        for(int x=0; x<n; x++){
            int count = 1;
            for(int y=0; y<n-1; y++){
                if(map2[x][y].equals(map2[x][y+1])){
                    count++;
                    max=Math.max(max, count);
                }
                else {
                    count=1;
                }
            }
        }

        for(int x=0; x<n; x++){
            int count = 1;
            for(int y=0; y<n-1; y++){
                if(map2[y][x].equals(map2[y+1][x])){
                    count++;
                    max=Math.max(max, count);
                }
                else {
                    count=1;
                }
            }
        }
        return max;
    }
}
