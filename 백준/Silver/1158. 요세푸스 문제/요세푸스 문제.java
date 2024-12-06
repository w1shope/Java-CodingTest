import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        while (deque.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                deque.offer(deque.poll());
            }
            sb.append(deque.poll() + ", ");
        }

        sb.append(deque.poll() + ">");
        System.out.println(sb.toString());
    }
}