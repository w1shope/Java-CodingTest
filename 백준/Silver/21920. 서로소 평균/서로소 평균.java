import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        int x = Integer.parseInt(br.readLine());

        int count = 0;
        double sum = 0d;
        for (int num : nums) {
            int result = gcd(num, x);
            if (result == 1) {
                sum += num;
                count++;
            }
        }

        System.out.println(sum / count);
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}