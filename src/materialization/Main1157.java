package materialization;

import java.io.*;

public class Main1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int arr[] = new int[26];
        String str = br.readLine();
        str = str.toUpperCase();

        for(int i=0; i<str.length(); i++){
            int index = str.charAt(i)-65;
            arr[index]++;
        }

        int max = -1;
        char ch = '?';

        for(int i=0; i<arr.length; i++){
            if(max<arr[i]){
                max=arr[i];
                ch = (char)(i+65);
            } else if (max==arr[i]) {
                ch= '?';
            }
        }

        System.out.println(ch);
    }
}
