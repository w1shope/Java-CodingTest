import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] stairs;
    static int[][] dp;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stairs = new int[N + 1];
        for (int i = 0; i < N; i++) {
            stairs[i + 1] = Integer.parseInt(br.readLine());
        }

        dp = new int[N + 1][2];
        dp[1][0] = stairs[1]; // 연속으로 밟지 않았을 때
        if (N >= 2) {
            dp[2][0] = stairs[2];
            dp[2][1] = stairs[1] + stairs[2]; // 2칸 연속으로 밟았을 때
        }

        System.out.println(answer());
    }

    static int answer() {
        for (int i = 3; i <= N; i++) {
            // 2칸 전
            dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + stairs[i];
            // 1칸 전
            dp[i][1] = dp[i - 1][0] + stairs[i];
        }
        return Math.max(dp[N][0], dp[N][1]);
    }

}