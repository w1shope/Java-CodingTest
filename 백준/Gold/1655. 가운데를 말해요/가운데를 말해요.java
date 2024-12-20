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

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            // 값 삽입
            if (minHeap.size() == maxHeap.size()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            // root 비교
            if (!minHeap.isEmpty()) {
                if (maxHeap.peek() > minHeap.peek()) {
                    swap(minHeap, maxHeap);
                }
            }

            // 중간값 출력
            if (i % 2 == 0) { // 짝수
                if (minHeap.isEmpty()) {
                    sb.append(maxHeap.peek()).append("\n");
                    continue;
                }
                sb.append(minHeap.peek() > maxHeap.peek() ? maxHeap.peek() : minHeap.peek()).append("\n");
            } else { // 홀수
                sb.append(maxHeap.peek()).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void swap(PriorityQueue<Integer> heap1, PriorityQueue<Integer> heap2) {
        heap1.add(heap2.poll());
        heap2.add(heap1.poll());
    }
}