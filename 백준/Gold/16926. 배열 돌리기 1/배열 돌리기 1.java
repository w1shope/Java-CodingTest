import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] arr;
    static int N, M, R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        R = Integer.parseInt(inputs[2]);

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        for (int i = 0; i < R; i++) {
            rotate();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static void rotate() {
        int[][] rotate = new int[N][M];
        for (int row = 0; row < Math.min(N, M) / 2; row++) {
            int r = row, c = row;

            while (r + 1 < N - row && rotate[r + 1][c] == 0) {
                rotate[r + 1][c] = arr[r][c];
                r++;
            }

            while (c + 1 < M - row && rotate[r][c + 1] == 0) {
                rotate[r][c + 1] = arr[r][c];
                c++;
            }

            while (r - 1 >= row && rotate[r - 1][c] == 0) {
                rotate[r - 1][c] = arr[r][c];
                r--;
            }

            while (c - 1 >= row && rotate[r][c - 1] == 0) {
                rotate[r][c - 1] = arr[r][c];
                c--;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = rotate[i][j];
            }
        }
    }
}