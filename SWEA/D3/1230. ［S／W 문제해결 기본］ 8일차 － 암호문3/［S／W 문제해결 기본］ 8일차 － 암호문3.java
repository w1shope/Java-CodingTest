import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            final int n = Integer.parseInt(br.readLine()); // 암호문 개수
            List<String> numbers = Arrays.stream(br.readLine().split(" ")) // n개의 암호문
                    .collect(Collectors.toList());
            final int m = Integer.parseInt(br.readLine()); // 명령어 개수
            String[] list = br.readLine().split(" ");
            Queue<String> orders = new LinkedList<>(); // 담긴 명령어
            for (String order : list) {
                orders.add(order);
            }

            while (!orders.isEmpty()) { // m개의 명령어를 모두 수행
                String order = orders.poll(); // I or D or A
                if (order.equals("I")) { // 삽입
                    int x = Integer.parseInt(orders.poll()); // x번째 위치
                    int s = Integer.parseInt(orders.poll()); // 삽입할 숫자 개수
                    for (int i = 0; i < s; i++) {
                        numbers.add(x + i, orders.poll());
                    }
                } else if (order.equals("D")) { // 삭제
                    int x = Integer.parseInt(orders.poll()); // x번째 위치
                    int y = Integer.parseInt(orders.poll()); // 삭제할 개수
                    for (int i = 0; i < y; i++) {
                        numbers.remove(x + 1);
                    }
                } else { // 추가
                    int y = Integer.parseInt(orders.poll()); // 추가할 개수
                    for (int i = 0; i < y; i++) {
                        numbers.add(orders.poll());
                    }
                }
            }

            sb.append("#" + t + " ");
            for (int i = 0; i < 10; i++) {
                sb.append(numbers.get(i) + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}