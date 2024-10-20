import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        int[] numbers = new int[N];
        String[] strNumbers = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(strNumbers[i]);
        }

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += numbers[i];
        }
        int max = sum;

        for (int i = K; i < N; i++) {
            sum -= numbers[i - K];
            sum += numbers[i];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

}