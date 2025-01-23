import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (String input : br.readLine().split(" ")) {
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (String input : br.readLine().split(" ")) {
            sb.append(map.getOrDefault(input, 0)).append(" ");
        }

        System.out.println(sb);
    }
}