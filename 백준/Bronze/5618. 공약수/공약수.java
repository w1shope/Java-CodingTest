import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static Map<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= value; i++) {
                if (value % i == 0) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == N) {
                sb.append(entry.getKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}