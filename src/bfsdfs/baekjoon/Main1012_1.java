package bfsdfs.baekjoon;

import java.util.Scanner;

public class Main1012_1 {
    static int m=0;
    static int n =0;
    static int arr[][] = null;
    static boolean check[][] = null;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        int countArr[] = new int [t];

        for(int i=0; i<t; i++) {
            m = scan.nextInt();
            n = scan.nextInt();
            int k = scan.nextInt();

            arr=new int[n][m];
            check = new boolean[n][m];
            int count =0;

            for(int j=0; j<k; j++) {
                int x= scan.nextInt();
                int y= scan.nextInt();
                arr[y][x]=1;
            }

            for(int y=0; y<m; y++) {
                for(int x=0; x<n; x++) {
                    if(arr[x][y]==1 && !check[x][y]) {
                        check[x][y]=true;
                        count += dfs(x,y);
                    }
                }
            }
            countArr[i]=count;
        }

        for(int i=0; i<t; i++) {
            System.out.println(countArr[i]);
        }
    }

    static int dfs(int x, int y) {
        int yy[] = {0, 1, 0, -1};
        int xx[] = {-1, 0, 1, 0};

        for(int i=0; i<4; i++) {
            int newX = x+xx[i];
            int newY = y+yy[i];
            if(newX>=0 && newX<n && newY>=0 && newY<m) {
                if(arr[newX][newY]==1 && !check[newX][newY]) {
                    check[newX][newY]=true;
                    dfs(newX, newY);
                }
            }
        }
        return 1;
    }
}

