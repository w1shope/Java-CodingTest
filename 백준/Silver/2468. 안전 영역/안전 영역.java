import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int[][] arr;
    static int smallRainValue = 0; // 가장 적게 내린
    static int bigRainValue = Integer.MIN_VALUE; // 가장 많이 내린
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(input[j]);
                arr[i][j] = value;
                smallRainValue = Math.min(smallRainValue, value);
                bigRainValue = Math.max(bigRainValue, value);
            }
        }

        for (int value = smallRainValue; value <= bigRainValue; value++) {
            boolean[][] visited = new boolean[N][N]; // 침수 : true
            init(visited, value);

            int count = 0; // 영역 개수
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (!visited[y][x]) {
                        bfs(visited, x, y);
                        count += 1;
                    }
                }
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

    static void init(boolean[][] visited, int value) {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (arr[y][x] <= value) {
                    visited[y][x] = true; // 침수 처리
                }
            }
        }
    }

    static void bfs(boolean[][] visited, int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x, y});
        visited[y][x] = true;
        while (!que.isEmpty()) {
            int[] position = que.poll();
            for (int d = 0; d < 4; d++) {
                int cx = position[0] + dx[d];
                int cy = position[1] + dy[d];
                if (isNotOutOfRange(cx, cy) && !visited[cy][cx]) {
                    visited[cy][cx] = true;
                    que.offer(new int[]{cx, cy});
                }
            }
        }
    }

    static boolean isNotOutOfRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

}