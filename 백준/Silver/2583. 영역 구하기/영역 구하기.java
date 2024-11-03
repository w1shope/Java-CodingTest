import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int N, M, K;
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
        K = inputArr[2];

        arr = new int[N][M];
        for (int i = 0; i < K; i++) {
            inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int x1 = inputArr[0]; // 4
            int y1 = inputArr[1]; // 0
            int x2 = inputArr[2]; // 6
            int y2 = inputArr[3]; // 2
            paint(x1, y1, x2, y2);
        }

        System.out.println(answer());
    }

    static String answer() {
        List<Integer> result = new ArrayList<>();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (arr[y][x] == 0) {
                    result.add(bfs(x, y));
                }
            }
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size() + "\n");
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i) + " ");
        }
        return sb.toString();
    }

    static int bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x, y});
        arr[y][x] = 1;

        int count = 1;
        while (!que.isEmpty()) {
            int[] position = que.poll();
            for (int d = 0; d < 4; d++) {
                int cx = dx[d] + position[0];
                int cy = dy[d] + position[1];
                if (isNotOutOfRange(cx, cy) && arr[cy][cx] == 0) {
                    que.offer(new int[]{cx, cy});
                    arr[cy][cx] = 1;
                    count++;
                }
            }
        }
        return count;
    }


    static void paint(int x1, int y1, int x2, int y2) {
        for (int y = y1; y < y2; y++) {
            for (int x = x1; x < x2; x++) {
                arr[y][x] = 1;
            }
        }
    }

    static boolean isNotOutOfRange(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }
}