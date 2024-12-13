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
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");

            String order = inputs[0];
            if (order.equals("push")) {
                dq.offer(inputs[1]);
            } else {
                String print = "";
                if (order.equals("pop")) {
                    print = dq.isEmpty() ? "-1" : dq.poll();
                } else if (order.equals("size")) {
                    print = dq.size() + "";
                } else if (order.equals("empty")) {
                    print = dq.isEmpty() ? "1" : "0";
                } else if (order.equals("front")) {
                    print = dq.isEmpty() ? "-1" : dq.peekFirst();
                } else {
                    print = dq.isEmpty() ? "-1" : dq.peekLast();
                }
                sb.append(print).append("\n");
            }
        }

        System.out.println(sb);
    }
}