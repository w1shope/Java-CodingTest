import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[][] arr;
    static int K;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputs[0]; //가로 길이
        M = inputs[1]; //세로 길이
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
        }

        dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i][j - 1] + arr[i - 1][j - 1];
            }
        }

        K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            sb.append(answer(inputs[0], inputs[1], inputs[2], inputs[3])).append("\n");
        }

        System.out.println(sb);
    }

    static long answer(int i, int j, int x, int y) {
        long result = 0L;
        for (int row = i; row <= x; row++) {
            result += dp[row][y] - dp[row][j - 1];
        }
        return result;
    }
}