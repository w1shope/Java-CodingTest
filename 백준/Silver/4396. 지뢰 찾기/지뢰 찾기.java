import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    static int[][] lands;
    static List<int[]> bombs = new ArrayList<>();
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
    static char[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        lands = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (arr[j] == '*') {
                    bombs.add(new int[]{i, j});
                }
                lands[i][j] = arr[j];
            }
        }

        result = new char[N][N];
        boolean isMeetBomb = false;
        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (arr[j] == 'x') {
                    result[i][j] = (char) (getAroundBombsCount(j, i) + '0');
                    if (lands[i][j] == '*') {
                        isMeetBomb = true;
                    }
                } else {
                    result[i][j] = '.';
                }
            }
        }

        if (isMeetBomb) {
            for (int i = 0; i < bombs.size(); i++) {
                int[] pos = bombs.get(i);
                result[pos[0]][pos[1]] = '*';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int getAroundBombsCount(int x, int y) {
        int count = 0;
        for (int d = 0; d < 8; d++) {
            int cx = x + dx[d];
            int cy = y + dy[d];

            if (cx < 0 || cy < 0 || cx >= N || cy >= N) {
                continue;
            }

            if (lands[cy][cx] == '*') {
                count++;
            }
        }

        return count;
    }
}