import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String extension = input.substring(input.indexOf(".") + 1);

            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        map.keySet().stream().sorted().forEach(extension -> sb.append(extension + " " + map.get(extension) + "\n"));
        System.out.println(sb);
    }
}
