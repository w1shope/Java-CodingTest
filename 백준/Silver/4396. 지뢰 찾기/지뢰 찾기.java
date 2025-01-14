import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static boolean[][] lands;
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        lands = new boolean[N][N];
        Queue<int[]> bombQue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (row[j] == '*') {
                    lands[i][j] = true;
                    bombQue.offer(new int[]{i, j});
                }
            }
        }

        char[][] result = new char[N][N];
        boolean isMeetBomb = false;
        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (row[j] == '.') {
                    result[i][j] = '.';
                } else {
                    if (lands[i][j]) {
                        isMeetBomb = true;
                    } else {
                        result[i][j] = (char) ('0' + getAroundBombCount(j, i));
                    }
                }
            }
        }

        if (isMeetBomb) {
            while (!bombQue.isEmpty()) {
                int[] position = bombQue.poll();
                result[position[0]][position[1]] = '*';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static int getAroundBombCount(int x, int y) {
        int count = 0;
        for (int d = 0; d < 8; d++) {
            int cx = x + dx[d];
            int cy = y + dy[d];
            if (cx < 0 || cy < 0 || cx >= lands.length || cy >= lands.length) {
                continue;
            }
            if (lands[cy][cx]) {
                count++;
            }
        }
        return count;
    }
}