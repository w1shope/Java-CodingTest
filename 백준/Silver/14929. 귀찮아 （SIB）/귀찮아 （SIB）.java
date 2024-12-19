import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 원소 개수 n
        int n = Integer.parseInt(br.readLine());

        // n개의 원소들
        String[] inputs = br.readLine().split(" ");
        int sum = 0; // n개의 원소들의 합
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
            sum += nums[i];
        }

        // 합 계산
        long result = 0L;
        for (int i = 0; i < n; i++) {
            int pick = nums[i];
            sum -= pick;
            result += pick * sum;
        }

        System.out.println(result);
    }
}