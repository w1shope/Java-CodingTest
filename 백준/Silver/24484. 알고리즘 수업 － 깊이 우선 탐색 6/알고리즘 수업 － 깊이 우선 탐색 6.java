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

    static int visitCount = 1; // 방문 순서 카운트
    static int[] depthArr; // 노드의 깊이
    static int[] visitOrderArr; // 방문 순서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputArr[0];
        M = inputArr[1];
        R = inputArr[2]; // 시작 노드

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
            Collections.sort(nodes.get(i), Collections.reverseOrder()); // 내림차순 정렬
        }

        visited = new boolean[N + 1];
        depthArr = new int[N + 1];
        visitOrderArr = new int[N + 1];
        Arrays.fill(depthArr, -1); // 방문하지 않은 노드는 -1

        dfs(R, 0);

        long answer = 0;
        for (int i = 1; i <= N; i++) {
            answer += (long) depthArr[i] * visitOrderArr[i];
        }

        System.out.println(answer);
    }

    static void dfs(int v, int depthCount) {
        if (visited[v]) { // 이미 방문했다면
            return;
        }

        visited[v] = true; // 방문 처리
        depthArr[v] = depthCount; // 노드 깊이 기록
        visitOrderArr[v] = visitCount++; // 방문 순서 기록

        for (int node : nodes.get(v)) { // 연관된 노드 방문
            if (!visited[node]) {
                dfs(node, depthCount + 1);
            }
        }
    }
}