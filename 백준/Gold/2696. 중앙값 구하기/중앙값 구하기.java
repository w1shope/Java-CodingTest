import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(N / 2 + 1).append("\n");

            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

            int count = 0;
            for (int i = 0; i < N / 10 + 1; i++) {
                String[] inputs = br.readLine().split(" ");

                for (int j = 0; j < inputs.length; j++) {
                    int num = Integer.parseInt(inputs[j]);

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

                    if (j % 2 == 0) {
                        sb.append(max.peek()).append(" ");
                        count++;
                        if (count % 10 == 0) {
                            sb.append("\n");
                        }
                    }
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}