import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[15][15];
        for (int i = 1; i < 15; i++) {
            arr[0][i] = i;
        }

        for (int row = 1; row <= 14; row++) {
            for (int col = 1; col <= 14; col++) {
                for (int j = 1; j <= col; j++) {
                    arr[row][col] += arr[row - 1][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int row = Integer.parseInt(br.readLine());
            int col = Integer.parseInt(br.readLine());

            sb.append(arr[row][col]).append("\n");
        }

        System.out.println(sb);
    }
}