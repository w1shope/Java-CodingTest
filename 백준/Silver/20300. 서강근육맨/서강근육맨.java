import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static long[] muscleLoss;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        muscleLoss = new long[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            muscleLoss[i] = Long.parseLong(input[i]);

        Arrays.sort(muscleLoss);
        if (muscleLoss.length % 2 == 0) {
            long max = 0;
            int start = 0, end = n - 1;
            while (start < end) {
                long sum = muscleLoss[start++] + muscleLoss[end--];
                max = Math.max(max, sum);
            }
            System.out.println(max);
        } else {
            long max = muscleLoss[n - 1];
            int start = 0, end = n - 2;
            while (start < end) {
                long sum = muscleLoss[start++] + muscleLoss[end--];
                max = Math.max(max, sum);
            }
            System.out.println(max);
        }
    }
}