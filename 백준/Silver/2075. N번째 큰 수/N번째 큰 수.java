import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static Queue<Integer> que = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (String s : input)
                que.offer(Integer.parseInt(s));
        }

        int count = 0;
        while (!que.isEmpty()) {
            int num = que.poll();
            if (++count == n) {
                System.out.println(num);
                break;
            }
        }
    }
}