import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static int N;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] splits = br.readLine().split("\\.");
            String extension = splits[1];
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        List<String> extensions = new ArrayList<>(map.keySet());
        Collections.sort(extensions);

        StringBuilder answer = new StringBuilder();
        for (String extension : extensions) {
            answer.append(extension + " " + map.get(extension)).append("\n");
        }

        System.out.println(answer);
    }
}