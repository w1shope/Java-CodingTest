import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<String> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String[] inputs = br.readLine().split(" ");
            String order = inputs[0];
            if (inputs.length == 2) { // push_front, push_back
                if (order.equals("push_front")) {
                    dq.offerFirst(inputs[1]);
                } else {
                    dq.offerLast(inputs[1]);
                }
            } else {
                if (order.equals("pop_front")) {
                    sb.append(dq.isEmpty() ? -1 : dq.pollFirst()).append("\n");
                } else if (order.equals("pop_back")) {
                    sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append("\n");
                } else if (order.equals("size")) {
                    sb.append(dq.size() + "\n");
                } else if (order.equals("empty")) {
                    sb.append(dq.isEmpty() ? 1 : 0).append("\n");
                } else if (order.equals("front")) {
                    sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append("\n");
                } else {
                    sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }

}