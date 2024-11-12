import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int K;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        arr = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(inputs[j - 1]);
                dp[i][j] = dp[i][j - 1] + arr[i][j];
            }
        }

        K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < K; k++) {
            inputs = br.readLine().split(" ");
            int y1 = Integer.parseInt(inputs[0]);
            int x1 = Integer.parseInt(inputs[1]);
            int y2 = Integer.parseInt(inputs[2]);
            int x2 = Integer.parseInt(inputs[3]);
            sb.append(answer(x1, y1, x2, y2) + "\n");
        }

        System.out.println(sb);
    }

    static long answer(int x1, int y1, int x2, int y2) {
        long answer = 0L;
        for (int i = y1; i <= y2; i++) {
            answer += dp[i][x2] - dp[i][x1 - 1];
        }
        return answer;
    }
}