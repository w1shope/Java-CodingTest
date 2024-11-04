import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, M;
    static int[][] arr;
    static int[][] answer;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputArr[0];
        M = inputArr[1];

        arr = new int[N][M];
        answer = new int[N][M];
        int targetX = -1;
        int targetY = -1;
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(str[j]);
                arr[i][j] = num;
                if (num == 2) {
                    targetX = j;
                    targetY = i;
                } else if (num == 1) {
                    answer[i][j] = -1;
                }
            }
        }

        bfs(targetX, targetY);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int startX, int startY) {
        int count = 0;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{startX, startY});
        arr[startY][startX] = 0;

        while (!que.isEmpty()) {
            int[] pos = que.poll();
            int x = pos[0];
            int y = pos[1];
            for (int d = 0; d < 4; d++) {
                int cx = x + dx[d];
                int cy = y + dy[d];
                if (isNotOutOfRange(cx, cy) && answer[cy][cx] == -1) {
                    answer[cy][cx] = answer[y][x] + 1;
                    que.offer(new int[]{cx, cy});
                }
            }
        }
    }

    static boolean isNotOutOfRange(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }
}