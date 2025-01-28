import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[]{1, 1};

        while (nums[0] < N) {
            nums[0] += nums[1];
            nums[1] += 1;
        }

        int front, back;
        if (nums[0] == N) {
            front = nums[1] % 2 == 0 ? 1 : nums[1];
            back = nums[1] % 2 == 0 ? nums[1] : 1;
        } else {
            nums[1] -= 1;
            nums[0] -= nums[1];

            int num = nums[1];
            for (int i = nums[0]; i < N; i++) {
                num--;
            }

            front = nums[1] % 2 == 0 ? nums[1] + 1 - num : num;
            back = nums[1] % 2 == 0 ? num : nums[1] + 1 - num;
        }

        System.out.println(String.format("%d/%d", front, back));
    }
}