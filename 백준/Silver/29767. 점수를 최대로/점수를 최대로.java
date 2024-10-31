import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, K;
    static int[] nums;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputArr[0];
        K = inputArr[1];

        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        long allNumbersSum = allSum();
        long[] sumArr = new long[N];
        sumArr[0] = allNumbersSum;
        for (int i = 1; i < N; i++) {
            sumArr[i] = sumArr[i - 1] - nums[N - i];
        }

        Arrays.sort(sumArr);
        long answer = 0L;
        for (int i = 0; i < K; i++) {
            answer += sumArr[(N - 1) - i];
        }

        System.out.println(answer);

    }

    // 배열 모든 요소의 합 반환
    static long allSum() {
        long sum = 0L;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }
        return sum;
    }
}