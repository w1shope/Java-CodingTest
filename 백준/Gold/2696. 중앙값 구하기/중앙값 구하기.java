import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine()); // 원소 개수
            int m = n / 10; // 몇 줄 읽은 것인지?

            PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선순위 큐
            List<Integer> result = new ArrayList<>(); // 출력할 중간 값들
            boolean isOdd = true; // 홀수 여부, true : 홀수

            // 원소를 10개씩 끊어서 읽는다.
            // ex. 원소 개수가 23개일 경우, 3줄에 걸쳐서 읽는다.
            for (int i = 0; i <= m; i++) {
                String[] inputs = br.readLine().split(" ");
                for (int j = 0; j < inputs.length; j++) {
                    pq.offer(Integer.parseInt(inputs[j]));

                    // 홀수라면 중간 값을 result에 저장한다.
                    if (isOdd) {
                        result.add(getMiddleNumber(pq));
                    }
                    isOdd = !isOdd;
                }
            }

            // 중간 값들 출력
            sb.append(result.size()).append("\n");
            for (int i = 0; i < result.size(); i++) {
                sb.append(result.get(i));
                // 각 줄에 10개의 원소를 출력한다.
                // ex. 출력할 원소가 12개라면, 2줄에 걸쳐서 출력한다.
                sb.append((i + 1) % 10 == 0 ? "\n" : " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int getMiddleNumber(PriorityQueue<Integer> pq) {
        // 중간 값을 추출하기 위해, 임시로 추출한 값을 저장
        Stack<Integer> stack = new Stack<>();

        // 중간 값을 추출한다.
        int middleIdx = pq.size() / 2;
        for (int i = 0; i < middleIdx; i++) {
            stack.push(pq.poll());
        }
        int middleNum = pq.peek();

        // 추출한 원소들을 다시 큐에 저장한다.
        while (!stack.isEmpty()) {
            pq.offer(stack.pop());
        }

        // 중간 값 반환
        return middleNum;
    }
}