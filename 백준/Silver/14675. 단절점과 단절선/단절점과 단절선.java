import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 그래프 초기화
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // n개의 간선 정보를 저장한다.
        String[] inputs = null;
        while (n-- > 1) {
            inputs = br.readLine().split(" ");
            int v1 = Integer.parseInt(inputs[0]);
            int v2 = Integer.parseInt(inputs[1]);

            // 무방향 그래프
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        // m개의 입력을 받으며, 단절점 or 단절선인지 확인한다.
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            inputs = br.readLine().split(" ");
            int t = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);

            if (t == 2) { // 단절선
                // 트리 구조이므로 반드시 2개의 그래프로 잘린다.
                sb.append("yes\n");
            } else { // 단절점
                // k번 노드와 연결된 노드가 2개 이상이어야, 해당 점을 기준으로 2개의 그래프로 잘린다.
                sb.append(graph.get(k).size() >= 2 ? "yes" : "no").append("\n");
            }
        }

        System.out.println(sb);
    }

}