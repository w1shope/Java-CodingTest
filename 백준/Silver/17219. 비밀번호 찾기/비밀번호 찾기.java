import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        int n = inputs[0];
        int m = inputs[1];

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] splits = br.readLine().split(" ");
            map.put(splits[0], splits[1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(map.get(br.readLine()) + "\n");
        }

        System.out.println(sb);

    }
}