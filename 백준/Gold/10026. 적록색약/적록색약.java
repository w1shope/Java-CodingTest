import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] redArr = new char[N][N];
        char[][] redGreenArr = new char[N][N];
        for (int i = 0; i < N; i++) {
            char[] cArr = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                redGreenArr[i][j] = cArr[j];
                if (cArr[j] == 'G') {
                    redArr[i][j] = 'R';
                } else {
                    redArr[i][j] = cArr[j];
                }
            }
        }

        System.out.println(getStageCount(redGreenArr) + " " + getStageCount(redArr));
    }

    static int getStageCount(char[][] arr) {
        int stageCount = 0; // 영역 개수
        boolean[][] visited = new boolean[N][N]; // 방문 여부
        Queue<int[]> que = new LinkedList<>();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!visited[y][x]) {
                    stageCount++; // 영역 1개 증가
                    que.offer(new int[]{y, x});
                    visited[y][x] = true;
                    while (!que.isEmpty()) {
                        int[] pos = que.poll();
                        for (int d = 0; d < 4; d++) {
                            int cx = pos[1] + dx[d];
                            int cy = pos[0] + dy[d];
                            if (isNotOutOfRange(cx, cy) && !visited[cy][cx] && arr[y][x] == arr[cy][cx]) { // 인접한 좌표의 색과 같다면
                                visited[cy][cx] = true;
                                que.offer(new int[]{cy, cx});
                            }
                        }
                    }
                }
            }
        }
        return stageCount;
    }

    static boolean isNotOutOfRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}