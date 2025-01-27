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

        System.out.println(map.getOrDefault(br.readLine(), 0));
    }
}