import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {

    static Map<String, Integer> map = new HashMap<>();
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = 0;

        while (true) {
            String input = br.readLine();
            if (input == null) {
                break;
            }
            map.put(input, map.getOrDefault(input, 0) + 1);
            set.add(input);
            size++;
        }
        PriorityQueue<String> que = new PriorityQueue<>(set);

        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()) {
            String name = que.poll();
            double percent = ((double) map.get(name) / size) * 100;
            sb.append(String.format("%s %.4f\n", name, percent));
        }

        System.out.println(sb);
    }
}