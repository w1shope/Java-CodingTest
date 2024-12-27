import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static int n, m;
    static int[] orders;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기값 저장
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        orders = new int[n + 1]; // 선수 과목 순서 저장
        Arrays.fill(orders, 1);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // m개의 간선 정보를 저장
        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int v1 = Integer.parseInt(inputs[0]);
            int v2 = Integer.parseInt(inputs[1]);
            graph.get(v1).add(v2);
        }

        // 1번 노드부터 탐색
        for (int i = 1; i <= n; i++) {
            int order = orders[i] + 1;
            for (int v : graph.get(i)) {
                orders[v] = Math.max(orders[v], order);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(orders[i]).append(" ");
        }

        System.out.println(sb);
    }
}