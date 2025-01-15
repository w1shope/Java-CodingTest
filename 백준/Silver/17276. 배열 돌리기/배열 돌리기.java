import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, D;
    static int[][] original;
    static int[][] rotate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] inputs = br.readLine().split(" ");
            N = Integer.parseInt(inputs[0]);
            D = Integer.parseInt(inputs[1]);

            original = new int[N][N];
            rotate = new int[N][N];
            for (int i = 0; i < N; i++) {
                inputs = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    original[i][j] = Integer.parseInt(inputs[j]);
                    rotate[i][j] = original[i][j];
                }
            }

            if (D < 0) {
                D += 360;
            }
            D /= 45;

            while (D-- > 0) {
                cw();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(original[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    static void cw() {
        for (int i = 0; i < N; i++) {
            rotate[i][N / 2] = original[i][i];
            rotate[i][i] = original[N / 2][i];
            rotate[N / 2][i] = original[N - i - 1][i];
            rotate[N - i - 1][i] = original[N - i - 1][N / 2];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                original[i][j] = rotate[i][j];
            }
        }
    }
}