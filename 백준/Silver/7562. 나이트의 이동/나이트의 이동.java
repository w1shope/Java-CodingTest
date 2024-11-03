import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {
            -2, -1, 1, 2,
            -2, -1, 1, 2
    };

    static int[] dy = {
            -1, -2, -2, -1,
            1, 2, 2, 1
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] startPosition = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int[] targetPosition = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int moveCount = bfs(startPosition[0], startPosition[1], targetPosition[0], targetPosition[1], n);
            sb.append(moveCount + "\n");
        }

        System.out.println(sb);
    }

    static int bfs(int x, int y, int targetX, int targetY, int arrSize) {
        boolean[][] visited = new boolean[arrSize][arrSize];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x, y, 0}); // {x, y, 이동횟수}
        while (!que.isEmpty()) {
            int[] poll = que.poll();

            if (poll[0] == targetX && poll[1] == targetY) {
                return poll[2];
            }

            for (int d = 0; d < 8; d++) {
                int cx = dx[d] + poll[0];
                int cy = dy[d] + poll[1];
                int moveCount = poll[2];
                if (isNotOutOfRange(cx, cy, arrSize) && !visited[cy][cx]) {
                    visited[cy][cx] = true;
                    que.offer(new int[]{cx, cy, moveCount + 1});
                }
            }
        }
        return 0;
    }

    static boolean isNotOutOfRange(int x, int y, int arrSize) {
        return x >= 0 && y >= 0 && x < arrSize && y < arrSize;
    }
}