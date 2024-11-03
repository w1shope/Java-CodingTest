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
        int[] inputArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        N = inputArr[0];
        M = inputArr[1];

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int x, int y) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x, y, 1}); // {x, y, 방문횟수}

        while (!que.isEmpty()) {
            int[] position = que.poll();
            int nx = position[0];
            int ny = position[1];
            int moveCount = position[2];

            if (nx == M - 1 && ny == N - 1) {
                return moveCount;
            }
            
            for (int i = 0; i < 4; i++) {
                int cx = nx + dx[i];
                int cy = ny + dy[i];
                if (isNotOutOfRange(cx, cy) && arr[cy][cx] == 1 && !visited[cy][cx]) {
                    que.offer(new int[]{cx, cy, moveCount + 1});
                    visited[cy][cx] = true;
                }
            }
        }

        return -1;
    }


    static boolean isNotOutOfRange(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }

}