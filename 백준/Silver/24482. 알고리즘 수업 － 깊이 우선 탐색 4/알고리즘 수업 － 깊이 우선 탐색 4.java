import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N, M, R;
    static int[] answer;
    static List<List<Integer>> nodes = new ArrayList<>();

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
            nodes.get(v2).add(v1); // 양방향
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(nodes.get(i), Collections.reverseOrder()); // 오름차순 정렬
        }

        answer = new int[N + 1];
        Arrays.fill(answer, -1);

        boolean[] visited = new boolean[N + 1];
        dfs(visited, 0, R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i] + "\n");
        }

        System.out.println(sb);
    }

    /**
     * 입력 : 5 2 1 1 2 1 3 출력 : 0 1 1 -1 -1
     */
    static void dfs(boolean[] visited, int visitOrder, int node) {
        if (visited[node]) { // 이미 방문했다면
            return;
        }

        visited[node] = true; // 방문 처리
        answer[node] = visitOrder++; // 방문 순서 저장

        for (int v : nodes.get(node)) {
            dfs(visited, visitOrder, v);
        }
    }
}