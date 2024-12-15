import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // T번의 과정을 반복한다.
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine()); // 원소 개수
            sb.append((n + 1) / 2).append("\n"); // 중앙 값의 개수

            // 두 개의 자료구조를 사용하여 중앙 값을 구한다.
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            int m = n / 10; // 몇 줄 입력받을 것인지?
            int printCnt = 0; // 출력 횟수, 한 줄에는 최대 10개의 숫자만 출력될 수 있다.
            for (int i = 0; i <= m; i++) {
                String[] inputs = br.readLine().split(" ");
                for (int j = 0; j < inputs.length; j++) {
                    int val = Integer.parseInt(inputs[j]); // 입력받은 숫자

                    // 최소 힙, 최대 힙 크기에 따라 숫자를 삽입할 위치를 결정한다.
                    if (minHeap.size() == maxHeap.size()) { // 사이즈가 동일하다면
                        maxHeap.add(val);
                    } else {
                        minHeap.add(val);
                    }

                    // 최소 힙의 Root 원소 < 최대 힙의 Root 원소라면,
                    // 두 원소를 교체한다.
                    if (!minHeap.isEmpty()) {
                        if (maxHeap.peek() > minHeap.peek()) {
                            swap(minHeap, maxHeap);
                        }
                    }

                    // 홀수 번째의 원소일 때, 중앙 값을 출력한다.
                    if (j % 2 == 0) {
                        sb.append(maxHeap.peek()).append(" ");

                        // 한 줄에 최대 10개의 원소를 출력할 수 있다.
                        if (++printCnt % 10 == 0) {
                            sb.append("\n");
                        }
                    }
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void swap(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        // 최대 힙 Root > 최소 힙 Root이므로,
        // 최대 힙에 최소 힙의 Root를 삽입해도, 여전히 최대 힙의 Root는 동일하다.
        maxHeap.add(minHeap.poll());
        minHeap.add(maxHeap.poll());
    }
}