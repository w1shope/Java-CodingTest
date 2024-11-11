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
                dq.offer(poll - minus);
                minus = (minus % 5) + 1;
            }

            sb.append("#" + t + " ");
            for (int num : dq) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void initQue(BufferedReader br) throws IOException {
        String[] inputs = br.readLine().split(" ");
        dq = new ArrayDeque<>();
        for(int i = 0; i < inputs.length; i++) {
            dq.offer(Integer.parseInt(inputs[i]));
        }
    }
}