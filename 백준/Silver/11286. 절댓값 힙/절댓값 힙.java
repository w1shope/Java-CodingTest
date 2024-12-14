import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기값 n 설정
        int n = Integer.parseInt(br.readLine());

        // 우선순위 큐 설정
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            // 1. 절댓값이 낮은 값
            // 2. 절댓값이 갖다면, 실제로 낮은 값
            if (Math.abs(a) == Math.abs(b)) {
                return a - b;
            }
            return Math.abs(a) - Math.abs(b);
        });

        /**
         * n번을 입력받으면서,
         * 1. 0을 입력한다면 원소를 추출하고
         *  단, 비어있는 경우 0을 출력한다.
         * 2. 0이 아니라면 원소를 삽입한다.
         */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());

            // 0을 입력받았을 때
            if (val == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else { // 0이 아닌 자연수를 입력받았을 때
                pq.offer(val);
            }
        }

        // 출력
        System.out.println(sb);
    }
}