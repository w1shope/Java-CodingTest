import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static final int SIZE = 100;
    static int[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[SIZE + 1][SIZE + 1];

        for (int i = 0; i < N; i++) {
            int[] pos = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int x = pos[0];
            int y = pos[1];
            paint(x, y);
        }

        System.out.println(answer());
    }

    static int answer() {
        int result = 0;
        for (int y = 1; y <= SIZE; y++) {
            for (int x = 1; x <= SIZE; x++) {
                if (arr[y][x] == 1) { // 현재 위치에 도화지가 있을 때
                    for (int d = 0; d < 4; d++) {
                        int cx = x + dx[d];
                        int cy = y + dy[d];
                        // 외관 라인을 따라가야 하므로, 상하좌우로 0인경우 둘레 +  1
                        if (isNotOutOfRange(cx, cy) && arr[cy][cx] == 0) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

    static boolean isNotOutOfRange(int x, int y) {
        return x >= 0 && y >= 0 && x <= SIZE && y <= SIZE;
    }

    static void paint(int x, int y) {
        // 색종이의 넓이는 10x10
        for (int i = y; i < y + 10; i++) {
            for (int j = x; j < x + 10; j++) {
                arr[i][j] = 1; // 색칠
            }
        }
    }
}