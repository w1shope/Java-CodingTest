import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int N;
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String[] inputArr = br.readLine().split(" ");
            if (inputArr.length == 1) { // pop, size, empty, front, back
                sb.append(execute(inputArr[0]) + "\n");
            } else { // push
                dq.offer(Integer.parseInt(inputArr[1]));
            }
        }

        System.out.println(sb);
    }

    static int execute(String order) {
        if (dq.isEmpty()) {
            if ("pop".equals(order) || "front".equals(order) || "back".equals(order)) {
                return -1;
            }
        }

        switch (order) {
            case "pop":
                return dq.pollFirst();
            case "size":
                return dq.size();
            case "empty":
                return dq.isEmpty() ? 1 : 0;
            case "front":
                return dq.peekFirst();
            case "back":
                return dq.peekLast();
            default:
                return -1;
        }
    }

}