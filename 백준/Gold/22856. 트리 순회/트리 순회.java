import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {


    static int N;
    static List<List<Integer>> graph = new ArrayList<>();
    static int count = -1;
    static int lastNode;
    static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int parent = Integer.parseInt(inputs[0]);
            int left = Integer.parseInt(inputs[1]);
            int right = Integer.parseInt(inputs[2]);

            graph.get(parent).add(left);
            graph.get(parent).add(right);
            visited.add(parent);
        }

        findLastNode(1);
        dfs(1);
    }

    static void findLastNode(int node) {
        if (graph.get(node).get(0) != -1) {
            findLastNode(graph.get(node).get(0));
        }
        lastNode = node;
        if (graph.get(node).get(1) != -1) {
            findLastNode(graph.get(node).get(1));
        }
    }

    static void dfs(int node) {
        count++;
        visited.remove(node);

        for (int child : graph.get(node)) {
            if (child != -1) {
                dfs(child);
                count++;
            }
        }

        if (visited.isEmpty() && node == lastNode) {
            System.out.println(count);
            System.exit(0);
        }
    }
}