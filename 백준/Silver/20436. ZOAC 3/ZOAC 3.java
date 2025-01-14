import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    static final Map<Character, int[]> positions = new HashMap<>();
    static Set<Character> lefts = Set.of('q', 'w', 'e', 'r', 't', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v');

    public static void main(String[] args) throws IOException {
        initMap();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        char left = inputs[0].charAt(0);
        char right = inputs[1].charAt(0);

        int time = 0;
        for (char c : br.readLine().toCharArray()) {
            int[] now;
            if (lefts.contains(c)) {
                now = positions.get(left);
                left = c;
            } else {
                now = positions.get(right);
                right = c;
            }

            int[] next = positions.get(c);
            time += Math.abs(now[0] - next[0]) + Math.abs(now[1] - next[1]) + 1;
        }

        System.out.print(time);
    }

    static void initMap() {
        char[][] tmp = new char[][]{
                new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
                new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
                new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'}
        };

        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                positions.put(tmp[i][j], new int[]{i, j});
            }
        }
    }
}