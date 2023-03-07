package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main17484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int [][] map = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            String [] strings = br.readLine().split(" ");
            for(int j=1; j<=M; j++){
                map[i][j] = Integer.parseInt(strings[j-1]);
            }
        }

        int result = Integer.MAX_VALUE;

        for(int i=1; i<=M; i++){
            int x= i;
            int y=1;
            int status = 1;
            int fuel = map[y][x];
            Node root = new Node(x,y,fuel,status);

            Stack<Node> stack = new Stack<>();

            stack.push(root);

            while (!stack.isEmpty()){
                Node parent = stack.pop();

                if(parent.y==N+1){
                    result = Math.min(result, parent.fuel);
                }else{
                    int p_x = parent.x;
                    int p_y = parent.y;

                    if(p_x-1>=0 && parent.status !=0){
                        Node child = new Node(p_x-1, p_y+1, parent.fuel+map[p_y+1][p_x-1], 0);
                        stack.push(child);
                    }
                    if(parent.status !=1){
                        Node child = new Node(p_x, p_y+1, parent.fuel+map[p_y+1][p_x], 1);
                        stack.push(child);
                    }
                    if(p_x+1<=M && parent.status !=2){
                        Node child = new Node(p_x+1, p_y+1, parent.fuel+map[p_y+1][p_x+1], 2);
                        stack.push(child);
                    }
                }
            }
        }
        System.out.println(result);
    }
    static class Node{
        int x;
        int y;
        int fuel;
        int status;

        public Node(int x, int y, int fuel, int status) {
            this.x = x;
            this.y = y;
            this.fuel = fuel;
            this.status = status;
        }
    }
}
