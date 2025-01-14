import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        while (N-- > 0) {
            String[] inputs = br.readLine().split("\\.");
            map.put(inputs[1], map.getOrDefault(inputs[1], 0) + 1);
        }

        Object[] objects = map.keySet().toArray();
        Arrays.sort(objects);

        StringBuilder sb = new StringBuilder();
        for (Object obj : objects) {
            sb.append(obj).append(" ").append(map.get(obj)).append("\n");
        }

        System.out.print(sb);
    }
}