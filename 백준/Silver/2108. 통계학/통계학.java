import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] frequency = new int[8001];
        int min = 4000, max = -4000;
        int sum = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            sum += val;
            frequency[val + 4000]++;

            min = Math.min(min, val);
            max = Math.max(max, val);

            if (minHeap.size() == maxHeap.size()) {
                maxHeap.offer(val);
            } else {
                minHeap.offer(val);
            }

            if (!minHeap.isEmpty()) {
                if (maxHeap.peek() > minHeap.peek()) {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(minHeap.poll());
                }
            }
        }

        double avg = Math.round((double) sum / N);
        int mid = maxHeap.poll();
        int range = max - min;

        int mostFrequency = 0;
        boolean isDuplicate = false;

        for (int i = 1; i < 8001; i++) {
            if (frequency[mostFrequency] == frequency[i]) {
                if (!isDuplicate) {
                    isDuplicate = true;
                    mostFrequency = i;
                }
            } else if (frequency[mostFrequency] < frequency[i]) {
                isDuplicate = false;
                mostFrequency = i;
            }
        }

        System.out.println((int) avg);
        System.out.println(mid);
        System.out.println(mostFrequency - 4000);
        System.out.println(range);
    }
}