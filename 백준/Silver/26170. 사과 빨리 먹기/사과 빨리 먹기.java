import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int answer = Integer.MAX_VALUE; // 최소 이동 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] graph = new int[5][5];
        for (int i = 0; i < graph.length; i++) {
            int[] inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            for (int j = 0; j < graph[i].length; j++) {
                graph[i][j] = inputArr[j];
            }
        }

        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        int r = inputArr[0];
        int c = inputArr[1];

        recur(graph, c, r, 0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(answer);
        }
    }

    static void recur(int[][] graph, int x, int y, int moveCount, int appleCount) {
        if (y < 0 || x < 0 || x >= 5 || y >= 5) { // 배열의 범위를 벗어난 경우 탐색 종료
            return;
        }
        if (graph[y][x] == -1) {
            return;
        }

        if (graph[y][x] == 1) { // 현재 위치에 사과가 있는 경우
            appleCount++;
        }

        if (appleCount == 3) { // 사과 3개를 먹은 경우 탐색 종료
            answer = Math.min(answer, moveCount);
            return;
        }

        // 상하좌우 이동
        int tmp = graph[y][x];
        graph[y][x] = -1;
        recur(graph, x, y - 1, moveCount + 1, appleCount);
        recur(graph, x, y + 1, moveCount + 1, appleCount);
        recur(graph, x - 1, y, moveCount + 1, appleCount);
        recur(graph, x + 1, y, moveCount + 1, appleCount);
        graph[y][x] = tmp;
    }

}