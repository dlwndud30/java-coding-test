package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Average {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Double> overAvg = new ArrayList<>();

        for(int i=0; i<n; i++){
            int count = scan.nextInt();
            int sum =0;
            int[] score = new int[count];
            for(int j=0; j<count; j++){
                score[j]= scan.nextInt();
                sum+=score[j];
            }
            double average = (double)sum/count;
            int overAvgCount = 0;
            for(int j=0; j<count; j++){
                if(score[j]>average){
                    overAvgCount++;
                }
            }
            overAvg.add((double)overAvgCount/count*100);
        }
        for(Double a : overAvg){
            System.out.println(String.format("%.3f",a)+"%");
        }
    }
}
