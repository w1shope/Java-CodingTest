import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            final int n = Integer.parseInt(br.readLine()); // 숫자 개수
            List<String> numbers = new LinkedList<>(Arrays.asList(br.readLine().split(" ")));
            final int m = Integer.parseInt(br.readLine()); // 명령어 개수
            Queue<String> orders = new LinkedList<>(Arrays.asList(br.readLine().split(" ")));
            while (!orders.isEmpty()) {
                String order = orders.poll(); // 명령어, 삽입 or 삭제
                int x = Integer.parseInt(orders.poll()); // 위치
                int y = Integer.parseInt(orders.poll()); // 개수
                if ("I".equals(order)) { // 삽입
                    for (int i = 0; i < y; i++) {
                        numbers.add(x + i, orders.poll());
                    }
                } else { // 삭제
                    for (int i = 0; i < y; i++) {
                        numbers.remove(x);
                    }
                }
            }

            sb.append("#").append(t).append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(numbers.get(i)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}