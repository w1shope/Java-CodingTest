import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> oddQue = new ArrayDeque<>();
        Queue<Integer> evenQue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0) {
                evenQue.offer(i);
            } else {
                oddQue.offer(i);
            }
        }

        while (true) {
            if (oddQue.size() == 1 && evenQue.isEmpty()) {
                break;
            }

            oddQue.clear();

            boolean flag = false;
            int size = evenQue.size();
            for (int i = 0; i < size; i++) {
                if (!flag) {
                    oddQue.offer(evenQue.poll());
                } else {
                    evenQue.offer(evenQue.poll());
                }
                flag = !flag;
            }
        }

        System.out.println(oddQue.poll());


    }
}