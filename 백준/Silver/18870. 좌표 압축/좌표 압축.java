import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    static int N;
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        for (int i = 0; i < N; i++) {
            if (map.containsKey(inputs[i])) {
                List<Integer> values = map.get(inputs[i]);
                values.add(i);
            } else {
                List<Integer> values = new ArrayList<>();
                values.add(i);
                map.put(inputs[i], values);
            }
        }

        answer = new int[N];
        Set<Integer> set = map.keySet();
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        for (int i = 0; i < sortedList.size(); i++) {
            int num = sortedList.get(i);
            List<Integer> idxs = map.get(num);
            for (int idx : idxs) {
                answer[idx] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i] + " ");
        }
        System.out.println(sb);

    }
}