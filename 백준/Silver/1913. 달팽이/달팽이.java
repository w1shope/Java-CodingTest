import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int findNum = Integer.parseInt(br.readLine());

        map = new int[n][n];
        fillMap(n * n);

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        String[] find = findNum(findNum);
        sb.append(find[0] + " " + find[1]);

        System.out.println(sb);
    }

    private static void fillMap(int startNum) {
        int x = 0, y = -1, d = 0; // y가 -1부터 시작하는 이유는 dy[0] == 1이기 때문에 y + dy[0] = 0이므로 (0,0)부터 숫자를 채우게 된다.
        while (true) {
            if (startNum == 0)
                break;
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (ny < 0 || ny >= map.length || nx < 0 || nx >= map[ny].length || map[ny][nx] != 0) {
                d = (d + 1) % 4;
                continue;
            }
            map[ny][nx] = startNum--;
            y = ny;
            x = nx;
        }
    }

    private static String[] findNum(int findNum) {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] == findNum)
                    return new String[]{y + 1 + "", x + 1 + ""};
            }
        }
        return null;
    }
}
