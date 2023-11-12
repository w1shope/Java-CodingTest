import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            t[i] = Integer.parseInt(input[0]);
            p[i] = Integer.parseInt(input[1]);
        }

        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (i + t[i] <= n)
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }

        System.out.println(
                Arrays.stream(dp)
                        .max()
                        .getAsInt()
        );
    }
}