import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] bingo = new int[5][5];
        for (int i = 0; i < 5; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 5; j++)
                bingo[i][j] = Integer.parseInt(input[j]);
        }

        int count = 0;
        for (int i = 0; i < 5; i++) {
            String[] input = br.readLine().split(" ");
            int bingoCount = 0;
            for (int j = 0; j < input.length; j++) {
                checkNum(bingo, Integer.parseInt(input[j]));
                count++;

                bingoCount += isDiagonalBingo(bingo);
                bingoCount += isRowBingo(bingo);
                bingoCount += isColumnBingo(bingo);
                if (bingoCount >= 3) {
                    System.out.println(count);
                    return;
                }
                bingoCount = 0;
            }
        }
    }

    private static void checkNum(int[][] bingo, int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == num) {
                    bingo[i][j] = -1;
                    return;
                }
            }
        }
    }

    private static int isDiagonalBingo(int[][] bingo) {
        int count = 0;

        int x = 0, y = 0, tmp = 0;
        while (x < 5 && y < 5) {
            if (bingo[y][x] != -1)
                break;
            x++;
            y++;
            tmp++;
        }
        if (tmp == 5)
            count++;

        x = 4;
        y = 0;
        tmp = 0;
        while (true) {
            if (y > 4 || x < 0)
                break;
            if (bingo[y][x] != -1)
                break;
            x--;
            y++;
            tmp++;
        }
        if (tmp == 5)
            count++;

        return count;
    }

    private static int isRowBingo(int[][] bingo) {
        int count = 0;
        for (int y = 0; y < 5; y++) {
            if (Arrays.stream(bingo[y]).filter(num -> num == -1).count() == 5)
                count += 1;
        }
        return count;
    }

    private static int isColumnBingo(int[][] bingo) {
        int count = 0;
        for (int y = 0; y < 5; y++) {
            int tmp = 0;
            for (int x = 0; x < 5; x++) {
                if (bingo[x][y] == -1)
                    tmp += 1;
            }
            if (tmp == 5)
                count += 1;
        }
        return count;
    }
}