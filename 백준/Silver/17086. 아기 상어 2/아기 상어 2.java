import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, M;
    static int[][] arr;
    static int[][] minDistanceArr;
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputArr[0];
        M = inputArr[1];

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
        }

        minDistanceArr = new int[N][M];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (arr[y][x] == 0) {
                    minDistanceArr[y][x] = bfs(new int[]{y, x}, new boolean[N][M]);
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                answer = Math.max(answer, minDistanceArr[y][x]);
            }
        }

        System.out.println(answer);
    }

    static int bfs(int[] position, boolean[][] visited) {
        visited[position[0]][position[1]] = true;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{position[0], position[1], 0}); // 초기 위치와 이동 횟수를 포함

        while (!que.isEmpty()) {
            int[] poll = que.poll();
            int y = poll[0];
            int x = poll[1];
            int moveCount = poll[2];

            for (int d = 0; d < 8; d++) {
                int cy = y + dy[d];
                int cx = x + dx[d];
                if (isNotOutOfRange(cx, cy) && !visited[cy][cx]) {
                    visited[cy][cx] = true;
                    if (arr[cy][cx] == 1) { // 아기 상어를 찾은 경우
                        return moveCount + 1;
                    } else {
                        que.offer(new int[]{cy, cx, moveCount + 1});
                    }
                }
            }
        }

        return -1;
    }

    static boolean isNotOutOfRange(int x, int y) {
        return x >= 0 && y >= 0 && y < N && x < M;
    }
}