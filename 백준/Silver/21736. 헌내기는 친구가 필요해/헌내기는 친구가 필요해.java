import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static char[][] graph;
    static int answer;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputArr[0];
        M = inputArr[1];
        graph = new char[N][M];

        int startPosX = -1, startPosY = -1; // 시작 x, y좌표
        for (int i = 0; i < N; i++) {
            String info = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = info.charAt(j);
                if (c == 'I') {
                    startPosX = j;
                    startPosY = i;
                }
                graph[i][j] = c;
            }
        }

        boolean[][] visited = new boolean[N][M];
        traverse(startPosX, startPosY, visited);

        if (answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);
        }
    }

    static void traverse(int x, int y, boolean[][] visited) {
        if (isOutOfRange(x, y) || graph[y][x] == 'X' || visited[y][x]) {
            return;
        }
        if (graph[y][x] == 'P') {
            answer++;
        }

        visited[y][x] = true;
        for (int d = 0; d < 4; d++) {
            int cx = x + dx[d];
            int cy = y + dy[d];
            traverse(cx, cy, visited);
        }
    }

    static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || y >= N || x >= M;
    }
}