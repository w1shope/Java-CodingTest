import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String[] split = br.readLine().split("\\.");
            map.put(split[1], map.getOrDefault(split[1], 0) + 1);
        }

        Object[] objects = map.keySet().toArray();
        Arrays.sort(objects);

        for (Object obj : objects) {
            sb.append(obj).append(" ").append(map.get(obj)).append("\n");
        }
        System.out.println(sb);
    }
}