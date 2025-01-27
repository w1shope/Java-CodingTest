import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<List<Integer>> nodes = new ArrayList<>();
    static int lastNode;
    static Set<Integer> visited = new HashSet<>();
    static int moveCount = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            nodes.get(v).add(left);
            nodes.get(v).add(right);
        }

        findLastNode(1);
        traverse(1);

        System.out.println(moveCount);
    }

    static void findLastNode(int v) {
        lastNode = v;
        if (nodes.get(v).get(1) == -1) {
            return;
        }

        findLastNode(nodes.get(v).get(1));
    }

    static void traverse(int v) {
        moveCount++;
        visited.add(v);

        for (int child : nodes.get(v)) {
            if (child != -1) {
                traverse(child);
                moveCount++;
            }
            if (visited.size() == N && v == lastNode) {
                System.out.println(moveCount);
                System.exit(0);
            }
        }
    }

}