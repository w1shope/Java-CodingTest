import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (min.size() == max.size()) {
                max.offer(num);
            } else {
                min.offer(num);
            }

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