import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] move = new int[n + 1]; // 풍선 번호 별로 적혀있는 숫자

        Deque<Integer> que = new ArrayDeque<>();
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(inputs[i]);
            move[i + 1] = val;
            que.offer(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        while (que.size() > 1) {
            int idx = que.poll();
            sb.append(idx).append(" ");

            if (move[idx] > 0) {
                iterator(que, true, move[idx] - 1);
            } else {
                iterator(que, false, Math.abs(move[idx]));
            }
        }

        sb.append(que.poll());
        System.out.println(sb);
    }

    static void iterator(Deque<Integer> que, boolean isLeftIterator, int iteratorCount) {
        if (isLeftIterator) {
            for (int i = 0; i < iteratorCount; i++) {
                que.offer(que.poll());
            }
        } else {
            for (int i = 0; i < iteratorCount; i++) {
                que.offerFirst(que.pollLast());
            }
        }
    }
}