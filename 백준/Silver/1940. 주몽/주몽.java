import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        String[] inputs = br.readLine().split(" ");
        int[] arr = Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int count = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == m) {
                count++;
                left++;
                right--;
            } else if (sum > m)
                right--;
            else if (sum < m)
                left++;
        }
        System.out.println(count);
    }
}