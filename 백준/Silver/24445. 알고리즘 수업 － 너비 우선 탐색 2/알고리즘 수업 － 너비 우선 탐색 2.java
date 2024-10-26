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
    static List<List<Integer>> nodes = new ArrayList<>();

    static int[] answer;
    static int visitOrder = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
            nodes.get(v2).add(v1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(nodes.get(i), Collections.reverseOrder());
        }

        boolean[] visited = new boolean[N + 1];
        answer = new int[N + 1];
        bfs(R, visited);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i] + "\n");
        }
        System.out.println(sb);
    }

    static void bfs(int v, boolean[] visited) {
        visited[v] = true;
        answer[v] = visitOrder++;
        Queue<Integer> que = new LinkedList<>();
        que.offer(v);
        while (!que.isEmpty()) {
            int poll = que.poll();
            for (int node : nodes.get(poll)) {
                if (!visited[node]) {
                    que.offer(node);
                    visited[node] = true;
                    answer[node] = visitOrder++;
                }
            }
        }
    }
}