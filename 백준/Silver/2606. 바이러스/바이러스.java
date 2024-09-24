import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int computerCnt;
    static int pairCnt;
    static List<List<Integer>> pairs = new ArrayList<>();
    static int result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computerCnt = Integer.parseInt(br.readLine());
        pairCnt = Integer.parseInt(br.readLine());
        visited = new boolean[computerCnt + 1];

        for (int i = 0; i <= computerCnt; i++) {
            pairs.add(new ArrayList<>());
        }

        for (int i = 0; i < pairCnt; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            pairs.get(start).add(end);
            /*
             * 1번이 아닌, 다른 번호에서 출발해서 1번과 동일한 네트워크에 속할 수 있다.
             * 4
             * 3
             * 2 3
             * 3 4
             * 1 4
             */
            pairs.get(end).add(start);
        }

        dfs(1);

        System.out.println(result - 1);
    }

    static void dfs(int num) {
        if (visited[num]) {
            return;
        }

        visited[num] = true;
        result++;

        for (int next : pairs.get(num)) {
            dfs(next);
        }
    }
}