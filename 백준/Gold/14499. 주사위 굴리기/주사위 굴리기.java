import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] arr;
    static int n, m, k;
    static int x, y;

    static int[] dice = new int[6];

    // (동 서 북 남)
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        // 배열
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        arr = new int[n][m];

        // 좌표
        y = Integer.parseInt(inputs[2]);
        x = Integer.parseInt(inputs[3]);

        k = Integer.parseInt(inputs[4]); // 명령어 개수

        // 배열 초기화
        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String input : br.readLine().split(" ")) {
            // 주사위를 돌린다
            int dir = Integer.parseInt(input) - 1;
            boolean isRoll = rollDice(dir);

            // 주사위를 굴렸다면
            if (isRoll) {
                // 땅에 적힌 숫자에 따라서 작업
                if (arr[y][x] == 0) {
                    arr[y][x] = dice[3];
                } else {
                    dice[3] = arr[y][x];
                    arr[y][x] = 0;
                }
                
                sb.append(dice[1] + "\n");
            }
        }
        System.out.println(sb);
    }

    static boolean rollDice(int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        // 주사위가 범위를 벗어나는 경우 무시한다.
        if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
            return false; // 주사위를 돌리지 못했음을 의미
        }

        // 주사위를 굴린다.
        // dice = {top1, top2, top3, top4, left1, left2}
        if (dir == 0) {
            right();
        } else if (dir == 1) {
            left();
        } else if (dir == 2) {
            up();
        } else {
            down();
        }

        x = nx;
        y = ny;

        return true; // 주사위를 돌렸음을 의미
    }

    static void right() {
        int tmp = dice[5];
        dice[5] = dice[1];
        dice[1] = dice[4];
        dice[4] = dice[3];
        dice[3] = tmp;
    }

    static void left() {
        int tmp = dice[4];
        dice[4] = dice[1];
        dice[1] = dice[5];
        dice[5] = dice[3];
        dice[3] = tmp;
    }

    static void up() {
        int tmp = dice[0];
        dice[0] = dice[1];
        dice[1] = dice[2];
        dice[2] = dice[3];
        dice[3] = tmp;
    }

    static void down() {
        int tmp = dice[3];
        dice[3] = dice[2];
        dice[2] = dice[1];
        dice[1] = dice[0];
        dice[0] = tmp;
    }
}