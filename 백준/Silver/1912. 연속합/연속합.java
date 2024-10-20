import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= numbers.length; i++) {
            prefixSum[i] = Math.max(prefixSum[i - 1] + numbers[i - 1], numbers[i - 1]);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i < prefixSum.length; i++) {
            max = Math.max(max, prefixSum[i]);
        }

        System.out.println(max);
    }
}