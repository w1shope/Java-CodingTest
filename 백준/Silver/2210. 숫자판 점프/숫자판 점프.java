import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int[][] graph = new int[5][5];
    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {-1, 1, 0, 0};
    static Set<String> answer = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, "");
            }
        }

        System.out.println(answer.size());
    }

    static void dfs(int x, int y, String str) {
        if (isOutOfRange(x, y)) {
            return;
        }
        if (str.length() == 6) {
            answer.add(str);
            return;
        }

        str += graph[y][x];
        for (int d = 0; d < 4; d++) {
            int cx = x + dx[d];
            int cy = y + dy[d];
            dfs(cx, cy, str);
        }
    }

    static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= 5 || y >= 5;
    }
}