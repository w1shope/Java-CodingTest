import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int[][] graph;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        graph = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);
            paintSquare(x1, y1, x2, y2);
        }

        int areaCount = 0;
        List<Integer> result = new ArrayList<>();
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (graph[y][x] == 0 && !visited[y][x]) {
                    dfs(x, y);
                    areaCount++;
                    result.add(count);
                    count = 0;
                }
            }
        }

        sb.append(areaCount + "\n");
        result.stream().sorted().forEach(num -> sb.append(num + " "));

        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        visited[y][x] = true;
        count++;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= graph.length || nx < 0 || nx >= graph[ny].length)
                continue;
            if (graph[ny][nx] == 0 && !visited[ny][nx])
                dfs(nx, ny);
        }
    }

    private static void paintSquare(int x1, int y1, int x2, int y2) {
        for (int y = y1; y < y2; y++) {
            for (int x = x1; x < x2; x++) {
                graph[y][x] = 1;
                visited[y][x] = true;
            }
        }
    }
}