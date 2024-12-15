import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
            names.add(name);
        }

        for (int i = 0; i < n - 1; i++) {
            String name = br.readLine();
            map.put(name, map.get(name) - 1);
        }

        for (String name : names) {
            if (map.get(name) >= 1) {
                System.out.println(name);
                break;
            }
        }
    }
}