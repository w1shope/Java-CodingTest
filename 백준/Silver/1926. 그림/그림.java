import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, M;
    static int[][] arr;
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
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
        }

        int maxArea = Integer.MIN_VALUE;
        int areaCount = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (arr[y][x] == 1) {
                    maxArea = Math.max(maxArea, bfs(x, y));
                    areaCount++;
                }
            }
        }

        System.out.println(areaCount);
        System.out.println(areaCount == 0 ? 0 : maxArea);
    }

    static int bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x, y});
        arr[y][x] = 0; // 방문 처리
        int count = 1; // 그림의 넓이
        while (!que.isEmpty()) {
            int[] position = que.poll();
            for (int d = 0; d < 4; d++) {
                int cx = position[0] + dx[d];
                int cy = position[1] + dy[d];
                if (isNotOutOfRange(cx, cy) && arr[cy][cx] == 1) {
                    que.offer(new int[]{cx, cy});
                    arr[cy][cx] = 0; // 방문 처리
                    count++;
                }
            }
        }
        return count;
    }

    static boolean isNotOutOfRange(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }

}