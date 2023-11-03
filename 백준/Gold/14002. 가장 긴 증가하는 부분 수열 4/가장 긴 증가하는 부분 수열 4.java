import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] nums = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(input[i]);

        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++)
            max = Math.max(max, dp[i]);
        sb.append(max + "\n");

        Stack<Integer> st = new Stack<>();
        for (int i = n; i >= 1; i--) {
            if (dp[i] == max) {
                st.push(nums[i - 1]);
                max--;
            }
        }

        while (!st.isEmpty())
            sb.append(st.pop() + " ");
        System.out.println(sb);
    }
}