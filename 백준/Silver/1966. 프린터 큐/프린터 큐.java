import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            Deque<Priority> deque = new ArrayDeque<>(); // 프린터 역할
            List<Integer> priorities = new ArrayList<>(); // 중요도를 담는 list, 추후에 내림차순 정렬
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int number = Integer.parseInt(input[j]);
                priorities.add(number);
                deque.offer(new Priority(j, number)); // 입력 순서대로 담는다.
            }

            Collections.sort(priorities, Collections.reverseOrder()); // 중요도 내림차순 정렬

            int idx = 0;
            int highestNumber = priorities.get(idx); // 가장 높은 중요도
            while (true) {
                Priority priority = deque.pollFirst(); // 프린터에서 가장 앞에서 대기 중인 Priority
                if (priority.number == highestNumber) { // 해당 Priority가 중요도가 높을 때
                    if (priority.order == m) { // 내가 찾는 값(m)일 때
                        sb.append((idx + 1) + "\n");
                        break;
                    } else { // 중요도는 가장 높으나, 내가 찾는 값이 아니라면, 다음으로 가장 높은 중요도를 프린터에서 탐색 진행
                        highestNumber = priorities.get(++idx);
                    }
                } else { // 프린터 가장 앞에 위치한 것이 중요도가 가장 높은게 아니라면, 가장 뒤로 보낸다.
                    deque.offer(priority);
                }
            }
        }

        System.out.println(sb.toString());
    }

    static class Priority {

        int order; // 처음에 Queue에 담긴 순서
        int number; // 값

        public Priority(int order, int number) {
            this.order = order;
            this.number = number;
        }
    }
}