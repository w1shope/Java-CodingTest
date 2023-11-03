import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static List<Integer> list = new LinkedList<>();
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++)
            list.add(Integer.parseInt(br.readLine()));
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (list.get(i) > list.get(j))
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            max = Math.max(max, dp[i]);
        System.out.println(n - max);
    }
}