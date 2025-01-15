import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, D;
    static int[][] arr;
    static int[][] rotate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] inputs = br.readLine().split(" ");
            N = Integer.parseInt(inputs[0]);

            // 문제에서는 0 <= D <= 360이지만,
            // D > 360이 가능했더라면 (D + 360) % 360 / 45를 했어야함
            D = (Integer.parseInt(inputs[1]) + 360) / 45;

            arr = new int[N][N];
            rotate = new int[N][N];
            for (int i = 0; i < N; i++) {
                inputs = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(inputs[j]);
                    rotate[i][j] = arr[i][j];
                }
            }

            while (D-- > 0) {
                cw();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    static void cw() {
        int mid = N / 2;
        for (int i = 0; i < N; i++) {
            rotate[i][mid] = arr[i][i];
            rotate[N - i - 1][i] = arr[N - i - 1][mid];
            rotate[mid][i] = arr[N - i - 1][i];
            rotate[i][i] = arr[mid][i];
        }

        for (int i = 0; i < N; i++) {
            arr[i] = rotate[i].clone();
        }
    }
}