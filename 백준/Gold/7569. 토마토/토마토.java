import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int M, N, H;
    static int[][][] arr;
    static Queue<int[]> que = new LinkedList<>();
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        M = inputs[0]; // 열
        N = inputs[1]; // 행
        H = inputs[2]; // 높이

        arr = new int[N][M][H];

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                inputs = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::valueOf)
                        .toArray();
                for (int j = 0; j < M; j++) {
                    arr[i][j][h] = inputs[j];
                    if (arr[i][j][h] == 1) {
                        que.offer(new int[]{i, j, h});
                    }
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
                int z = pos[2];
                for (int d = 0; d < 6; d++) {
                    int cx = x + dx[d];
                    int cy = y + dy[d];
                    int cz = z + dz[d];
                    if (isNotOutOfRange(cx, cy, cz) && arr[cy][cx][cz] == 0) {
                        arr[cy][cx][cz] = 1;
                        que.offer(new int[]{cy, cx, cz});
                    }
                }
            }
        }

        if (isBreak()) {
            return days;
        } else {
            return -1;
        }
    }

    static boolean isBreak() {
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (arr[y][x][z] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static boolean isNotOutOfRange(int x, int y, int z) {
        return x >= 0 && y >= 0 && z >= 0 && y < N && x < M && z < H;
    }
}