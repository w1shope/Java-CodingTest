import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int[] inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int N = inputArr[0];
            int M = inputArr[1];
            int K = inputArr[2];

            int[][] graph = new int[N][M];
            for (int k = 0; k < K; k++) {
                inputArr = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::valueOf)
                        .toArray();
                int y = inputArr[0];
                int x = inputArr[1];
                graph[y][x] = 1; // 배추를 심는다.
            }

            int wormCount = 0; // 지렁이 개수
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (graph[y][x] == 1) { // 배추가 심어져있다면
                        wormCount++; // 필요한 지렁이 개수 1
                        traverse(graph, x, y); // 인접한 배추도 지렁이가 움직일 수 있도록 처리
                    }
                }
            }

            sb.append(wormCount + "\n");
        }

        System.out.println(sb.toString());
    }

    static void traverse(int[][] graph, int x, int y) {
        graph[y][x] = 0; // 방문 처리
        for (int d = 0; d < 4; d++) { // 상하좌우 탐색
            int cx = x + dx[d];
            int cy = y + dy[d];
            if (isNotOutOfRange(graph, cx, cy) && graph[cy][cx] == 1) { // 인접한 곳에 배추가 심어져 있다면
                traverse(graph, cx, cy); // 인접한 곳에서 다시 탐색
            }
        }
    }

    // 탐색 좌표가 밭의 범위를 벗어나는지 여부, false -> 범위 벗어남
    static boolean isNotOutOfRange(int[][] graph, int x, int y) {
        return x >= 0 && y >= 0 && y < graph.length && x < graph[y].length;
    }

}