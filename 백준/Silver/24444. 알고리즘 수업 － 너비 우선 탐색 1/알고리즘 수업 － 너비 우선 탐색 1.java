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

    static int N, M, R;
    static List<List<Integer>> graph = new ArrayList<>();

    static int visitOrder = 1;
    static int[] answer; // 방문 순서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputArr[0];
        M = inputArr[1];
        R = inputArr[2];

        answer = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int v1 = inputArr[0];
            int v2 = inputArr[1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1); // 양방향 그래프
        }

        for (int i = 1; i <= N; i++) { // 인접 정점은 오름차순으로 방문
            Collections.sort(graph.get(i));
        }

        boolean[] visited = new boolean[N + 1];
        bfs(R, visited);

        for (int i = 1; i <= N; i++) {
            sb.append(answer[i] + "\n");
        }

        System.out.println(sb);
    }

    static void bfs(int v, boolean[] visited) {
        visited[v] = true;
        answer[v] = visitOrder++; // [현재 노드] = 방문 순서
        Queue<Integer> que = new LinkedList<>();
        que.offer(v);
        while (!que.isEmpty()) {
            int poll = que.poll();
            for (int node : graph.get(poll)) {
                if (!visited[node]) {
                    visited[node] = true;
                    answer[node] = visitOrder++; // [현재 노드] = 방문 순서
                    que.offer(node);
                }
            }
        }
    }
}