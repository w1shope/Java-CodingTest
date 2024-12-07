import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<int[]> dq = new ArrayDeque<>();
        String[] inputs = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            dq.offer(new int[]{i, Integer.parseInt(inputs[i - 1])});
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int[] poll = dq.poll(); // {풍선 번호, 회전 횟수}
            answer[i] = poll[0];

            if (dq.isEmpty()) {
                break;
            }

            int rotate = poll[1];
            if (rotate > 0) { // 오른쪽으로 이동
                for (int j = 0; j < rotate - 1; j++) {
                    dq.offer(dq.poll());
                }
            } else { // 왼쪽으로 이동
                for (int j = 0; j < -rotate; j++) {
                    dq.offerFirst(dq.pollLast());
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int idx : answer) {
            sb.append(idx + " ");
        }
        System.out.println(sb);
    }
}