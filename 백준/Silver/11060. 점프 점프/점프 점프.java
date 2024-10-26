import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] miro;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        miro = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            if(dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            
            int step = miro[i];
            for (int j = 1; j <= step; j++) {
                if (i + j < N) {
                    dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
                }
            }
        }

        System.out.println(dp[N - 1] == Integer.MAX_VALUE ? -1 : dp[N - 1]);
    }
}