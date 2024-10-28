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
    static boolean[] visited;

    static int visitOrder = 1;
    static int[] visitOrderArr;
    static int[] depthArr;


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
            Collections.sort(nodes.get(i));
        }

        visited = new boolean[N + 1];
        visitOrderArr = new int[N + 1];
        depthArr = new int[N + 1];

        Arrays.fill(depthArr, -1);

        dfs(R, 0);

        long result = 0;
        for (int i = 1; i <= N; i++) {
            result += (long) visitOrderArr[i] * depthArr[i];
        }
        System.out.println(result);
    }

    static void dfs(int v, int depth) {
        if (visited[v]) {
            return;
        }

        visited[v] = true;
        visitOrderArr[v] = visitOrder++; // 방문 순서 기록
        depthArr[v] = depth++; // 노드 깊이 기록
        for (int node : nodes.get(v)) {
            dfs(node, depth);
        }
    }
}