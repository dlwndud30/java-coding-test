package Example;

import java.util.Scanner;

public class Main2739 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        for(int i=1; i<=9; i++){
            //2 * 1 = 2
            System.out.println(N + " * " + i + " = " + i*N);
        }
    }
}
