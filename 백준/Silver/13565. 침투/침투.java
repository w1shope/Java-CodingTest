import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, M;
    static int[][] graph;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean isArrived;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputArr[0];
        M = inputArr[1];

        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        for (int x = 0; x < M; x++) {
            if (graph[0][x] == 0) {
                bfs(x, 0);
                if(isArrived) {
                    break;
                }
            }
        }

        System.out.println(isArrived ? "YES" : "NO");
    }

    static void bfs(int x, int y) {
        boolean[][] visited = new boolean[N][M];
        visited[y][x] = true;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x, y});
        while (!que.isEmpty()) {
            int[] position = que.poll();
            int px = position[0];
            int py = position[1];


            if (py == N - 1 && graph[py][px] == 0) { // 종료 조건
                isArrived = true;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int cx = px + dx[d];
                int cy = py + dy[d];
                if (isNotOutOfRange(cx, cy) && !visited[cy][cx] && graph[cy][cx] == 0) {
                    visited[cy][cx] = true; // 전류가 흐르는 곳 방문
                    que.offer(new int[]{cx, cy});
                }
            }
        }

    }

    static boolean isNotOutOfRange(int x, int y) {
        return x >= 0 && y >= 0 && y < N && x < M;
    }
}