import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<String> dq = new ArrayDeque<>();
        while (n-- > 0) {
            String input = br.readLine();

            if (input.startsWith("push_front")) {
                dq.offerFirst(input.split(" ")[1]);
                continue;
            } else if (input.startsWith("push_back")) {
                dq.offer(input.split(" ")[1]);
                continue;
            }

            switch (input) {
                case "pop_front":
                    sb.append(dq.isEmpty() ? -1 : dq.poll()).append("\n");
                    break;
                case "pop_back":
                    sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    sb.append(dq.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(dq.isEmpty() ? -1 : dq.peek()).append("\n");
                    break;
                default:
                    sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append("\n");
            }
        }

        System.out.print(sb);
    }
}