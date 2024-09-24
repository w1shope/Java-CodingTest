import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N, K;
    static List<Integer> list = new ArrayList<>();
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        dfs(0);

        if (visited[K]) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }

    }

    static void dfs(int num) {
        if (visited[num]) {
            return;
        }
        if (num == K) {
            visited[num] = true;
            return;
        }
        visited[num] = true;
        result++;
        dfs(list.get(num));
    }
}