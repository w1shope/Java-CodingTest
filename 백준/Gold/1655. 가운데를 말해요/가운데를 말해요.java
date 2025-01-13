import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (flag) {
                max.offer(num);
            } else {
                min.offer(num);
            }
            flag = !flag;

            if (!min.isEmpty()) {
                if (max.peek() > min.peek()) {
                    min.offer(max.poll());
                    max.offer(min.poll());
                }
            }

            sb.append(max.peek()).append("\n");
        }

        System.out.print(sb);
    }
}