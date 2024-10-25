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
    static List<List<Integer>> nodes = new ArrayList<>();
    static boolean[] visited;
    static int answer;

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

        for (int i = 0; i < M; i++) {
            inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int v1 = inputArr[0];
            int v2 = inputArr[1];
            nodes.get(v1).add(v2); // 양방향 그래프
            nodes.get(v2).add(v1);
        }

        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) { // 방문하지 않은 노드라면
                answer++;
                bfs(i, visited);
            }
        }
        System.out.println(answer);

    }
    
    static void bfs(int v, boolean[] visited) {
        Queue<Integer> que = new LinkedList<>();
        visited[v] = true; // 현대 노드 방문 처리
        que.offer(v);
        while (!que.isEmpty()) { // 큐가 비면 탐색 종료
            int poll = que.poll();
            for (int node : nodes.get(poll)) {
                if (!visited[node]) { 
                    que.offer(node); // 현재 노드와 연결된 모든 노드를 큐에 삽입
                    visited[node] = true; // 방문 처리
                }
            }
        }
    }
}