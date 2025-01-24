import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (N-- > 0) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        long sum = 0L;
        while (pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            sum += num1 + num2;
            pq.offer(num1 + num2);
        }

        System.out.println(sum);
    }
}