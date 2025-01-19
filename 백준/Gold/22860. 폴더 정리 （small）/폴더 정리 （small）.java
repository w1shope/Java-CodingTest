import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    static int N, M;
    static Map<String, Set<String>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        for (int i = 0; i < N + M; i++) {
            inputs = br.readLine().split(" ");
            String parent = "folder_" + inputs[0];
            String now = inputs[1];
            boolean isFolder = inputs[2].equals("1");

            if (isFolder) {
                now = "folder_" + now;
            } else {
                now = "file_" + now;
            }

            if (!map.containsKey(parent)) {
                Set<String> set = new HashSet<>();
                set.add(now);
                map.put(parent, set);
            } else {
                Set<String> set = map.get(parent);
                set.add(now);
            }
        }

        StringBuilder sb = new StringBuilder();
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            String[] split = br.readLine().split("/");
            String findFolder = "folder_" + split[split.length - 1];

            if (!map.containsKey(findFolder)) {
                sb.append("0 0\n");
                continue;
            }

            Set<String> files = new HashSet<>();
            int fileCount = getFileCount(map.get(findFolder), files);
            sb.append(files.size() + " " + fileCount).append("\n");
        }

        System.out.println(sb);
    }

    static int getFileCount(Set<String> set, Set<String> files) {
        int count = 0;

        Object[] objects = set.toArray();
        for (Object name : objects) {
            if (((String) name).startsWith("file_")) {
                count++;
                files.add((String) name);
            } else {
                if (!map.containsKey(name)) {
                    continue;
                }
                int tmp = getFileCount(map.get(name), files);
                count += tmp;
            }
        }

        return count;
    }
}