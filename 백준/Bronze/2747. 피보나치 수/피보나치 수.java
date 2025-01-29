import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int num = 2; num <= N; num++) {
            dp[num] = dp[num - 2] + dp[num - 1];
        }

        System.out.println(dp[N]);
    }
}