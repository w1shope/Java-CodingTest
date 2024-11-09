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
    static Map<String, Extension> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] splits = br.readLine().split("\\.");
            String extension = splits[1];
            if (map.containsKey(extension)) {
                map.get(extension).count += 1;
            } else {
                map.put(extension, new Extension(extension, 1));
            }
        }

        List<Extension> extensions = new ArrayList<>(map.values());
        Collections.sort(extensions);

        StringBuilder answer = new StringBuilder();
        for (Extension extension : extensions) {
            answer.append(extension.name + " " + extension.count).append("\n");
        }

        System.out.println(answer);
    }

    static class Extension implements Comparable<Extension> {
        String name;
        int count;

        public Extension(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public int compareTo(Extension other) {
            return this.name.compareTo(other.name);
        }
    }
}