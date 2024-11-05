import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    static int answer;
    static int N, M;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            answer = 0;
            int[] inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            N = inputArr[0];
            M = inputArr[1];
            graph = new ArrayList<>();
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

            for (int i = 1; i <= N; i++) {
                boolean[] visited = new boolean[N + 1];
                visited[i] = true;
                dfs(visited, i, 1);
            }

            sb.append(answer + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(boolean[] visited, int idx, int visitedCount) {
        answer = Math.max(answer, visitedCount);

        for (int node : graph.get(idx)) { //연관된 노드들
            if (visited[node]) { // 중복 방문 금지
                continue;
            }

            visited[node] = true;
            dfs(visited, node, visitedCount + 1);
            visited[node] = false;
        }
    }
}