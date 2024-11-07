import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        System.out.println(answer(sum()));
    }

    static long answer(long sum) {
        long result = 0L;
        for (int s = 0; s < N; s++) {
            result += arr[s] * (sum - arr[s]);
            sum -= arr[s];
        }
        return result;
    }

    static long sum() {
        long result = 0L;
        for (int num : arr) {
            result += num;
        }
        return result;
    }
}