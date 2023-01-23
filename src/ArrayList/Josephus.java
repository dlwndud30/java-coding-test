package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Josephus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> printArrayList = new ArrayList<>();
        for(int num =1; num<=n; num++){
            arrayList.add(num);
        }

        int start = 0;
        while(arrayList.size()>0) {
            int removeIdx = start + k -1;

            while(removeIdx > arrayList.size()-1){
                    removeIdx-=arrayList.size();
            }
            printArrayList.add(arrayList.remove(removeIdx));

            start = removeIdx;
        }

        String printStr = "<";
        for(Integer num : printArrayList){
            printStr = printStr + num + ", ";
        }
        System.out.println(printStr.substring(0, printStr.length()-2)+">");
    }
}
