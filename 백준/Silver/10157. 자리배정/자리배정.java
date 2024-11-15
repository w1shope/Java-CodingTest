import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int R, C;
    static int K;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        R = Integer.parseInt(inputs[1]);
        C = Integer.parseInt(inputs[0]);
        arr = new int[R][C];

        K = Integer.parseInt(br.readLine());
        if (R * C < K) {
            System.out.println(0);
        } else {
            int[] answer = answer();
            System.out.println(answer[0] + " " + answer[1]);
        }
    }

    static int[] answer() {
        int x = 0, y = R - 1; // 시작 지점
        int count = 1;

        int dir = 0;
        while (count < K) {
            arr[y][x] = count;

            int cx = x + dx[dir];
            int cy = y + dy[dir];

            if (cx < 0 || cy < 0 || cx >= C || cy >= R || arr[cy][cx] != 0) {
                dir = (dir + 1) % 4;
                cx = x + dx[dir];
                cy = y + dy[dir];
            }

            x = cx;
            y = cy;
            count++;
        }

        return new int[]{x + 1, R - y};
    }
}