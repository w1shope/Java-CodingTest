import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int N, M, K, X;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] distance = new int[300001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        K = Integer.parseInt(inputs[2]);
        X = Integer.parseInt(inputs[3]);

        // 노드 개수만큼 추가
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 저장
        for (int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            int v1 = Integer.parseInt(inputs[0]);
            int v2 = Integer.parseInt(inputs[1]);
            graph.get(v1).add(v2); // 방향 그래프
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            if (distance[i] == K) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb.length() == 0 ? -1 : sb);
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();

        // 시작 위치는 X이다.
        boolean[] visited = new boolean[N + 1];
        visited[X] = true;
        que.offer(X);

        while (!que.isEmpty()) {
            int v = que.poll();

            for (int relation : graph.get(v)) {
                if (!visited[relation]) {
                    visited[relation] = true;
                    distance[relation] = distance[v] + 1;
                    que.offer(relation);
                }
            }
        }

    }
}