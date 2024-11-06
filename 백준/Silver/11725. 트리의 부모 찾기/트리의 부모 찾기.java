import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int N;
    static List<List<Integer>> graph;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            int[] inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int v1 = inputArr[0];
            int v2 = inputArr[1];
            graph.get(v1).add(v2); 
            graph.get(v2).add(v1); // 무방향 그래프
        }

        answer = new int[N + 1];
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(answer[i] + "\n");
        }
        System.out.println(sb);
    }

    static void dfs(int node) {
        for (int v : graph.get(node)) { // 연결된 모든 노드 탐색
            if (answer[v] == 0) { // 부모가 결정되지 않았다면
                answer[v] = node; // v는 node로부터 파생된 노드
                dfs(v);
            }
        }
    }

}