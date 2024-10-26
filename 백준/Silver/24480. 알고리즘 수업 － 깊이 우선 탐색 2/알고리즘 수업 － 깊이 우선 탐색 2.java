import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N, M, R;
    static List<List<Integer>> nodes = new ArrayList<>();
    static int[] answer;
    static int visitOrder = 1; // 방문 순서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputArr[0];
        M = inputArr[1];
        R = inputArr[2];

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
            nodes.get(v2).add(v1); // 양방향 그래프
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(nodes.get(i), Collections.reverseOrder());
        }

        answer = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        dfs(R, visited);

        for (int i = 1; i <= N; i++) {
            sb.append(answer[i] + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(int v, boolean[] visited) {
        if (visited[v]) {
            return;
        }

        answer[v] = visitOrder++; // [현재 노드] = 방문 순서
        visited[v] = true;
        for (int node : nodes.get(v)) { // 현재 노드와 연결된 모든 노드 탐색
            if (!visited[node]) {
                dfs(node, visited);
            }
        }
    }
}