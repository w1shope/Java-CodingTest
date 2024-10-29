import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] graph = new int[5][5];
    static int r, c; // 행, 열
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
        }

        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        r = inputArr[0];
        c = inputArr[1];

        dfs(c, r, 0, new boolean[5][5]);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void dfs(int x, int y, int moveCount, boolean[][] visited) {
        if (isOutOfRange(x, y)) { // 범위를 벗어난다면
            return;
        }
        if (visited[y][x]) { // 이미 방문했다면
            return;
        }
        if (graph[y][x] == -1) { // 방문할 수 없는 위치라면
            return;
        }

        if (graph[y][x] == 1) { // 도착했다면
            answer = Math.min(answer, moveCount);
            return;
        }

        visited[y][x] = true; // 방문 처리
        for (int d = 0; d < 4; d++) {
            int cx = x + dx[d];
            int cy = y + dy[d];
            dfs(cx, cy, moveCount + 1, visited);
        }
        visited[y][x] = false;
    }

    static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= 5 || y >= 5;
    }
}