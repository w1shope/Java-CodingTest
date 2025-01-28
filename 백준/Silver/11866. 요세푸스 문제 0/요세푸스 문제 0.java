import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<Integer> que = new ArrayDeque<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            que.offer(i);
        }

        int count = 1;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (que.size() > 1) {
            if (count % M == 0) {
                sb.append(que.poll()).append(", ");
            } else {
                que.offer(que.poll());
            }
            count++;
        }
        sb.append(que.poll()).append(">");

        System.out.println(sb);
    }
}