import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int[][] arr;

    // 복좌하우
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        inputs = br.readLine().split(" ");
        int x = Integer.parseInt(inputs[1]);
        int y = Integer.parseInt(inputs[0]);
        int dir = Integer.parseInt(inputs[2]); // 0:북, 1:동, 2:남, 3:서
        dir = changeDir(dir);

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        // 로봇 청소기가 있는 칸은 빈 칸이다.
        while (true) {
            if (arr[y][x] == 1) { // 후진했는데 벽이라면 종료
                break;
            }

            if (arr[y][x] == 0) { // 청소되어 있지 않은 칸을
                arr[y][x] = 2; // 청소 시킨다.
            }

            if (existDirtyRoomAround(x, y)) { // 주변에 청소 안 된 공간이 있다면
                // 현재 방향(dir)에서 반시계로 방향 회전
                dir = (dir + 1) % 4;
                int tmpX = x + dx[dir];
                int tmpY = y + dy[dir];
                if (arr[tmpY][tmpX] == 0) { // 바라보는 방향이 청소가 안 되어 있다면
                    x = tmpX;
                    y = tmpY;
                }
            } else { // 주변이 모두 청소가 되어 있다면
                // 방향(dir)을 기준으로 후진 시킨다.
                int[] pos = back(x, y, dir);
                x = pos[1];
                y = pos[0];
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static int changeDir(int dir) {
        // 기존 dir -> 0: 북, 1: 동, 2:남, 3:서
        // 변경 dir -> 0:북, 1:서, 2:남, 3:동
        if (dir == 1) {
            dir = 3;
        } else if (dir == 3) {
            dir = 1;
        }
        return dir;
    }

    static int[] back(int x, int y, int dir) {
        // dir은 현재 바라보고 있는 방향
        if (dir == 0) { // 북
            y += 1; // 남쪽으로 후진
        } else if (dir == 1) { // 동
            x += 1; // 동쪽으로 후진
        } else if (dir == 2) { // 남
            y -= 1; // 북쪽으로 후진
        } else { // 동
            x -= 1; // 서쪽으로 후진
        }
        return new int[]{y, x};
    }

    static boolean isNotOutOfRange(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }

    // 현재 좌표에서 인접한 4곳에 청소되지 않은 방이 있는지?
    static boolean existDirtyRoomAround(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int cx = x + dx[d];
            int cy = y + dy[d];
            // 범위를 벗어나지 않고 && 청소가 안 되어있다면
            if (isNotOutOfRange(cx, cy) && arr[cy][cx] == 0) {
                return true;
            }
        }

        // 인접한 4곳 중에소 청소가 안 된 공간이 없음
        return false;
    }
}