import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int N;
    static final int DIV = 10_007;
    static int[] dp = new int[1001];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % DIV;
        }

        System.out.println(dp[N]);
    }
}