import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    static int[][] arr;
    static final int SIZE = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            t = Integer.parseInt(br.readLine());
            arr = new int[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                String[] inputs = br.readLine().split(" ");
                for (int j = 0; j < SIZE; j++) {
                    arr[i][j] = Integer.parseInt(inputs[j]);
                }
            }

            sb.append("#" + t + " " + answer()).append("\n");
        }

        System.out.println(sb);
    }

    static int answer() {
        int max = 0;

        // 가로
        for (int y = 0; y < SIZE; y++) {
            max = Math.max(max, getRowSum(arr[y]));
        }

        // 세로
        for (int x = 0; x < SIZE; x++) {
            max = Math.max(max, getColSum(x, 0));
        }

        // 대각선
        max = Math.max(max, Math.max(getLeftDiagonalSum(), getRightDiagonalSum()));

        return max;
    }

    static int getRowSum(int[] rowArr) {
        int sum = 0;
        for (int i = 0; i < SIZE; i++) {
            sum += rowArr[i];
        }
        return sum;
    }

    static int getColSum(int x, int y) {
        int sum = 0;
        while (y < SIZE) {
            sum += arr[y][x];
            y++;
        }
        return sum;
    }

    static int getRightDiagonalSum() {
        int sum = 0;
        for (int i = 0; i < SIZE; i++) {
            sum += arr[i][i];
        }
        return sum;
    }

    static int getLeftDiagonalSum() {
        int sum = 0;
        for (int i = SIZE - 1; i >= 0; i--) {
            sum += arr[i][i];
        }
        return sum;
    }
}