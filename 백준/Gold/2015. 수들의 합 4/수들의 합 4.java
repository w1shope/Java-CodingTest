import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int N, K;
    static int[] prefixSum;

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputs[0];
        K = inputs[1];

        inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        prefixSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + inputs[i - 1];
        }

        System.out.println(answer());
    }

    static long answer() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 초기값: 부분합이 0 -> 1개 존재

        long result = 0;
        for (int i = 1; i <= N; i++) {
            // prefixSum[i]에서 K를 뺀 값이 map에 존재한다면,
            // 이전의 지점 j까지의 누적합이 prefixSum[j] = prefixSum[i] - K였음을 의미.
            // 따라서 구간 [j + 1, i]의 부분합이 정확히 K가 된다.
            result += map.getOrDefault(prefixSum[i] - K, 0);
            map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
        }
        return result;
    }
}