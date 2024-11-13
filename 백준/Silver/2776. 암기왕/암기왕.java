import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap();
            for (String input : br.readLine().split(" ")) {
                map.put(input, 1);
            }

            StringBuilder sb = new StringBuilder();
            int M = Integer.parseInt(br.readLine());
            for (String input : br.readLine().split(" ")) {
                sb.append(map.containsKey(input) ? "1" : "0").append("\n");
            }

            System.out.print(sb);
        }
    }
}