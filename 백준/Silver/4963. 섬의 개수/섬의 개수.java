import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int[] inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();

            int w = inputArr[0]; // 너비
            int h = inputArr[1]; // 높이
            if (w == 0 && h == 0) { // 종료 조건
                break;
            }

            int[][] graph = new int[h][w];
            for (int i = 0; i < h; i++) {
                inputArr = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::valueOf)
                        .toArray();
                for (int j = 0; j < inputArr.length; j++) {
                    graph[i][j] = inputArr[j];
                }
            }

            int answer = 0;
            for (int y = 0; y < graph.length; y++) {
                for (int x = 0; x < graph[y].length; x++) {
                    if (graph[y][x] == 1) {
                        recur(graph, x, y);
                        answer++;
                    }
                }
            }

            sb.append(answer + "\n");
        }

        System.out.println(sb);

    }

    static void recur(int[][] graph, int x, int y) {
        if (isOutOfRange(graph, x, y)) { // 범위를 벗어난 경우
            return;
        }
        if (graph[y][x] == 0) { // 섬이 아닌 경우
            return;
        }

        graph[y][x] = 0;
        for (int d = 0; d < 8; d++) {
            int cx = x + dx[d];
            int cy = y + dy[d];
            recur(graph, cx, cy);
        }
    }

    static boolean isOutOfRange(int[][] graph, int x, int y) {
        return x < 0 || y < 0 || y >= graph.length || x >= graph[y].length;
    }
}