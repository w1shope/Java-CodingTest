import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (int i = 0; i < n - 1; i++) {
            String name = br.readLine();
            map.put(name, map.get(name) - 1);
        }

        Object[] names = map.keySet().toArray();
        for (Object name : names) {
            if (map.get((String) name) > 0) {
                System.out.print((String) name);
                break;
            }
        }
    }
}