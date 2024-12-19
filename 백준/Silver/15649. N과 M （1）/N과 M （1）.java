import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N, M;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        // N, M 초기값 설정
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        // 방문 여부 배열 초기화
        visited = new boolean[N + 1];

        List<Integer> selected = new ArrayList<>();
        for (int s = 1; s <= N; s++) {
            // 방문 처리
            visited[s] = true;
            selected.add(s);
            dfs(selected);

            // 방문 취소
            visited[s] = false;
            selected.remove(selected.size() - 1);
        }

        System.out.println(sb);
    }

    static void print(List<Integer> list) {
        for (int num : list) {
            sb.append(num).append(" ");
        }
        sb.append("\n");
    }

    static void dfs(List<Integer> selected) {
        // M개를 선택한 경우 출력
        if (selected.size() == M) {
            print(selected);
            return;
        }

        for (int num = 1; num <= N; num++) {
            if (visited[num]) {
                continue;
            }

            // 방문처리
            visited[num] = true;
            selected.add(num);
            dfs(selected);

            // 방문 취소
            visited[num] = false;
            selected.remove(selected.size() - 1);
        }
    }
}