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
            for(int j=0; j<n-1; j++){
                if(!map[i][j].equals(map[i][j+1])){

                    max = swap(n, i, j);
                }
            }
        }

    }

    private static int swap(int n, int i, int j) {

        String[][] map2 = new String[n][n]; // C 선언
        for(int c = 0; c <n; c++){
            System.arraycopy(map[c], 0, map2[c], 0, n);
        }

//        System.out.println(i + " " + j);
//        System.out.println("-----전-------");
//        for(int x=0; x<n; x++){
//            for(int y=0; y<n; y++){
//                System.out.print(map2[x][y] + " ");
//            }
//            System.out.println();
//        }


        String temp =map2[i][j];
        map2[i][j] = map2[i][j+1];
        map2[i][j+1] = temp;

//        System.out.println("-----후-------");
//        for(int x=0; x<n; x++){
//            for(int y=0; y<n; y++){
//                System.out.print(map2[x][y] + " ");
//            }
//            System.out.println();
//        }

        int max = 0;
        String nowStr;

        for(int x=0; x<n; x++){
            for(int y=0; y<n-1; y++){

            }
        }
        return 0;
    }
}
