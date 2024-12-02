import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, M;
    static int[][] graph;
    static int maxSafeArea = Integer.MIN_VALUE;
    static final int MAX_COUNT = 3;

    // 인접 좌표 탐색
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]); // 행 개수
        M = Integer.parseInt(inputs[1]); // 열 개수
        graph = new int[N][M]; // 지도

        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        putWall(0);
        System.out.println(maxSafeArea);
    }

    static void putWall(int count) {
        if (count == MAX_COUNT) { // 벽을 3개 세운 경우
            // 안전 구역 개수 구한다.
            getSafeAreaCount();
            return;
        }

        // 그래프를 모두 탐색한다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) { // 빈칸에 벽을 세울 수 있다.
                    graph[i][j] = 1; // 현재 좌표에 벽을 세운다.
                    putWall(count + 1); // 재귀적으로 탐색한다.
                    graph[i][j] = 0; // 현재 좌표에서 벽을 제거한다.
                }
            }
        }
    }

    static void getSafeAreaCount() {
        int[][] tmp = cloneGraph();

        // 바이러스가 존재하는 좌표를 큐에 저장한다.
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] == 2) { // 바이러스가 존재한다면
                    que.offer(new int[]{i, j}); // {y, x}
                }
            }
        }

        // 바이러스를 하나씩 꺼내어 안전 지역을 감염시킨다.
        while (!que.isEmpty()) {
            int[] pos = que.poll(); // 바이러스가 존재하는 좌표
            for (int d = 0; d < 4; d++) { // 인접한 상하좌우 탐색
                int cx = pos[1] + dx[d];
                int cy = pos[0] + dy[d];
                // 범위를 벗어나지 않으면서 && 안전 지역이라면
                if (isNotOutOfRange(cx, cy) && tmp[cy][cx] == 0) {
                    tmp[cy][cx] = 2; // 현재 좌표는 바이러스에 감염된다.
                    que.offer(new int[]{cy, cx}); // 감염된 현재 좌표에서 다시 인접한 좌표 탐색
                }
            }
        }

        int safeCount = 0; // 안전 지역 개수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] == 0) { // 안전 지역이라면
                    safeCount++; // 안전 지역 개수 + 1
                }
            }
        }

        // 안전지역 최대값 갱신
        maxSafeArea = Math.max(maxSafeArea, safeCount);
    }

    static boolean isNotOutOfRange(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }

    static int[][] cloneGraph() {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = graph[i][j];
            }
        }
        return tmp;
    }
}