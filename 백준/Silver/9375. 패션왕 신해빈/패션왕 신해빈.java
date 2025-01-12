import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String[] inputs = br.readLine().split(" ");
                String category = inputs[1];
                map.put(category, map.getOrDefault(category, 0) + 1);
            }

            int count = 1;
            for (Object obj : map.keySet()) {
                count *= map.get((String) obj) + 1;
            }
            sb.append(count - 1).append("\n");
        }

        System.out.println(sb);
    }
}