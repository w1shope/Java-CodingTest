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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputArr[0];
        M = inputArr[1];

        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }

        inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        S = inputArr[0];
        E = inputArr[1];

        for (int i = 0; i < M; i++) {
            inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int v1 = inputArr[0];
            int v2 = inputArr[1];
            nodes.get(v1).add(v2);
            nodes.get(v2).add(v1);
        }

        System.out.println(bfs(0, S));
    }

    static int bfs(int moveCount, int startNode) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{startNode, moveCount}); // 방문 노드, 이동 횟수

        boolean[] visited = new boolean[N + 1];
        visited[startNode] = true;
        while (!que.isEmpty()) {
            int[] poll = que.poll();
            int v = poll[0];

            if (v == E) {
                return poll[1];
            }

            if (v - 1 >= 0 && !visited[v - 1]) {
                visited[v - 1] = true;
                que.offer(new int[]{v - 1, poll[1] + 1});
            }
            if (v + 1 <= N && !visited[v + 1]) {
                visited[v + 1] = true;
                que.offer(new int[]{v + 1, poll[1] + 1});
            }
            for (int node : nodes.get(v)) {
                if (!visited[node]) {
                    visited[node] = true;
                    que.offer(new int[]{node, poll[1] + 1});
                }
            }
        }
        return -1;
    }

}