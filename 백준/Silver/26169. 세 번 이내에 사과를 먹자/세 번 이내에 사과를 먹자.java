import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] graph = new int[5][5];
        for (int i = 0; i < 5; i++) {
            int[] inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            for (int j = 0; j < 5; j++) {
                graph[i][j] = inputArr[j];
            }
        }

        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        int y = inputArr[0];
        int x = inputArr[1];

        recur(graph, x, y, 0, 0);

        System.out.println(answer);
    }

    static void recur(int[][] graph, int x, int y, int moveCount, int appleCount) {
        if (y < 0 || x < 0 || y >= 5 || x >= 5) { // 배열의 범위를 벗어난 경우
            return;
        }
        if (graph[y][x] == -1) { // 현재 위치에 장애물이 설치된 경우
            return;
        }
        if (moveCount >= 4) { // 세 번 이하의 이동으로 사과 2개를 못 먹은 경우
            return;
        }

        if (graph[y][x] == 1) { // 현재 위치에 사과가 있는 경우
            appleCount++;
        }
        if (appleCount == 2) { // 사과를 2개 먹은 경우
            answer = 1;
            return;
        }

        int tmp = graph[y][x];
        graph[y][x] = -1; // 현재 위치에 장애물 설치

        // 상하좌우 이동
        recur(graph, x, y - 1, moveCount + 1, appleCount);
        recur(graph, x, y + 1, moveCount + 1, appleCount);
        recur(graph, x - 1, y, moveCount + 1, appleCount);
        recur(graph, x + 1, y, moveCount + 1, appleCount);
        graph[y][x] = tmp;
    }
}