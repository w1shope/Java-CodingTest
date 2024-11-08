import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        for (int i = 0; i < N; i++) {
            arr[i + 1] = inputs[i];
        }

        int sum = 0;
        prefixSum = new int[N + 1];
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + (arr[i] > arr[i + 1] ? 1 : 0);
        }
        prefixSum[N] = prefixSum[N - 1];

        M = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M; i++) {
            inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int x = inputs[0];
            int y = inputs[1]; // x <= i < y
            answer.append(prefixSum[y - 1] - prefixSum[x - 1]).append("\n");
        }
        System.out.println(answer);
    }
}