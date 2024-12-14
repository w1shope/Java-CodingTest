import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static int N;
    static PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> b - a); // 내림차순 정렬
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                print(); // Queue에 저장된 가장 작은 숫자 출력
            } else {
                que.offer(input);
            }
        }

        System.out.println(sb.toString());
    }

    static void print() {
        if (que.isEmpty()) {
            sb.append("0\n");
        } else {
            sb.append(que.poll() + "\n");
        }
    }
}