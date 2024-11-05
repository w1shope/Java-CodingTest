import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {

    static final int SIZE = 100;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            sb.append("#" + t + " ");
            br.readLine();

            arr = new int[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::valueOf)
                        .toArray();
            }

            sb.append(answer() + "\n");
        }

        System.out.println(sb);
    }

    static int answer() {
        return Math.max(Math.max(getRowSumMax(), getColSumMax()),
                Math.max(getRightDiagonalMax(), getLeftDiagonalMax()));
    }

    static int getRowSumMax() {
        int result = Integer.MIN_VALUE;
        for (int y = 0; y < SIZE; y++) {
            int tmp = 0;
            for (int x = 0; x < SIZE; x++) {
                tmp += arr[y][x];
            }
            result = Math.max(result, tmp);
        }
        return result;
    }

    static int getColSumMax() {
        int result = Integer.MIN_VALUE;
        for (int x = 0; x < SIZE; x++) {
            int tmp = 0;
            for (int y = 0; y < SIZE; y++) {
                tmp += arr[y][x];
            }
            result = Math.max(result, tmp);
        }
        return result;
    }

    static int getRightDiagonalMax() {
        int result = 0;
        for (int y = 0; y < SIZE; y++) {
            result += arr[y][y];
        }
        return result;
    }

    static int getLeftDiagonalMax() {
        int result = 0;
        for (int y = SIZE - 1; y >= 0; y--) {
            result += arr[y][y];
        }
        return result;
    }

}