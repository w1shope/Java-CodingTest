import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            maxHeap.add(Integer.parseInt(st.nextToken()));
        }

        int prev = -1;
        for (int i = 0; i < K; i++) {
            prev = maxHeap.poll();
        }

        System.out.println(prev);
    }
}