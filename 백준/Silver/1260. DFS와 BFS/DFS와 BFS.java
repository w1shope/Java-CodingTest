import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int N, M, V;
    static List<List<Integer>> nodes = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputArr[0];
        M = inputArr[1];
        V = inputArr[2];

        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int v1 = inputArr[0];
            int v2 = inputArr[1];
            nodes.get(v1).add(v2); // 양방향
            nodes.get(v2).add(v1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(nodes.get(i));
        }

        boolean[] visited = new boolean[N + 1];
        dfs(V, visited);
        sb.append("\n");

        bfs(V);
        sb.append("\n");

        System.out.println(sb.toString());
    }

    static void dfs(int v, boolean[] visited) {
        visited[v] = true; // 현재 노드 방문 처리
        sb.append(v + " ");
        for (int node : nodes.get(v)) { // v와 연결된 모든 노드들을 탐색
            if (!visited[node]) { // 연결된 노드가 방문하지 않았다면
                dfs(node, visited);
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> que = new LinkedList<>(); // 탐색할 노드를 담음
        boolean[] visited = new boolean[N + 1]; // 중복 방문 방지
        visited[v] = true; // 현재 노드 방문 처리

        que.offer(v); // 현재 노드 삽입
        while (!que.isEmpty()) {
            int poll = que.poll(); // 탐색할 노드 꺼냄
            sb.append(poll + " ");
            for (int node : nodes.get(poll)) { // 연결된 모든 노드 탐색
                if (!visited[node]) {
                    que.offer(node);
                    visited[node] = true; // 현재 노드 방문 처리
                }
            }
        }
    }
}