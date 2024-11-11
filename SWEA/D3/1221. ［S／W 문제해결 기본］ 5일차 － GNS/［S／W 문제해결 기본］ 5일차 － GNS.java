import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Solution {

    static final String[] planets = {
            "ZRO", "ONE", "TWO", "THR", "FOR", "FIV",
            "SIX", "SVN", "EGT", "NIN"
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[1]);

            Map<String, Integer> map = new HashMap<>();
            String[] words = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            }

            sb.append("#").append(t).append("\n");
            for (int i = 0; i < planets.length; i++) {
                int size = map.get(planets[i]);
                for (int j = 0; j < size; j++) {
                    sb.append(planets[i]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}