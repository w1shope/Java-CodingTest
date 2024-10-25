import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int N;
    static List<List<Integer>> nodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            int[] inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int v1 = inputArr[0];
            int v2 = inputArr[1];
            nodes.get(v1).add(v2);
            nodes.get(v2).add(v1);
        }

        int[] arr = new int[N + 1];
        bfs(1, new boolean[N + 1], arr);

        for (int i = 2; i <= N; i++) {
            sb.append(arr[i] + "\n");
        }

        System.out.println(sb);
    }

    static void bfs(int v, boolean[] visited, int[] arr) {
        visited[v] = true; // 현재 노드 방문 처리
        Queue<Integer> que = new LinkedList<>();
        que.offer(v);

        while (!que.isEmpty()) {
            int poll = que.poll();
            for (int node : nodes.get(poll)) {
                if (visited[node]) {
                    continue;
                }
                visited[node] = true;
                que.offer(node);
                arr[node] = poll;
            }
        }
    }


}