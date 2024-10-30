import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, K;
    static int[] pies;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputArr[0]; // 애플파이 개수
        K = inputArr[1]; // 몇 개를 먹을 건지

        pies = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        int currentMax = 0;
        for (int i = 0; i < K; i++) {
            currentMax += pies[i];
        }
        answer = currentMax;

        for (int i = 1; i < N; i++) {
            currentMax = currentMax - pies[i - 1] + pies[(i + K - 1) % N];
            answer = Math.max(answer, currentMax);
        }

        System.out.println(answer);
    }
}