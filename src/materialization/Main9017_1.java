package materialization;

import interface_form.ArrayList.ArrayList;

import java.io.*;
import java.util.Arrays;

public class Main9017_1 {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            String[] inputs = br.readLine().split(" ");

            int [] array = new int[k];
            int [] arr = new int[201];

            ArrayList<Integer> arrayList = new ArrayList<>();

            for(int j=0; j<k; j++){
                int num = Integer.parseInt(inputs[j]);
                arr[num]++;
                array[j]=num;
            }

            System.out.println(Arrays.toString(arr));

            for(int j=1; j<201; j++){
                if(arr[j]>=4){
                    arrayList.add(j);
                }
            }

            int min = Integer.MAX_VALUE;
            int min_idx = 0;
            boolean isSame = false;

            int [] arr5 = new int[arrayList.size()+1];

            for(int j=0; j<arrayList.size(); j++){
                int num = arrayList.get(j);
                System.out.println("--------------"+num+"-------------");
                int sum = 0;
                int count = 0;
                for(int l=0; l<k; l++){
                    if(array[l]==num){
                        if(count<4){
                            System.out.print(l + " ");
                            count++;
                            sum += (l+1);
                        } else if (count==4) {
                            arr5[j]=l;
                        }
                    }
                }
                System.out.println(sum);
                if(min>sum){
                    min=sum;
                    min_idx = num;
                } else if (min == sum) {
                    isSame=true;
                }
            }

            if(isSame){
                System.out.println(Arrays.toString(arr5));
                min = Integer.MAX_VALUE;
                for(int j = 1; j<arr5.length; j++){
                    if(min>arr5[j]){
                        min_idx=j;
                    }
                }
            }

            bw.write(min_idx + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
