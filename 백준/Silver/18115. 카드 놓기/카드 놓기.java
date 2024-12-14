import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 카드의 수 N 입력
        int n = Integer.parseInt(br.readLine());

        // N개의 명령어 저장
        Stack<String> orders = new Stack<>();
        for (String input : br.readLine().split(" ")) {
            orders.push(input);
        }

        // 숫자 삽입
        int num = 1;
        Deque<Integer> dq = new ArrayDeque<>();
        while (!orders.isEmpty()) {
            String order = orders.pop();
            if ("1".equals(order)) {
                // 가장 앞에 삽입
                dq.offerFirst(num++);
            } else if ("2".equals(order)) {
                // 앞에서 두 번째에 삽입
                int poll = dq.poll();
                dq.offerFirst(num++);
                dq.offerFirst(poll);
            } else {
                // 가장 뒤에 삽입
                dq.offer(num++);
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.poll()).append(" ");
        }
        System.out.println(sb);
    }
}