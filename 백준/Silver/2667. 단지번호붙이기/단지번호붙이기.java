import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static int[][] arr;
    static List<Integer> answer = new ArrayList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[N][N];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!visited[y][x] && arr[y][x] == 1) {
                    int count = dfs(x, y, visited);
                    answer.add(count);
                }
            }
        }

        Collections.sort(answer);

        sb.append(answer.size() + "\n");
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i) + "\n");
        }

        System.out.println(sb);
    }

    static int dfs(int x, int y, boolean[][] visited) {
        if (isOutOfRange(x, y) || visited[y][x] || arr[y][x] == 0) {
            return 0;
        }

        visited[y][x] = true;
        int count = 1;
        for (int d = 0; d < 4; d++) {
            int cx = x + dx[d];
            int cy = y + dy[d];
            count += dfs(cx, cy, visited);
        }

        return count;
    }

    static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || y >= N || x >= N;
    }
}