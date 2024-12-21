import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                sb.append(minHeap.isEmpty() ? 0 : minHeap.poll()).append("\n");
            } else {
                minHeap.offer(num);
            }
        }

        System.out.println(sb);
    }
}