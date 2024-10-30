import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] numbers;
    static long answer;
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        long sum = arrSum(); // 배열 전체 합
        for (int i = 0; i < N; i++) {
            sum = (sum - numbers[i] + MOD) % MOD; // sum 갱신 시 모듈러 연산 적용
            answer = (answer + numbers[i] * sum % MOD) % MOD; // 모듈러 연산 후 더하기
        }

        System.out.println(answer);
    }

    static long arrSum() {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum = (sum + numbers[i]) % MOD; // 합을 구할 때도 모듈러 연산 적용
        }
        return sum;
    }
}