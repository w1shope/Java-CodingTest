import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        System.out.println(bfs());
    }

    static int bfs() {
        boolean[] visited = new boolean[N + 1];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0});

        while (!que.isEmpty()) {
            int[] poll = que.poll();
            int kg = poll[0];
            int count = poll[1];

            if (kg == N) {
                return count;
            }

            if (kg > N || visited[kg]) {
                continue;
            }

            visited[kg] = true;
            // 5kg
            que.offer(new int[]{kg + 5, count + 1});

            // 3kg
            que.offer(new int[]{kg + 3, count + 1});
        }
        return -1;
    }

}