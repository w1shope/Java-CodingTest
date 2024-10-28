import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
            nodes.get(v2).add(v1);
        }

        answer = new int[N + 1];
        Arrays.fill(answer, -1);

        bfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i] + "\n");
        }

        System.out.println(sb);
    }

    static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        answer[startNode] = 0; // 시작 노드는 거리가 0

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int currentDepth = answer[current]; // 현재 노드의 깊이

            for (int nextNode : nodes.get(current)) {
                if (answer[nextNode] == -1) { // 방문하지 않은 노드만 처리
                    answer[nextNode] = currentDepth + 1;
                    queue.offer(nextNode);
                }
            }
        }
    }
}