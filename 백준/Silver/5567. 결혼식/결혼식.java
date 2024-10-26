import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<List<Integer>> nodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 동기 수
        int m = Integer.parseInt(br.readLine()); // 간선 개수

        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int[] inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int v1 = inputArr[0];
            int v2 = inputArr[1];
            nodes.get(v1).add(v2);
            nodes.get(v2).add(v1); // 양방향
        }

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        for (int node : nodes.get(1)) { // 상근이의 친구를 모두 탐색
            visited[node] = true; // true : 결혼식에 참여
            for (int friendNode : nodes.get(node)) { // 친구의 친구까지 탐색
                visited[friendNode] = true; // 친구의 친구까지 결혼식에 참여
            }
        }

        int answer = 0;
        for (boolean isVisited : visited) {
            if (isVisited) {
                answer++;
            }
        }

        System.out.println(answer - 1);
    }
}