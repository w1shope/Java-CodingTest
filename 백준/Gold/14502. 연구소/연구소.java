import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};

    static int N, M;
    static int[][] map;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildWall(0);
        System.out.println(max);
    }

    static void buildWall(int depth) {
        if (depth == 3) {
            calculateSafeArea();
            return;
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] == 0) {
                    map[y][x] = 1;
                    buildWall(depth + 1);
                    map[y][x] = 0;
                }
            }
        }
    }

    static void calculateSafeArea() {
        int[][] tmp = new int[N][M];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                tmp[y][x] = map[y][x];
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (tmp[y][x] == 2) {
                    spreadVirus(tmp, x, y);
                }
            }
        }

        int safeCount = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (tmp[y][x] == 0) {
                    safeCount++;
                }
            }
        }
        max = Math.max(max, safeCount);
    }

    static void spreadVirus(int[][] arr, int x, int y) {
        for (int d = 0; d < 4; d++) {
            int cx = x + dx[d];
            int cy = y + dy[d];

            if (cx < 0 || cy < 0 || cx >= M || cy >= N) {
                continue;
            }

            if (arr[cy][cx] == 0) {
                arr[cy][cx] = 2;
                spreadVirus(arr, cx, cy);
            }
        }
    }
}