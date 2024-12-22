import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(1);
            return;
        }

        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            que.offer(i);
        }

        while (!que.isEmpty()) {
            que.pollFirst();
            if (que.size() == 1) {
                break;
            }

            que.offer(que.poll());
        }

        System.out.print(que.poll());
    }
}