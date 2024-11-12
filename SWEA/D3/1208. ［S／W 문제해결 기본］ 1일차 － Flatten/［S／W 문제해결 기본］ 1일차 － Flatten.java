import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {

    static final int SIZE = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

            String[] inputs = br.readLine().split(" ");
            for (int i = 0; i < SIZE; i++) {
                int value = Integer.parseInt(inputs[i]);
                min.add(value);
                max.add(value);
            }

            for (int i = 0; i < n; i++) {
                int minValue = min.poll();
                min.add(minValue + 1);

                int maxValue = max.poll();
                max.add(maxValue - 1);
            }

            sb.append("#" + t + " ").append(max.peek() - min.peek()).append("\n");
        }

        System.out.println(sb);
    }
}