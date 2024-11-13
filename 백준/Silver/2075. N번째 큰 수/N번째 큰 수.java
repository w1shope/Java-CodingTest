import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (String input : inputs) {
                int num = Integer.parseInt(input);
                if (pq.size() < N) {
                    pq.offer(num); // N개의 숫자를 채우지 못했다면
                } else if (num > pq.peek()) { // N개를 채웠을 때, 더 큰 숫자가 입력되었다면
                    pq.poll();
                    pq.offer(num);
                }
            }
        }

        System.out.println(pq.peek());
    }
}