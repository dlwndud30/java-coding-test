package bruteforce;
import java.io.*;
import java.util.*;
public class Main17484_1_1 {

    static int N, M;
    static int[][] fuels;
    static int[] dx = {-1, 0, 1};
    static int answer = Integer.MAX_VALUE;

    private static void solution() {

        for (int x = 1; x <= M; x++) {
            for (int d = 0; d < 3; d++) {
                int nx = x + dx[d];
                dfs(2, nx, d, fuels[1][x]);
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int y, int x, int pre, int sum) {
        if (x < 1 || x > M) return;
        if (y == N + 1) {
            answer = Math.min(sum, answer);
            return;
        }

        for (int d = 0; d < 3; d++) {
            if (d == pre) continue;
            dfs(y + 1, x + dx[d], d, sum + fuels[y][x]);
        }
    }

    private static void input() throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        fuels = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(r.readLine());
            for (int j = 1; j <= M; j++) fuels[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

}