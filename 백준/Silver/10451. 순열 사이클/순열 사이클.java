import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            boolean[] visited = new boolean[N];
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(input[i]) - 1);
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    result++;
                    dfs(i, list, visited);
                }
            }

            sb.append(result + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(int num, List<Integer> list, boolean[] visited) {
        if (visited[num]) { // 탐색을 마치고 원위치로 돌아온 경우 더이상 탐색하지 않는다.
            return;
        }
        visited[num] = true;
        dfs(list.get(num), list, visited);
    }
    
}