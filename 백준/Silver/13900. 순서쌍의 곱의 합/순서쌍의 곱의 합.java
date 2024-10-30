import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] numbers;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        long sum = sum();
        for (int i = 0; i < N; i++) {
            sum -= numbers[i];
            answer += numbers[i] * sum;
        }

        System.out.println(answer);
    }

    static long sum() {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}