import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        List<Integer> answer = new ArrayList<>();
        answer.add(N);

        List<Integer> result = bfs(answer);
        StringBuilder sb = new StringBuilder();
        sb.append((result.size() - 1) + "\n");
        for (int num : result) {
            sb.append(num + " ");
        }
        System.out.println(sb);
    }

    static List<Integer> bfs(List<Integer> result) {
        Queue<List<Integer>> que = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        que.offer(result);
        visited[N] = true;
        while (!que.isEmpty()) {
            List<Integer> list = que.poll();
            int num = list.get(list.size() - 1);
            if (num == 1) { // 종료 조건
                return list;
            }

            if (num % 3 == 0 && !visited[num / 3]) {
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(num / 3);
                que.offer(tmp);
                visited[num / 3] = true;
            }
            if (num % 2 == 0 && !visited[num / 2]) {
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(num / 2);
                que.offer(tmp);
                visited[num / 2] = true;
            }
            if (num - 1 >= 1 && !visited[num - 1]) {
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(num - 1);
                que.offer(tmp);
                visited[num - 1] = true;
            }
        }

        return null;
    }

}