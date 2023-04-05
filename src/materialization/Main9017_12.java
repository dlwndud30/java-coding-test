package materialization;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main9017_12 {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            String[] inputs = br.readLine().split(" ");

            int [] array = new int[k]; //입력받은
            int [] arr = new int[201]; //몇명이 출전했는지
            int [] scores = new int[201]; //4등까지 순위 합
            int [] counts = new int[201]; //몇등까지 더했는지

            ArrayList<Integer> arrayList = new ArrayList<>(); //4인이상 출전한 팀

            for(int j=0; j<k; j++){
                int num = Integer.parseInt(inputs[j]);
                arr[num]++;
                array[j]=num;
            }

            for(int j=1; j<201; j++){
                if(arr[j]>=4){
                    arrayList.add(j);
                }
            }

            int [] score_5 = new int[201]; //5번째 선수의 점수

            int score = 0;
            for(int j=0; j<k; j++){
                if(arrayList.contains(array[j])){
                    counts[array[j]]++;
                    score++;
                    if(counts[array[j]]<=4){
                        scores[array[j]] += score;
                    } else if (counts[array[j]]==5) {
                        score_5[array[j]] = score;
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            int min_idx = 0;
            ArrayList<Integer> sameScore = new ArrayList<>();

            for(int j=1; j<201; j++){
                if(scores[j] > 0 ){
                    if(min>scores[j]){
                        min=scores[j];
                        min_idx=j;
                    }else if(min==scores[j]){
                        sameScore.add(min_idx);
                        sameScore.add(j);
                    }
                }
            }

            System.out.println(Arrays.toString(scores));

            if(sameScore.size()>0){
                min = Integer.MAX_VALUE;
                min_idx = 0;

                for(int num : sameScore){
                    if(min>score_5[num]){
                        min = score_5[num];
                        min_idx = num;
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
