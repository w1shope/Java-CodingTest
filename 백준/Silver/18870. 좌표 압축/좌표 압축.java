import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int N;
    static int[] originalArr;
    static int[] sortedArr;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        originalArr = new int[N];
        sortedArr = new int[N];

        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        for (int i = 0; i < N; i++) {
            originalArr[i] = inputs[i];
            sortedArr[i] = originalArr[i];
        }

        Arrays.sort(sortedArr);

        int order = 0;
        for (int num : sortedArr) {
            if (!map.containsKey(num)) {
                map.put(num, order++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : originalArr) {
            sb.append(map.get(num) + " ");
        }
        System.out.println(sb);

    }
}