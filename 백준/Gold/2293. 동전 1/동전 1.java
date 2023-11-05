import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]); // 동전 개수
        int k = Integer.parseInt(inputs[1]); // 구하는 합
        int[] coins = new int[n];

        for (int i = 0; i < n; i++)
            coins[i] = Integer.parseInt(br.readLine());
        Arrays.sort(coins);

        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            for (int j = coin; j <= k; j++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }

        System.out.println(dp[k]);
    }
}