import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            que.offer(i);
        }

        StringBuilder sb = new StringBuilder();

        sb.append("<");
        while (que.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                que.offer(que.poll());
            }

            sb.append(que.poll()).append(", ");
        }
        sb.append(que.poll());
        sb.append(">");

        System.out.println(sb);
    }
}