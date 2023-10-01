import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[][] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        numbers = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            input = br.readLine().split(" ");
            for (int j = 1; j <= n; j++)
                numbers[i][j] = numbers[i][j - 1] + Integer.parseInt(input[j - 1]);
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[1]);
            int y1 = Integer.parseInt(input[0]);
            int x2 = Integer.parseInt(input[3]);
            int y2 = Integer.parseInt(input[2]);
            sb.append(getSum(x1, y1, x2, y2) + "\n");
        }
        System.out.println(sb);

    }

    private static int getSum(int x1, int y1, int x2, int y2) {
        int total = 0;
        for (int y = y1; y <= y2; y++) {
            total += (numbers[y][x2] - numbers[y][x1 - 1]);
        }
        return total;
    }
}