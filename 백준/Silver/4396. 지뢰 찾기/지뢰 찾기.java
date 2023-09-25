import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static final int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < tmp.length; j++)
                board[i][j] = tmp[j];
        }

        boolean meetLandMine = false;
        char[][] result = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '.') {
                    result[i][j] = '.';
                } else {
                    if (existLandMine(board, j, i))
                        meetLandMine = true;
                    result[i][j] = String.valueOf(traverseAround(board, j, i, n)).charAt(0);
                }
            }
        }

        if (meetLandMine)
            editResult(board, result);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                sb.append(result[i][j]);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int traverseAround(char[][] board, int x, int y, int size) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (ny < 0 || ny >= size || nx < 0 || nx >= size)
                continue;
            if (board[ny][nx] == '*')
                count++;
        }

        return count;
    }

    private static boolean existLandMine(char[][] board, int x, int y) {
        return board[y][x] == '*';
    }

    private static void editResult(char[][] board, char[][] result) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '*')
                    result[i][j] = '*';
            }
        }
    }
}