import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    // N : 세로, M :가로
    static int N, M;
    static int[][] arr;
    static int T;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputArr[0];
        M = inputArr[1];

        arr = new int[N][M * 3]; // RGB_ij * 3
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
        }
        T = Integer.parseInt(br.readLine());

        int[][] graph = new int[N][M];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                int r = arr[y][x * 3];
                int g = arr[y][x * 3 + 1];
                int b = arr[y][x * 3 + 2];
                int avg = (r + g + b) / 3;
                if (avg >= T) {
                    graph[y][x] = 255;
                }
            }
        }

        int answer = 0;
        boolean[][] visited = new boolean[N][M];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (graph[y][x] == 255 && !visited[y][x]) {
                    dfs(x, y, graph, visited);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    static void dfs(int x, int y, int[][] graph, boolean[][] visited) {
        if (isOutOfRange(x, y)) { // 범위 벗어나면
            return;
        }
        if (visited[y][x]) { // 이미 방문했다면
            return;
        }
        if (graph[y][x] == 0) { // 물체가 아니라면
            return;
        }

        visited[y][x] = true;
        for (int d = 0; d < 4; d++) {
            int cx = x + dx[d];
            int cy = y + dy[d];
            dfs(cx, cy, graph, visited);
        }
    }

    static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= M || y >= N;
    }
}