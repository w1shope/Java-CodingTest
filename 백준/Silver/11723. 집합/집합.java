import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] splits = br.readLine().split(" ");
            if ("all".equals(splits[0])) {
                set.clear();
                for (int j = 1; j <= 20; j++) {
                    set.add(j + "");
                }
            } else if ("empty".equals(splits[0])) {
                set.clear();
            } else if ("add".equals(splits[0])) {
                set.add(splits[1]);
            } else if ("remove".equals(splits[0])) {
                set.remove(splits[1]);
            } else if ("check".equals(splits[0])) {
                result.append(set.contains(splits[1]) ? 1 : 0).append("\n");
            } else if ("toggle".equals(splits[0])) {
                boolean isSuccessRemove = set.remove(splits[1]);
                if (!isSuccessRemove) {
                    set.add(splits[1]);
                }
            }
        }

        System.out.println(result);
    }
}