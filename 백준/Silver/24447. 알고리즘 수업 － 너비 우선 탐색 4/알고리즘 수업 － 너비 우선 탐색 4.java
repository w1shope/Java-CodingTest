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
    static int[] visitOrderArr;

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

        answer = new int[N + 1];
        visitOrderArr = new int[N + 1];
        Arrays.fill(answer, -1);
        bfs(R);

        long result = 0;
        for (int i = 1; i <= N; i++) {
            result += (long) visitOrderArr[i] * answer[i];
        }

        System.out.println(result);
    }

    static void bfs(int startNode) {
        boolean[] visited = new boolean[N + 1];
        visited[startNode] = true;

        Queue<Integer> que = new LinkedList<>();
        que.offer(startNode);
        answer[startNode] = 0;

        int visitOrder = 1; // 노드 방문 순서
        visitOrderArr[startNode] = visitOrder++;

        while (!que.isEmpty()) {
            int poll = que.poll();
            for (int node : nodes.get(poll)) {
                int parentNodeDepth = answer[poll];
                if (!visited[node]) {
                    answer[node] = parentNodeDepth + 1; // 현재 노드의 depth는 부모 노드 depth + 1
                    visited[node] = true;
                    visitOrderArr[node] = visitOrder++; // 현재 노드의 방문 순서 기록
                    que.offer(node);
                }
            }
        }
    }
}