import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int val = Integer.parseInt(br.readLine());
            sum += val;

            if (minHeap.size() == maxHeap.size()) {
                maxHeap.add(val);
            } else {
                minHeap.add(val);
            }

            if (!minHeap.isEmpty()) {
                if (maxHeap.peek() > minHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minHeap.poll());
                }
            }
        }

        System.out.println(sum / 5);
        System.out.println(maxHeap.poll());
    }
}