import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int findIdx = Integer.parseInt(inputs[1]);

            List<Integer> priorities = new ArrayList<>();

            Queue<Problem> que = new LinkedList<>();
            inputs = br.readLine().split(" ");
            for (int idx = 0; idx < n; idx++) {
                int priority = Integer.parseInt(inputs[idx]);
                que.offer(new Problem(idx, priority));
                priorities.add(priority);
            }

            Collections.sort(priorities, Collections.reverseOrder());

            int printCount = 0;
            while (true) {
                Problem poll = que.poll();
                if (priorities.get(printCount) == poll.priority && poll.idx == findIdx) {
                    sb.append(printCount + 1).append("\n");
                    break;
                }

                if (poll.priority == priorities.get(printCount)) {
                    printCount++;
                } else {
                    que.offer(poll);
                }
            }
        }

        System.out.println(sb);
    }

    static class Problem {
        int idx;
        int priority;

        public Problem(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}