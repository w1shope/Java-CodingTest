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
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 정보 저장
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        K = Integer.parseInt(inputs[2]);
        X = Integer.parseInt(inputs[3]);

        // 간선 정보 저장
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            int v1 = Integer.parseInt(inputs[0]);
            int v2 = Integer.parseInt(inputs[1]);
            graph.get(v1).add(v2); // 방향 그래프
        }

        distance = new int[N + 1]; // X번 노드로부터의 최단 거리 저장
        bfs();

        // X로부터 최단 거리가 K인 노드 번호 출력
        StringBuilder sb = new StringBuilder();
        for (int v = 1; v <= N; v++) {
            if (distance[v] == K) {
                sb.append(v).append("\n");
            }
        }

        // 최단 거리가 K인 노드가 없다면 -1 출력
        System.out.println(sb.length() == 0 ? -1 : sb.toString());
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[N + 1]; // 방문 여부

        // X번 노드부터 탐색 시작
        visited[X] = true;
        que.offer(X);

        while (!que.isEmpty()) {
            int v = que.poll();

            // v와 연결된 노드를 탐색
            for (int relation : graph.get(v)) {
                // 연결된 노드 중에 방문하지 않는 노드일 경우,
                // 방문 후 이동 거리 저장
                if (!visited[relation]) {
                    visited[relation] = true;
                    distance[relation] = distance[v] + 1;
                    que.offer(relation);
                }
            }
        }
    }
}