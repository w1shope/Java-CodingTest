import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int N, M;
    static int S, E;

    static List<List<Integer>> nodes = new ArrayList<>();
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputArr[0];
        M = inputArr[1];

        inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        S = inputArr[0];
        E = inputArr[1];

        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int v1 = inputArr[0];
            int v2 = inputArr[1];
            nodes.get(v1).add(v2);
            nodes.get(v2).add(v1);
        }

        answer = E - S;
        int result = bfs(S, E);

        System.out.println(result);
    }

    static int bfs(int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int v = current[0];
            int moveCount = current[1];

            if (v == end) {
                return moveCount;
            }

            if (v - 1 >= 0 && !visited[v - 1]) {
                queue.offer(new int[]{v - 1, moveCount + 1}); // 왼쪽으로 1칸 이동
                visited[v - 1] = true;
            }
            if (v + 1 <= N && !visited[v + 1]) {
                queue.offer(new int[]{v + 1, moveCount + 1}); // 오른쪽으로 1칸 이동
                visited[v + 1] = true;
            }
            for (int node : nodes.get(v)) {
                if (!visited[node]) {
                    queue.offer(new int[]{node, moveCount + 1}); // 텔레포트 
                    visited[node] = true;
                }
            }
        }
        return -1; // 도달 불가능한 경우
    }
}