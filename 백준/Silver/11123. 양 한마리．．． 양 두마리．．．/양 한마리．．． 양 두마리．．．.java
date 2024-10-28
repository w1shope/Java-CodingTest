import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0,};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int[] inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int H = inputArr[0];
            int W = inputArr[1];

            char[][] arr = new char[H][W];
            for (int i = 0; i < H; i++) {
                String input = br.readLine();
                for (int j = 0; j < W; j++) {
                    arr[i][j] = input.charAt(j);
                }
            }

            boolean[][] visited = new boolean[H][W];
            int answer = 0;
            for (int y = 0; y < H; y++) {
                for (int x = 0; x < W; x++) {
                    if (!visited[y][x] && arr[y][x] == '#') {
                        answer++;
                        dfs(x, y, arr, visited);
                    }
                }
            }
            sb.append(answer + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(int x, int y, char[][] arr, boolean[][] visited) {
        if (isOutOfRange(x, y, arr)) { // 범위를 벗어난 경우
            return;
        }
        if (visited[y][x] || arr[y][x] == '.') { // 이미 방문했거나, 풀이 아닌 경우
            return;
        }

        visited[y][x] = true;
        for (int d = 0; d < 4; d++) {
            int cx = x + dx[d];
            int cy = y + dy[d];
            dfs(cx, cy, arr, visited);
        }
    }

    static boolean isOutOfRange(int x, int y, char[][] arr) {
        return x < 0 || y < 0 || y >= arr.length || x >= arr[0].length;
    }

}