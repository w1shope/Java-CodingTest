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

            if (map.containsKey(extension))
                map.put(extension, map.get(extension) + 1);
            else
                map.put(extension, 1);
        }

        List<String> extensions = new ArrayList<>(map.keySet());
        Collections.sort(extensions);

        for (String s : extensions) {
            sb.append(s + " " + map.get(s) + "\n");
        }

        System.out.println(sb);
    }
}