import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    static Deque<Integer> dq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            t = Integer.parseInt(br.readLine());
            initQue(br);

            int minus = 1;
            while (true) {
                int poll = dq.poll();
                if (poll - minus <= 0) {
                    dq.offer(0);
                    break;
                }
                dq.offer(poll - minus++);
                if (minus > 5) {
                    minus = 1;
                }
            }

            sb.append("#").append(t).append(" ");
            for (int num : dq) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void initQue(BufferedReader br) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        dq = new ArrayDeque<>();
        for (int num : inputs) {
            dq.offer(num);
        }
    }
}