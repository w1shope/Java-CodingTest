import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(nums);

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        System.out.println(IntStream.of(nums).sum());

    }
}