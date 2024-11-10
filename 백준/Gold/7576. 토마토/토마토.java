import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, M;
    static int[][] arr;
    static Queue<int[]> que = new LinkedList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputs[1]; // 행
        M = inputs[0]; // 열
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = inputs[j];
                if (arr[i][j] == 1) {
                    que.offer(new int[]{i, j}); // {y, x}
                }
            }
        }

        System.out.println(answer());
    }

    static int answer() {
        int days = -1;
        while (!que.isEmpty()) {
            int size = que.size();
            days++;
            for (int i = 0; i < size; i++) {
                int[] pos = que.poll();
                int x = pos[1];
                int y = pos[0];
                for (int d = 0; d < 4; d++) {
                    int cx = x + dx[d];
                    int cy = y + dy[d];
                    if (isNotOutOfRange(cx, cy) && arr[cy][cx] == 0) {
                        arr[cy][cx] = 1;
                        que.offer(new int[]{cy, cx});
                    }
                }
            }
        }

        if (isBreak()) {
            return days;
        }
        return -1;
    }

    static boolean isBreak() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isNotOutOfRange(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }
}