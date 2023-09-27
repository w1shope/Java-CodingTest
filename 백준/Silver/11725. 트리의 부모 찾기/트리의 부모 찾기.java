import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        visited = new boolean[n + 1];
        result = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        dfs(1);

        Arrays.stream(result).skip(2).forEach(v -> sb.append(v + "\n"));
        System.out.println(sb);
    }

    private static void dfs(int v) {
        visited[v] = true;
        for (int node : graph.get(v)) {
            if (!visited[node]) {
                result[node] = v;
                dfs(node);
            }
        }
    }
}