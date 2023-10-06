import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static PriorityQueue<Long> priorityQue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++)
            priorityQue.add(Long.parseLong(br.readLine()));

        long sum = 0L;
        while (priorityQue.size() > 1) {
            sum += compare();
        }

        System.out.println(sum);
    }

    private static long compare() {
        long num1 = priorityQue.poll();
        long num2 = priorityQue.poll();
        priorityQue.add(num1 + num2);
        return num1 + num2;
    }
}