import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n, m;
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);

            int[][] dp = new int[n + 1][m + 1];
            for (int j = n; j > 0; j--) {
                for (int k = j; k <= m; k++) {
                    if (j + 1 > n)
                        dp[j][k] = 1;
                    else {
                        dp[j][k] = Arrays.stream(dp[j + 1]).skip(k + 1).sum();
                    }
                }
            }
            sb.append(Arrays.stream(dp[1]).sum() + "\n");
        }
        System.out.println(sb);
    }
}