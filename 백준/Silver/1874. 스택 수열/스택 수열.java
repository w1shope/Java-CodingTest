import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Stack<Integer> st = new Stack<>();
        boolean[] popFlag = new boolean[n + 1]; // pop 여부

        // 첫 번째 입력
        int now = Integer.parseInt(br.readLine());
        for (int i = 1; i <= now; i++) {
            st.push(i);
            sb.append("+\n");
        }
        int prev = st.pop(); // 이전 입력
        popFlag[prev] = true;
        sb.append("-\n");

        boolean isBreak = false;
        for (int i = 1; i < n; i++) {
            now = Integer.parseInt(br.readLine());

            // 스택이 비어있거나, 이미 출력되었거나
            if (popFlag[now]) {
                isBreak = true;
                break;
            }

            // push : 이전 입력 < 현재 입력
            if (prev < now) {
                for (int j = prev + 1; j <= now; j++) {
                    st.push(j);
                    sb.append("+\n");
                }
                prev = st.pop();
                popFlag[prev] = true;
                sb.append("-\n");
            } else { // pop : 이전 입력 > 현재 입력
                if (st.isEmpty()) { // pop할 원소가 없을 때
                    isBreak = true;
                    break;
                }

                while (true) {
                    int pop = st.pop();
                    popFlag[pop] = true;
                    sb.append("-\n");
                    if (pop == now) {
                        break;
                    }
                }
            }
        }

        System.out.println(isBreak ? "NO" : sb);
    }
}