package materialization;

import java.io.*;
import java.util.ArrayList;

public class Main11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i=0; i<m; i++){
            String [] inputs = br.readLine().split(" ");

            int num;
            int index;

            switch (inputs[0]){
                case "add":
                    num = Integer.parseInt(inputs[1]);
                    if(!arrayList.contains(num)){
                        arrayList.add(num);
                    }
                    break;
                case "remove":
                    num = Integer.parseInt(inputs[1]);
                    index = arrayList.indexOf(num);
                    if(index>=0){
                        arrayList.remove(index);
                    }
                    break;
                case "check":
                    num = Integer.parseInt(inputs[1]);
                    if(arrayList.contains(num)){
                        bw.write("1\n");
                    }else {
                        bw.write("0\n");
                    }
                    break;
                case "toggle":
                    num = Integer.parseInt(inputs[1]);
                    index = arrayList.indexOf(num);
                    if(arrayList.contains(num)){
                        arrayList.remove(index);
                    }else {
                        arrayList.add(num);
                    }
                    break;
                case "all":
                    arrayList.clear();
                    for(int k=1; k<=20; k++){
                        arrayList.add(k);
                    }
                    break;
                case "empty":
                    arrayList.clear();
                    break;
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
