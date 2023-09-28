import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static char[][] board;
    private static List<int[]> bombCoordinate = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int n = Integer.parseInt(input[2]);

        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++)
                board[i][j] = str.charAt(j);
        }

        int time = 0;
        for (int i = 0; i < n - 1; i++) {
            if (time == 0) {
                fillBoard();
                time = 1;
            } else {
                explodeBomb();
                time = 0;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                sb.append(board[i][j]);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void fillBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O')
                    bombCoordinate.add(new int[]{j, i});
                board[i][j] = 'O';
            }
        }
    }

    private static void explodeBomb() {
        for (int[] coordinate : bombCoordinate) {
            int x = coordinate[0];
            int y = coordinate[1];
            board[y][x] = '.';
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[ny].length)
                    continue;
                board[ny][nx] = '.';
            }
        }
        bombCoordinate.clear();
    }
}