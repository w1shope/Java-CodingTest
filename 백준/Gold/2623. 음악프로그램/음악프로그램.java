import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기값 저장
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        // 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 각 노드의 진입 차수 저장
        int[] inDegree = new int[n + 1];

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int s = Integer.parseInt(inputs[1]);
            for (int j = 2; j < inputs.length; j++) {
                int e = Integer.parseInt(inputs[j]);
                graph.get(s).add(e);
                inDegree[e]++;

                s = e;
            }
        }

        // 진입 차수가 0인 노드를 큐에 저장
        Queue<Integer> que = new LinkedList<>();
        for (int v = 1; v <= n; v++) {
            if (inDegree[v] == 0) {
                que.offer(v);
            }
        }

        // v번 노드와 연결된 node번 노드의 간선 제거
        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()) {
            Integer v = que.poll();
            sb.append(v).append("\n");

            // v번 노드와 연결된 노드와의 간선 제거
            for (int node : graph.get(v)) {
                inDegree[node]--;
                if (inDegree[node] == 0) {
                    que.offer(node);
                }
            }
        }

        // 방문하지 않는 노드가 있다면, 순서를 정하는 것이 불가능한 것이다.
        for (int v = 1; v <= n; v++) {
            if (inDegree[v] != 0) {
                System.out.println(0);
                return;
            }
        }

        // 가수들의 출연 순서 출력
        System.out.println(sb);
    }
}