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

        String answer = "";
        int maxCount = 0;

        Object[] objects = map.keySet().toArray();
        for (Object obj : objects) {
            String name = (String) obj;
            int count = map.get(name);
            if (count > maxCount) {
                answer = name;
                maxCount = count;
            } else if (count == maxCount) {
                if (name.compareTo(answer) < 0) {
                    answer = name;
                }
            }
        }

        System.out.println(answer);
    }
}