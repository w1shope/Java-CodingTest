import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static int N;
    static boolean[] visited;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int prev = 0;
        for (int i = 1; i <= N; i++) {
            int now = Integer.parseInt(br.readLine());
            if (now > prev) {
                for (int j = prev + 1; j <= now; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                prev = now;
                stack.pop();
                sb.append("-\n");
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        System.out.println("NO");
                        return;
                    }
                    sb.append("-\n");
                    int poll = stack.pop();
                    if (poll == now) {
                        break;
                    }
                }
            }
        }

        System.out.println(sb);
    }
}