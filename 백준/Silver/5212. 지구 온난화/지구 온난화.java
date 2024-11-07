import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int R, C;
    static char[][] lands;
    static char[][] newLands;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        R = inputArr[0];
        C = inputArr[1];
        lands = new char[R][C];
        for (int i = 0; i < R; i++) {
            char[] cArr = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                lands[i][j] = cArr[j];
            }
        }

        newLands = new char[R][C]; // 50년 후 지도
        later50Years(); // 50년 후

        System.out.print(answer());
    }

    static String answer() {
        // 출력 좌표 구하기
        int sX = Integer.MAX_VALUE, eX = Integer.MIN_VALUE;
        int sY = Integer.MAX_VALUE, eY = Integer.MIN_VALUE;

        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                if (newLands[y][x] == 'X') {
                    sX = Math.min(sX, x);
                    eX = Math.max(eX, x);
                    sY = Math.min(sY, y);
                    eY = Math.max(eY, y);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int y = sY; y <= eY; y++) {
            for (int x = sX; x <= eX; x++) {
                sb.append(newLands[y][x]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    static void later50Years() {
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                int count = 0; // 인접한 곳의 바다 개수
                if (lands[y][x] == 'X') {
                    for (int d = 0; d < 4; d++) { // 인접한 곳
                        int cx = x + dx[d];
                        int cy = y + dy[d];
                        if (!isNotOutOfRange(cx, cy)) { // 지도 범위를 벗어나면 바다
                            count++;
                        }
                        if (isNotOutOfRange(cx, cy) && lands[cy][cx] == '.') {
                            count++;
                        }
                    }
                    if (count >= 3) {
                        newLands[y][x] = '.';
                    } else {
                        newLands[y][x] = 'X';
                    }
                } else {
                    newLands[y][x] = '.';
                }
            }
        }
    }

    static boolean isNotOutOfRange(int x, int y) {
        return x >= 0 && y >= 0 && x < C && y < R;
    }

}